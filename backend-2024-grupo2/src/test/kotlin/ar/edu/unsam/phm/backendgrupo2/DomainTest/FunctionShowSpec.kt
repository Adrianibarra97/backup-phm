package ar.edu.unsam.phm.backendgrupo2.DomainTest

import ar.edu.unsam.phm.backendgrupo2.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate
import java.time.LocalDateTime

class FunctionShowSpec: DescribeSpec ({

  isolationMode = IsolationMode.InstancePerTest

  describe("Test function show funcionality"){

    it("Test tickets by seatType funcionality"){

      //Arrange
      val consumer: Consumer = Consumer("Consumer")
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

      val seatTypePlateaAlta = SeatType("Platea Alta",5000, 10000.0.toBigDecimal())
      val seatTypeCampo = SeatType("Campo",7000, 15000.0.toBigDecimal())
      val seatTypePalco = SeatType("Palco",8000, 20000.0.toBigDecimal())

      val ticketACDC1 = Ticket(seatTypePlateaAlta, adrian)
      val ticketACDC2 = Ticket(seatTypePlateaAlta, adrian)
      val ticketACDC3 = Ticket(seatTypePlateaAlta, adrian)
      val ticketACDC4 = Ticket(seatTypePalco, adrian)
      val ticketACDC5 = Ticket(seatTypeCampo, adrian)
      val functionShowACDC = FunctionShow(LocalDateTime.of(2026,12,1,19,0,0))

      functionShowACDC.addTicketsToFunction(mutableListOf(ticketACDC1,ticketACDC2,ticketACDC3,ticketACDC4,ticketACDC5))
      //Act
      val amountTicketsPerSeatType = functionShowACDC.ticketsBySeatType(seatTypePlateaAlta)

      //Arrange
      amountTicketsPerSeatType.shouldBe(3)
    }
  }
})