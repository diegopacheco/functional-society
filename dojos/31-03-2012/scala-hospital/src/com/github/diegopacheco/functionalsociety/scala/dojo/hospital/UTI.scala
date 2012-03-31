package com.github.diegopacheco.functionalsociety.scala.dojo.hospital

class UTI(val doctors:List[Doctor] = List(new Doctor)) {
	
    def execute(patients:List[Patient]) : List[Patient] = {
        def getTime(d:String):Int = if (d == "SIDA") 3 else 1 
        def setTime(p:Patient):Patient = { 
            p.time=getTime(p.disease)
            p
        }
        patients.map( x => setTime(x))
    }
    
}

case class Patient(val name:String="",val disease:String="", var time:Int = 0) {}

case class Doctor(val name:String="",val speciality:String = "General")
