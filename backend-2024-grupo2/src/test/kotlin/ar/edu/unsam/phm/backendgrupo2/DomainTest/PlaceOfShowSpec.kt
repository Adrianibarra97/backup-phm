package ar.edu.unsam.phm.backendgrupo2.DomainTest

import ar.edu.unsam.phm.backendgrupo2.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.channels.ticker
import java.time.LocalDate

class PlaceOfShowSpec:  DescribeSpec ({

  isolationMode = IsolationMode.InstancePerTest
  val consumer: Consumer = Consumer("Consumer")
  describe("Test place of show functionality"){

    it("Test the amount seats per type place of show"){
      val adrian: User = User(
        "Adrian",
        "Ibarra",
        "adri9730",
        "https://www.image.com/resources/adrian-ibarra",
        "Francia",
        LocalDate.of(1997, 3, 30),
        40258359,
        12345,
        1.1.toBigDecimal(),
        consumer
      )

      //Arrange
      val seatTypePlateaAlta = SeatType("Platea Alta",5000, 10000.0.toBigDecimal())
      val seatTypeCampo = SeatType("Campo",7000, 15000.0.toBigDecimal())
      val seatTypePalco = SeatType("Palco",8000, 20000.0.toBigDecimal())

      val riverPlateLocation = Location(34.545277777778, -58.449722222222)
      val riverPlatePlaceOfShow = Stadium("Estadio River Plate", riverPlateLocation, 80000.toBigDecimal())

      val ticketACDC1 = Ticket(seatTypePlateaAlta, adrian)
      val ticketACDC2 = Ticket(seatTypeCampo, adrian)
      val ticketACDC3 = Ticket(seatTypePalco, adrian)

      riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1,ticketACDC2, ticketACDC3))

      //Act
      val amountPlacesPlateaAlta = riverPlatePlaceOfShow.amountSeatsPerType(seatTypePlateaAlta)
      val amountPlacesCampo = riverPlatePlaceOfShow.amountSeatsPerType(seatTypeCampo)
      val amountPlacesPalco = riverPlatePlaceOfShow.amountSeatsPerType(seatTypePalco)

      //Assert
      amountPlacesPlateaAlta.shouldBe(5000)
      amountPlacesCampo.shouldBe(7000)
      amountPlacesPalco.shouldBe(8000)
    }
  }
})