
case class Contact(name:String,email:String,phone:String)

class ContactAdressSystem{
  
    private[ContactAdressSystem] var contacts = scala.collection.mutable.Map[String,Contact]()
    
    def add(contact:Contact):Unit = contacts += contact.name -> contact  
    
    def remove(name:String):Contact = contacts.remove(name).getOrElse(null)
    
    def list:List[Contact] = contacts.values.toList;
    
    def search(name:String):List[Contact] = contacts.values.toList.filter( _.name == name )
    
}