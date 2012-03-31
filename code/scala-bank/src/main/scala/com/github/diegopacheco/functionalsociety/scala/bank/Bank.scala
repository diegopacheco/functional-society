package com.github.diegopacheco.functionalsociety.scala.bank

import akka.stm._

case class Account(number:Int,owner:String, var value:BigDecimal = 0)

class BankSystem {

    private[BankSystem] var accounts = Ref(scala.collection.mutable.Map[Int, Account]())
    private[BankSystem] var numbers  = Ref(99)
    
    private[BankSystem] val inc = (i: Int) => i + 1
    
    def createAccount(name: String, initialValue: Int = 0): Account = {    		
        var accountNumber:Int = 0
        atomic {
            numbers alter inc
            accountNumber = numbers.get
        }
        
        alterAccount(new Account(accountNumber, name, initialValue))
    }
    
    def checkBalance(number:Int):BigDecimal = {
        atomic {
            return accounts.get()(number).value
        }
    }  
    
    def deposit(accountNumber:Int,value:BigDecimal):Unit = {
        atomic{
            val account:Account = getAccount(accountNumber)
            if (value <= 0 )  throw new IllegalStateException("The bank accout: %s " + accountNumber + " cannot deposit: " + value)
            
            account.value += value
            alterAccount(account)
        }       
    }
    
    def withdrawl(accountNumber:Int,value:BigDecimal):BigDecimal = {
        atomic{
            val account:Account = getAccount(accountNumber)
            if (account.value < value) throw new IllegalStateException("The bank accout: %s " + accountNumber + " does not have enough money for the withdrawl. balance: " + account.value)
            
            account.value -= value
            alterAccount(account)
            value
        }
    }
    
    def transfer(acc1From:Int,acc2To:Int,value:BigDecimal):BigDecimal = {
        atomic{
             var account1 = getAccount(acc1From)
             var account2 = getAccount(acc2To)
             
             if (value <= 0 ) throw new IllegalStateException("The bank transfer cannot happen because invalid value. value: " + value)
             if (account1.value < value ) throw new IllegalStateException("The bank transfer cannot happen because you dont have enought money. balance: " + 
                     								account1.value + " value: " + value)
             
             account2.value += value
             account1.value -= value
             
             alterAccount(account1)
             alterAccount(account2)
        }
        value
    }
    
    private[BankSystem] def alterAccount(acc:Account):Account = {
        atomic{
            accounts alter (  _+= (acc.number -> acc)  )
        }
        acc
    }  
    
    private[BankSystem] def getAccount(accountNumber:Int):Account = {
        atomic{
             try{
                 return accounts.get()(accountNumber)
             }catch {
             	case e:NoSuchElementException => throw new IllegalStateException("The bank accout: %s " + accountNumber + " does not exist!")
             }
        }
    } 

}