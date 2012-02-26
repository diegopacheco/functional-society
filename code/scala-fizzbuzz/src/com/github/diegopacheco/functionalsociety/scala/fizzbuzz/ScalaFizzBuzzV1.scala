package com.github.diegopacheco.functionalsociety.scala.fizzbuzz

object ScalaFizzBuzzV1 {
	def fizzbuzz(f:Int,t:Int):List[String] = {
	    var result:List[String] = List()
	    for(i <- f to t){    
	       i match {
	           case _ if (i % 5 == 0 && i % 3 == 0) => result ::= "fizzbuzz"
	           case _ if (i % 5 == 0)               => result ::= "buzz"
	           case _ if (i % 3 == 0)               => result ::= "fizz"
	           case _                               => result ::= i.toString
	       }	       
	    }
	    result.reverse
	}
}