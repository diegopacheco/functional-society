case class Produto(nome:String,valor:Double,promo:Boolean=false)

class Registradora {
  private var total : Double = 0.0
  
  private[Registradora] val produtos:Map[String,Produto] = Map(
						"chocolate" -> new Produto("chocolate",10,true),
						"camisinha" -> new Produto("camisinha",17,false),
						"chantily"  -> new Produto("chantily",25,false)
						)
  
  def registra(prod:Produto,qt:Int=1) = total += prod.valor * qt - calculaDesconto(prod, qt)
  
  private [Registradora] def calculaDesconto(prod:Produto, qt:Int) :Double ={
    if(prod.promo && qt >= 3) prod.valor * Math.floor(qt/3)
    else 0
  }
  
  def scan(nome:String,qt:Int=1) = registra(produtos(nome),qt)
  
  def pagar(valor:Double)(cupom:String="") : Double = {
    if (cupom == "cupom25") total -= (total * 0.5)
    var troco = valor - total
    total = 0.0
    troco
  }
  
  def valorTotal = total
  
}