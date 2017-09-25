package uk.gov.hmrc.cafetest.model

  case  class Drink(name: String, price: Double) extends Item {

    def this(name: String, price: Double, itemType: ItemType.Value) = {
      this(name, price)
      this.itemType = itemType
    }

  }