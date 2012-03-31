import org.junit.Before
import org.junit.Test
import junit.framework.Assert._

class ContactAdressTest {
	
    var contacts = new ContactAdressSystem 
    
    @Before def setUp():Unit = contacts = new ContactAdressSystem 
  
    @Test def testAddOneContact(){
        val c = new Contact("Diego","barbarian@crom.com","1234567")
        contacts.add(c)
        assertEquals( contacts.list.size, 1 )
        assertTrue( contacts.list.contains(c) )
    }
    
    @Test def testRemoveOneContact(){
        val c = new Contact("Diego","barbarian@crom.com","1234567")
        contacts.add(c)
        assertEquals( contacts.list.size, 1 )
        assertTrue( contacts.list.contains(c) )
        
        val c2 = contacts.remove("Diego")
        assertEquals(c, c2)
        assertEquals( contacts.list.size, 0 )
        assertFalse( contacts.list.contains(c2) )
    }
    
    @Test def testSearchOneContact(){
        val c = new Contact("Diego","barbarian@crom.com","1234567")
        contacts.add(c)
        assertEquals( contacts.list.size, 1 )
        assertTrue( contacts.list.contains(c) )
        
        val cs:List[Contact] = contacts.search("Diego")
        assertEquals(c, cs(0))
        assertEquals( contacts.list.size, 1 )
        assertTrue( contacts.list.contains(cs(0)) )
    }
    
}