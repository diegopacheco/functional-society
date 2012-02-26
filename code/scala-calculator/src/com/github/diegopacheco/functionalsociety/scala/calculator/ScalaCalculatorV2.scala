package com.github.diegopacheco.functionalsociety.scala.calculator

class ScalaCalculatorV2(val a:Double) {
   def plus(b:Double):Double = a + b
   def minus(b:Double):Double = a - b
   def divided(b:Double):Double = a / b
   def multiplied(b:Double):Double = a * b
}

object ScalaCalculatorV2{  
  implicit def convertDouble2ScalaCalculatorV2(a:Double) = new ScalaCalculatorV2(a)
}