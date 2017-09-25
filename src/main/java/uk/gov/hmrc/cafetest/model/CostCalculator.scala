package uk.gov.hmrc.cafetest.model

object CostCalculator extends App {

 





  
  val order = List[Item] ( new Drink("Cola",.5,ItemType.COLD)  ,
                              new Drink("Coffee",1.0,ItemType.HOT) ,
                              new Food("Cheese Sandwic",2.0,ItemType.HOT)
    )
  
   var calculator:BillCalulatorService = new BillCalculatorServiceImpl()
  
  println(" Total bill is : "+calculator.calculateTotal(order))

  		
  		
  		
  		
}