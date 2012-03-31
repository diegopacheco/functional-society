package com.github.diegopacheco.functionalsociety.sacala.dojo.hospital

import org.junit.Assert._
import org.junit.Test
import com.github.diegopacheco.functionalsociety.scala.dojo.hospital._

class UTITest {
	
    @Test
    def testOrderAndTimes():Unit = {
        val uti:UTI = new UTI
        var patientes:List[Patient] = List()
        patientes = new Patient()::patientes
        val time:Long = uti.execute(patientes).foldLeft(0)( (y:Int,x:Patient) => y + x.time )
        assertEquals(1,time)
    }
    
    @Test
    def testOrderAndTimesWithDiseases {
        val uti:UTI = new UTI
        val patientes:List[Patient] = List(new Patient("Cuervo","SIDA"))
        val time:Long = uti.execute(patientes).foldLeft(0)((x:Int,y:Patient) => x + y.time) 
        assertEquals(3,time)
    }
    
    @Test
    def testOrderAndTimesWithDoctors {
        val doctors:List[Doctor] = List(new Doctor, new Doctor)
        val uti:UTI = new UTI(doctors)
        val patientes:List[Patient] = List(new Patient(disease = "SIDA"), new Patient(disease = "SIDA"))
        val time:Int = uti.execute(patientes).foldLeft(0)( (x:Int,y:Patient) => x + y.time) / doctors.length
        assertEquals(3,time)
    }
    
    
}