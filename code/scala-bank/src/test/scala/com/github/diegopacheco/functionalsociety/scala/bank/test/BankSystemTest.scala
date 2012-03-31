package com.github.diegopacheco.functionalsociety.scala.bank.test

import org.junit.Before
import org.junit.Test
import junit.framework.Assert._
import com.github.diegopacheco.functionalsociety.scala.bank.BankSystem
import com.github.diegopacheco.functionalsociety.scala.bank.Account
import org.junit.rules.ExpectedException

class BankSystemTest {
	
    var bank = new BankSystem
    
    @Before def setUp():Unit = bank = new BankSystem
    
    @Test def testCreatAccount():Unit = {
        val account = bank.createAccount("Diego Pacheco", 1000)
        println(account)
        assertNotNull(account)
        assertEquals(account.owner, "Diego Pacheco")
        assertEquals(account.value, 1000)
    }
    
    @Test def testCheckBalanceAccount():Unit = {
        val account = bank.createAccount("Diego Pacheco", 2000)
        val balance = bank.checkBalance(account.number)
        println(balance)
        
        assertNotNull(balance)
        assertEquals(BigDecimal.apply(2000), balance)
    }
    
    @Test def testDeposit500():Unit = {
        val account = bank.createAccount("Diego Pacheco", 1000)
        var balance = bank.checkBalance(account.number)
        println(balance)
        
        assertNotNull(balance)
        assertEquals(BigDecimal.apply(1000), balance)
        bank.deposit(account.number, 500)
        
        balance = bank.checkBalance(account.number)
        assertNotNull(balance)
        assertEquals(BigDecimal.apply(1500), balance)
    }
    
    @Test(expected=classOf[IllegalStateException]) def testDeposit500InvalidAccount():Unit = {
         bank.deposit(77, 500)
    }
    
    @Test(expected=classOf[IllegalStateException]) def testDepositMinus500InvalidValue():Unit = {
         val acc = bank.createAccount("Diego Pacheco", 1000)
         bank.deposit(acc.number, -500)
    }
    
    @Test def testWithdrawl250():Unit = {
        val account = bank.createAccount("Diego Pacheco", 1000)
        var balance = bank.checkBalance(account.number)
        println(balance)
        
        assertNotNull(balance)
        assertEquals(BigDecimal.apply(1000), balance)
        bank.deposit(account.number, 500)
        
        balance = bank.checkBalance(account.number)
        assertNotNull(balance)
        assertEquals(BigDecimal.apply(1500), balance)
        
        balance = bank.withdrawl(account.number, 250)
        assertNotNull(balance)
        assertEquals(BigDecimal.apply(250), balance)
        assertEquals(BigDecimal.apply(1250), bank.checkBalance(account.number))
    }
    
    @Test(expected=classOf[IllegalStateException]) def testWithDrwal100NotEnoughMoney():Unit = {
         val acc = bank.createAccount("Diego Pacheco", 1000)
         bank.withdrawl(acc.number, 1100)
    }   
    
    @Test def testTransfer1000():Unit = {
        val account1 = bank.createAccount("Diego Pacheco", 2000)
        val account2= bank.createAccount("Conan The Barbarian", 0)
        
        val balance = bank.transfer(account1.number, account2.number, 1000)
        assertNotNull(balance)
        assertEquals(BigDecimal.apply(1000), balance)
        
        assertEquals(BigDecimal.apply(1000), bank.checkBalance(account1.number))
        assertEquals(BigDecimal.apply(1000), bank.checkBalance(account2.number))
    }
    
}