package com.github.diegopacheco.functionalsociety.scala.calculator

import junit.framework.TestCase
import junit.framework.Assert._
import com.github.diegopacheco.functionalsociety.scala.calculator.ScalaCalculatorV1._

class ScalaCalculatorV1Test extends TestCase{	
	def test_sum_1_3_mustbe_4 = assertEquals(4.0,calc(1,3,"+"))
	def test_sum_7_2_mustbe_5 = assertEquals(5.0,calc(7,2,"-"))
	def test_sum_9_3_mustbe_3 = assertEquals(3.0,calc(9,3,"/"))
	def test_sum_4_2_mustbe_8 = assertEquals(8.0,calc(4,2,"*"))
	def test_except_exception():Unit = {
	  try{
	    calc(1,1,"#")
	    fail
	  }catch{
	    case e:RuntimeException => Unit
	  }
	}
}