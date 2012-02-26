package com.github.diegopacheco.functionalsociety.scala.calculator

import junit.framework.TestCase
import junit.framework.Assert._
import com.github.diegopacheco.functionalsociety.scala.calculator.ScalaCalculatorV2._

class ScalaCalculatorV2Test extends TestCase{	
	def test_sum_1_3_mustbe_4 = assertEquals(4.0, 1 plus 3)
	def test_sum_7_2_mustbe_5 = assertEquals(5.0, 7 minus 2)
	def test_sum_9_3_mustbe_3 = assertEquals(3.0, 9 divided 3)
	def test_sum_4_2_mustbe_8 = assertEquals(8.0, 4 multiplied 2)
}