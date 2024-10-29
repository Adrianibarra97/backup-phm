package ar.edu.unsam.phm.backendgrupo2.DomainTest

import ar.edu.unsam.phm.backendgrupo2.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Assertions.assertEquals
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.reflect.typeOf

class ShowSpec: DescribeSpec({

    isolationMode = IsolationMode.InstancePerTest

    describe("Test shows") {
        val consumer: Consumer = Consumer("Consumer")

        it("Calculate the cost of a show if the place is stadium") {

            //Arrange
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

            //Act
            showACDC.cost()

            //Assert
            showACDC.cost().shouldBe(180000.0.toBigDecimal())
        }

        it("Calculate the cost of a show if the place is theater with good acoustic"){

            //Arrange
            val teatroColonLocation = Location(-58.3831868989758, -34.6010855)
            val teatroColonPlaceOfShow = Theater("Teatro Colon",teatroColonLocation,100000.toBigDecimal(),  true)
            val statusTeatroColonShow = StatusShow("PrecioBase",1.8.toBigDecimal())
            val megadeth = Show(
              "Megadeth",
              teatroColonPlaceOfShow,
              "Movistar Arena Tour",
              100000.00.toBigDecimal(),
              statusTeatroColonShow,
              "src/main/resources/assets/megadeth.jpg"
            )

            //Act
            megadeth.cost()

            //Assert
            megadeth.cost().shouldBe(250000.0.toBigDecimal())
        }

        it("Calculate the cost of a show if the place is theater without good acoustic"){

            //Arrange
            val teatroColonLocation = Location(-58.3831868989758, -34.6010855)
            val teatroColonPlaceOfShow = Theater("Teatro Colon",teatroColonLocation,100000.toBigDecimal(),  false)
            val statusTeatroColonShow = StatusShow("PrecioBase",1.8.toBigDecimal())
            val megadeth: Show = Show(
              "Megadeth",
              teatroColonPlaceOfShow,
              "Movistar Arena Tour",
              100000.00.toBigDecimal(),
              statusTeatroColonShow,
              "src/main/resources/assets/megadeth.jpg"
            )

            //Act
            megadeth.cost()

            //Assert
            megadeth.cost().shouldBe(200000.0.toBigDecimal())
        }

        it("Test min ticket price functionality"){

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
            val seatTypePlateaAlta = SeatType("Platea Alta",5000, 10000.0.toBigDecimal())
            val seatTypeCampo = SeatType("Campo",7000, 15000.0.toBigDecimal())
            val seatTypePalco = SeatType("Palco",8000, 20000.0.toBigDecimal())

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
            val ticketACDC2 = Ticket(seatTypePalco, adrian)
            val ticketACDC3 = Ticket(seatTypeCampo, adrian)
            val functionShowACDC = FunctionShow(LocalDateTime.of(2026,12,1,19,0,0))

            //Act
            riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1,ticketACDC2,ticketACDC3))
            functionShowACDC.addTicketsToFunction(mutableListOf(ticketACDC1,ticketACDC2,ticketACDC3))
            showACDC.addFunctionShow(functionShowACDC)
            val minTicketPrice = showACDC.minTicketPrice().toDouble()

            //Assert
            assertEquals(9.9, minTicketPrice)
        }

        it("Test Max ticket price functionality") {

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
            val seatTypeCampo = SeatType("Campo", 7000, 15000.0.toBigDecimal())
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

            val ticketACDC1 = Ticket(seatTypePlateaAlta, adrian)
            val ticketACDC2 = Ticket(seatTypePalco, adrian)
            val ticketACDC3 = Ticket(seatTypeCampo, adrian)
            val functionShowACDC = FunctionShow(LocalDateTime.of(2026, 12, 1,19,0,0))

            //Act
            riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1,ticketACDC2,ticketACDC3))
            functionShowACDC.addTicketsToFunction(mutableListOf(ticketACDC1, ticketACDC2, ticketACDC3))
            showACDC.addFunctionShow(functionShowACDC)
            val maxTicketPrice = showACDC.maxTicketPrice().toDouble()

            //Assert
            assertEquals(10.8, maxTicketPrice)

        }

        it("Test total sales of show funcionality") {

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
            val seatTypeCampo = SeatType("Campo", 7000, 15000.0.toBigDecimal())
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

            val ticketACDC1 = Ticket(seatTypePlateaAlta, adrian)
            val ticketACDC2 = Ticket(seatTypePalco, adrian)
            val ticketACDC3 = Ticket(seatTypeCampo, adrian)
            val functionShowACDC = FunctionShow(LocalDateTime.of(2026, 12, 1,19,0,0))

            //Act
            riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1, ticketACDC2, ticketACDC3))
            functionShowACDC.addTicketsToFunction(mutableListOf(ticketACDC1, ticketACDC2, ticketACDC3))
            showACDC.addFunctionShow(functionShowACDC)
            val totalSalesOfShow = showACDC.totalSales().toDouble()

            //Assert
            assertEquals(31.14, totalSalesOfShow)
        }

        it("Test available per seat type functionality"){

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
            val ticketACDC2 = Ticket(seatTypePlateaAlta, adrian)
            val ticketACDC3 = Ticket(seatTypePlateaAlta, adrian)
            val functionShowACDC = FunctionShow(LocalDateTime.of(2026, 12, 1,19,0,0))

            //Act
            riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1,ticketACDC2,ticketACDC3))
            functionShowACDC.addTicketsToFunction(mutableListOf(ticketACDC1,ticketACDC2,ticketACDC3))
            showACDC.addFunctionShow(functionShowACDC)
            val availableSeatsPlateaAlta = showACDC.availablePerSeatType(seatTypePlateaAlta, functionShowACDC)

            //Arrange
            availableSeatsPlateaAlta.shouldBe(4997)

        }

        it("Test availableSeatTypes"){
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
            val seatTypeCampo = SeatType("Campo", 7000, 15000.0.toBigDecimal())
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

            val ticketACDC1 = Ticket(seatTypePlateaAlta, adrian)
            val ticketACDC2 = Ticket(seatTypeCampo, adrian)
            val ticketACDC3 = Ticket(seatTypePalco, adrian)
            val functionShowACDC = FunctionShow(LocalDateTime.of(2026, 12, 1,19,0,0))

            //Act
            riverPlatePlaceOfShow.setTickets(mutableListOf(ticketACDC1,ticketACDC2,ticketACDC3))
            functionShowACDC.addTicketsToFunction(mutableListOf(ticketACDC1,ticketACDC2,ticketACDC3))
            showACDC.addFunctionShow(functionShowACDC)
            val availableSeats = showACDC.availableSeatTypes(functionShowACDC)

            //Assert
            availableSeats.find { it.name == seatTypePlateaAlta.name }!!.capacity.shouldBe(4999)
        }
    }
})


