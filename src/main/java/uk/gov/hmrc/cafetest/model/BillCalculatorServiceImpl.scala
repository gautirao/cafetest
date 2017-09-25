package uk.gov.hmrc.cafetest.model

class BillCalculatorServiceImpl extends BillCalulatorService {

  def calculateStandarBill(order: List[Item]): Double = {

    var total: Double = 0

    order.foreach { item => total += item.price }
    return total
  }

  def containsDrinkOnly(order: List[Item]): Boolean = {

    var onlyDrinks: Boolean = true;

    order.foreach { item =>
      {
        if (!item.isInstanceOf[Drink]) {
          onlyDrinks = false
        }
      }
    }

    return onlyDrinks;

  }

  def containsHotFood(order: List[Item]): Boolean = {

    var hotFood: Boolean = false;

    order.foreach { item =>
      {
        if (item.isInstanceOf[Food] && item.itemType == ItemType.HOT) {
          hotFood = true
        }
      }
    }

    return hotFood;

  }

  def calculateTotal(order: List[Item]) : Double = {

    var standardBill: Double = calculateStandarBill(order)

    var serviceCharge: Double = 0;
    if (!containsDrinkOnly(order)) serviceCharge = .1;
    if (containsHotFood(order)) serviceCharge = .2;

    var totalBill: Double = standardBill + standardBill * serviceCharge;
    
    return totalBill
  }

}