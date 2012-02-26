package com.github.diegopacheco.functionalsociety.scala.calculator

object ScalaCalculatorV1 {
	
  //Main issue: You can pass wrong functions like #
  def calc(a:Double,b:Double,op:String):Double = op match {
	  case "+"  => a + b
	  case "-"  => a - b
	  case "*"  => a * b
	  case "/"  => a / b
	  case _    => throw new RuntimeException("Don't know how to compute!")
  }
  
}