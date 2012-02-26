package com.github.diegopacheco.functionalsociety.scala.fizzbuzz

import junit.framework.TestCase
import junit.framework.Assert._
import com.github.diegopacheco.functionalsociety.scala.fizzbuzz.ScalaFizzBuzzV1._

class ScalaFizzBuzzV1Test extends TestCase{
   
    def test_1_to_15_fizzbuzz():Unit = {
       val fizzbuzz_1_15  = List("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz")
       assertEquals(fizzbuzz_1_15,fizzbuzz(1,15)) 
    }
    
    def test_15_to_30_fizzbuzz():Unit = {
       val fizzbuzz_15_30 = List("fizzbuzz", "16", "17", "fizz", "19", "buzz", "fizz", "22", "23", "fizz", "buzz", "26", "fizz", "28", "29", "fizzbuzz")
       assertEquals(fizzbuzz_15_30,fizzbuzz(15,30)) 
    }
    
}
