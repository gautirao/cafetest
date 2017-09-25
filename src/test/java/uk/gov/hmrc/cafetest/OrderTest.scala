package uk.gov.hmrc.cafetest
import org.scalatest.Assertions
import org.junit.Test
import uk.gov.hmrc.cafetest.model.Order
import uk.gov.hmrc.cafetest.model.ItemType
import uk.gov.hmrc.cafetest.model.Drink
import uk.gov.hmrc.cafetest.model.Food

class OrderTest extends Assertions {
  
  

  @Test def drinksOnlyOrderShouldChargeNoServiceCharge() {
    val order = new Order
 
    order.addItem( new Drink("Cola",.5,ItemType.COLD))
    order.addItem( new Drink("Coffee",1.0,ItemType.HOT) )
 
    
    val standardBill:Double = order.calculateStandardBill
    assert( standardBill === 1.5)
    assert(order.calculateServiceCharge(standardBill) === 0)
  }

  @Test def drinksAndFoodOrderShouldChargeNoServiceChargeOf10Percent() {
     
        val order = new Order
 
    order.addItem(  new Drink("Cola",.5,ItemType.COLD) )
    order.addItem(   new Food("Cheese Sandwich",2.0,ItemType.COLD) )
 
    
    val standardBill:Double = order.calculateStandardBill
    assert( standardBill === 2.5)
    assert(order.calculateServiceCharge(standardBill) === .25)
    
  }

  @Test def drinksAndHotFoodOrderShouldChargeNoServiceChargeOf20Percent() {
	  
         
        val order = new Order
 
    order.addItem(  new Drink("Cola",.5,ItemType.COLD))
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
 
    
    val standardBill:Double = order.calculateStandardBill
    assert( standardBill === 5)
    assert(order.calculateServiceCharge(standardBill) === 1)
  }
  
  @Test def serviceChargeShouldBeChargedAt20ForLargeOrder() {
	  
    
            val order = new Order
 
    order.addItem(  new Drink("Cola",.5,ItemType.COLD))
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    order.addItem(  new Food("Steak Sandwich",4.5,ItemType.HOT) )
    
        val standardBill:Double = order.calculateStandardBill
        assert(order.calculateServiceCharge(standardBill) === 20)

  }
  
  

}