package uk.gov.hmrc.cafetest.model

trait Item {
  val name: String
    val price: Double
    var itemType: ItemType.Value = ItemType.COLD;
}