import org.junit.Test
import org.junit.Assert._
import org.junit.Before

class RegistradoraTest {
  
  var reg:Registradora = null
  
  @Before
  def initRegistradora = reg = new Registradora
  
  @Test
  def registraProdutoTotal{
    reg.registra(new Produto("",100), 2)
    reg.registra(new Produto("",300))
    assertEquals(reg.valorTotal, 500, 0.1)
  }
  
  @Test
  def scannerProdTest{
    reg.scan("chocolate")
    reg.scan("camisinha")
    assertEquals(reg.valorTotal, 27, 0.1)
  }
  
  @Test
  def cupomTest{
    reg.scan("chocolate")
    reg.pagar(5.0)("cupom25")
    assertEquals(0.0, reg.valorTotal, 0.1)
  }
  
  @Test
  def qtdScanTest{
    reg.scan("chocolate",10)
    reg.pagar(70)("montenegro")
    assertEquals(0.0, reg.valorTotal, 0.1)
  }

  
  @Test
  def leve3pague2{
    reg.scan("chocolate",3)
    assertEquals(reg.valorTotal,20,0.1)
  }
  
  @Test
  def leve9pague6{
    reg.scan("chocolate",9)
    assertEquals(reg.valorTotal,60,0.1)
  }
  
  @Test
  def leve7pague5{
	  reg.scan("chocolate",7)
	  assertEquals(reg.valorTotal, 50,0.1)
  }
  
  @Test def pagarContaTest{
    reg.scan("chocolate", 5)
    assertEquals(10, reg.pagar(50.0)(), 0.1)
    assertEquals(0, reg.valorTotal, 0.1)
  }
}