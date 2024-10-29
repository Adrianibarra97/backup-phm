package ar.edu.unsam.phm.backendgrupo2.DomainTest

import ar.edu.unsam.phm.backendgrupo2.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate
import java.time.LocalDateTime

class TicketSpec: DescribeSpec({

  isolationMode = IsolationMode.InstancePerTest
  val consumer: Consumer = Consumer("Consumer")

  describe("Test the Cost of the tickets") {

    it("Calculate the cost of a ticket in Stadium River Plate with StatusShow Precio Base and seatType Platea Alta") {

      //Arrange
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

      val seatTypePlateaAlta = SeatType("Platea Alta", 5000, 10000.0.toBigDecimal())
      val riverPlateLocation = Location(34.545277777778, -58.449722222222)
      val riverPlatePlaceOfShow = Stadium("Estadio River Plate", riverPlateLocation, 80000.toBigDecimal())
      val statusRiverPlateShow = StatusShow("PrecioBase", 1.8.toBigDecimal())
      val showACDC = Show(
        "AC-DC",
        riverPlatePlaceOfShow,
        "Power up Tour",
        100000.00.toBigDecimal(),
        statusRiverPlateShow,
        img = "src/main/resources/assets/acdc.jpg"
      )
      val ticketACDC1 = Ticket(seatTypePlateaAlta, adrian)

      //Act
      riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1))
      val ticketCostACDC = ticketACDC1.cost(riverPlatePlaceOfShow, showACDC).toDouble()

      //Assert
      ticketCostACDC.shouldBe(22.0)
    }

    it("Calculate the cost of a ticket in Stadium River Plate with StatusShow Precio Base and seatType Palco") {

      //Arrange
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

      val seatTypePalco = SeatType("Palco", 8000, 20000.0.toBigDecimal())
      val riverPlateLocation = Location(34.545277777778, -58.449722222222)
      val riverPlatePlaceOfShow = Stadium("Estadio River Plate", riverPlateLocation, 80000.toBigDecimal())
      val statusRiverPlateShow = StatusShow("PrecioBase", 1.8.toBigDecimal())
      val showACDC = Show(
        "AC-DC",
        riverPlatePlaceOfShow,
        "Power up Tour",
        100000.00.toBigDecimal(),
        statusRiverPlateShow,
        img = "src/main/resources/assets/acdc.jpg"
      )
      val ticketACDC1 = Ticket(seatTypePalco, adrian)

      //Act
      riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1))
      val ticketCostACDC = ticketACDC1.cost(riverPlatePlaceOfShow, showACDC).toDouble()

      //Assert
      ticketCostACDC.shouldBe(15.0)
    }

    it("Calculate the cost of a ticket in Stadium River Plate with StatusShow Precio Base and seatType Campo") {

      //Arrange
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

      val seatTypeCampo = SeatType("Campo", 8000, 15000.0.toBigDecimal())
      val riverPlateLocation = Location(34.545277777778, -58.449722222222)
      val riverPlatePlaceOfShow = Stadium("Estadio River Plate", riverPlateLocation, 80000.toBigDecimal())
      val statusRiverPlateShow = StatusShow("PrecioBase", 1.8.toBigDecimal())
      val showACDC = Show(
        "AC-DC",
        riverPlatePlaceOfShow,
        "Power up Tour",
        100000.00.toBigDecimal(),
        statusRiverPlateShow,
        img = "src/main/resources/assets/acdc.jpg"
      )
      val ticketACDC1 = Ticket(seatTypeCampo, adrian)

      //Act
      riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1))
      val ticketCostACDC = ticketACDC1.cost(riverPlatePlaceOfShow, showACDC).toDouble()

      //Assert
      ticketCostACDC.shouldBe(14.4)
    }

    it("Calculate the cost of a ticket in Theater Colon with StatusShow Precio Base and seatType Pullman"){

      //Arrange
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
      val seatTypePullman = SeatType("Pullman",6000, 10000.0.toBigDecimal())
      val teatroColonLocation = Location(-58.3831868989758, -34.6010855)
      val teatroColonPlaceOfShow = Theater("Teatro Colon",teatroColonLocation,100000.toBigDecimal(),  false)
      val statusTeatroColonShow = StatusShow("PrecioBase",1.8.toBigDecimal())
      val megadeth = Show(
        "Megadeth",
        teatroColonPlaceOfShow,
        "Movistar Arena Tour",
        100000.00.toBigDecimal(),
        statusTeatroColonShow,
        "src/main/resources/assets/megadeth.jpg"
      )
      val ticketMegadeth= Ticket(seatTypePullman, adrian)

      //Act
      teatroColonPlaceOfShow.setTickets(mutableListOf(ticketMegadeth))
      val ticketCostMegadeth = ticketMegadeth.cost(teatroColonPlaceOfShow,megadeth).toDouble()

      //Assert
      ticketCostMegadeth.shouldBe(18.3)
    }

    it("Calculate the cost of a ticket in Theater Colon with StatusShow Precio Base and seatType Platea Baja"){

      //Arrange
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
      val seatTypePlateaBaja = SeatType("Platea Baja",6000, 15000.0.toBigDecimal())
      val teatroColonLocation = Location(-58.3831868989758, -34.6010855)
      val teatroColonPlaceOfShow = Theater("Teatro Colon",teatroColonLocation,100000.toBigDecimal(),  false)
      val statusTeatroColonShow = StatusShow("PrecioBase",1.8.toBigDecimal())
      val megadeth = Show(
        "Megadeth",
        teatroColonPlaceOfShow,
        "Movistar Arena Tour",
        100000.00.toBigDecimal(),
        statusTeatroColonShow,
        "src/main/resources/assets/megadeth.jpg"
      )
      val ticketMegadeth= Ticket(seatTypePlateaBaja, adrian)
      //Act

      teatroColonPlaceOfShow.setTickets(mutableListOf(ticketMegadeth))
      val ticketCostMegadeth = ticketMegadeth.cost(teatroColonPlaceOfShow,megadeth).toDouble()

      //Assert
      ticketCostMegadeth.shouldBe(19.2)
    }
  }

  describe("Test the price of the tickets"){

    it("Calculate the price of a ticket in Stadium River Plate with StatusShow Precio Base and seatType Platea Alta"){

      //Arrange
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

      val seatTypePlateaAlta = SeatType("Platea Alta", 5000, 10000.0.toBigDecimal())
      val riverPlateLocation = Location(34.545277777778, -58.449722222222)
      val riverPlatePlaceOfShow = Stadium("Estadio River Plate", riverPlateLocation, 80000.toBigDecimal())
      val statusRiverPlateShow = StatusShow("PrecioBase", 1.8.toBigDecimal())
      val showACDC = Show(
        "AC-DC",
        riverPlatePlaceOfShow,
        "Power up Tour",
        100000.00.toBigDecimal(),
        statusRiverPlateShow,
        img = "src/main/resources/assets/acdc.jpg"
      )
      val ticketACDC1 = Ticket(seatTypePlateaAlta, adrian)

      //Act
      riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1))
      val ticketCostACDC = ticketACDC1.price(showACDC).toDouble()

      //Assert
      ticketCostACDC.shouldBe(39.6).toDouble()
    }

    it("Calculate the price of a ticket in Stadium River Plate with StatusShow Precio Base and seatType Palco"){

      //Arrange
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
      val seatTypePalco = SeatType("Palco", 8000, 20000.0.toBigDecimal())
      val riverPlateLocation = Location(34.545277777778, -58.449722222222)
      val riverPlatePlaceOfShow = Stadium("Estadio River Plate", riverPlateLocation, 80000.toBigDecimal())
      val statusRiverPlateShow = StatusShow("PrecioBase", 1.8.toBigDecimal())
      val showACDC = Show(
        "AC-DC",
        riverPlatePlaceOfShow,
        "Power up Tour",
        100000.00.toBigDecimal(),
        statusRiverPlateShow,
        img = "src/main/resources/assets/acdc.jpg"
      )
      val ticketACDC1 = Ticket(seatTypePalco, adrian)

      //Act
      riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1))
      val ticketCostACDC = ticketACDC1.price(showACDC).toDouble()

      //Assert
      ticketCostACDC.shouldBe(27).toDouble()
    }

    it("Calculate the price of a ticket in Stadium River Plate with StatusShow Precio Base and seatType Campo"){

      //Arrange
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
      val seatTypeCampo = SeatType("Campo", 8000, 15000.0.toBigDecimal())
      val riverPlateLocation = Location(34.545277777778, -58.449722222222)
      val riverPlatePlaceOfShow = Stadium("Estadio River Plate", riverPlateLocation, 80000.toBigDecimal())
      val statusRiverPlateShow = StatusShow("PrecioBase", 1.8.toBigDecimal())
      val showACDC = Show(
        "AC-DC",
        riverPlatePlaceOfShow,
        "Power up Tour",
        100000.00.toBigDecimal(),
        statusRiverPlateShow,
        img = "src/main/resources/assets/acdc.jpg"
      )
      val ticketACDC1 = Ticket(seatTypeCampo, adrian)

      //Act
      riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1))
      val ticketCostACDC = ticketACDC1.price(showACDC).toDouble()

      //Assert
      ticketCostACDC.shouldBe(25.92).toDouble()
    }

  }

  it("Calculate the price of a ticket in Theater Colon with StatusShow Precio Base and seatType Pullman"){

    //Arrange
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
    val seatTypePullman = SeatType("Pullman",6000, 10000.0.toBigDecimal())
    val teatroColonLocation = Location(-58.3831868989758, -34.6010855)
    val teatroColonPlaceOfShow = Theater("Teatro Colon",teatroColonLocation,100000.toBigDecimal(),  false)
    val statusTeatroColonShow = StatusShow("PrecioBase",1.8.toBigDecimal())
    val megadeth = Show(
      "Megadeth",
      teatroColonPlaceOfShow,
      "Movistar Arena Tour",
      100000.00.toBigDecimal(),
      statusTeatroColonShow,
      "src/main/resources/assets/megadeth.jpg"
    )
    val ticketMegadeth= Ticket(seatTypePullman, adrian)

    //Act
    teatroColonPlaceOfShow.setTickets(mutableListOf(ticketMegadeth))
    val ticketCostMegadeth = ticketMegadeth.price(megadeth).toDouble()

    //Assert
    ticketCostMegadeth.shouldBe(32.94)
  }

  it("Calculate the price of a ticket in Theater Colon with StatusShow Precio Base and seatType Platea Baja"){

    //Arrange
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
    val seatTypePlateaBaja = SeatType("Platea Baja",6000, 15000.0.toBigDecimal())
    val teatroColonLocation = Location(-58.3831868989758, -34.6010855)
    val teatroColonPlaceOfShow = Theater("Teatro Colon",teatroColonLocation,100000.toBigDecimal(),  false)
    val statusTeatroColonShow = StatusShow("PrecioBase",1.8.toBigDecimal())
    val megadeth = Show(
      "Megadeth",
      teatroColonPlaceOfShow,
      "Movistar Arena Tour",
      100000.00.toBigDecimal(),
      statusTeatroColonShow,
      "src/main/resources/assets/megadeth.jpg"
    )
    val ticketMegadeth= Ticket(seatTypePlateaBaja, adrian)

    //Act
    teatroColonPlaceOfShow.setTickets(mutableListOf(ticketMegadeth))
    val ticketCostMegadeth = ticketMegadeth.price(megadeth).toDouble()

    //Assert
    ticketCostMegadeth.shouldBe(34.56)
  }
})