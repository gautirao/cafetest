

package uk.gov.hmrc.cafetest.model
import scala.collection.mutable.ListBuffer
class Order {
  
  var drinksOnly : Boolean = true
  var includesFood: Boolean = false
  var containsHotFood : Boolean = false
  
  
  val itemList:ListBuffer[Item] = ListBuffer[Item]()
  
  def addItem(item:Item) ={
    
    if( item.isInstanceOf[Food] ){
      
      drinksOnly = false;

      if( item.itemType == ItemType.HOT){
        containsHotFood = true
      }
      includesFood = true;
    } 
    
    itemList+=item
    
  }
  
def calculateServiceCharge( stdBill:Double) :Double = {
      
      var serviceCharge = 0.0

            
      if( includesFood ){
        serviceCharge = stdBill * .1;
      }
      
      if( containsHotFood ) {
    	  serviceCharge = stdBill * .2;
      }
        
      if ( serviceCharge > 20 ) {
        return 20
      }else {
        return serviceCharge
      }
        
    }

  def calculateStandardBill : Double = {
    
    var total:Double = 0
    
    for( itm <- itemList )
    {
      total += itm.price
    }
    
    return total;
    
  }
  
  def getTotalBill : Double = {
    
    val stdBill : Double = calculateStandardBill
    return stdBill  + calculateServiceCharge(stdBill)
    
  }
}