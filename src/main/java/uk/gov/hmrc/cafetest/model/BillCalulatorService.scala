package uk.gov.hmrc.cafetest.model

trait BillCalulatorService {
  
	def calculateTotal( order : List[Item]) : Double
}