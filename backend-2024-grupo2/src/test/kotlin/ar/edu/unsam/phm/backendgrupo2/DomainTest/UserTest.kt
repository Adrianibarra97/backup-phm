package ar.edu.unsam.phm.backendgrupo2.DomainTest

import ar.edu.unsam.phm.backendgrupo2.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class UserTest : DescribeSpec({
  isolationMode = IsolationMode.InstancePerTest

  // Data

  // Roles
  val consumer: Consumer = Consumer("Consumer")

  // Users
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
  val joaquin: User = User(
    "Joaquin",
    "Ibarra",
    "Joaq9730",
    "https://www.image.com/resources/adrian-ibarra",
    "Argentina",
    LocalDate.of(1997, 3, 30),
    40258359,
    12345,
    100.toBigDecimal(),
    consumer
  )

  //Location
  val lunaParkLocation = Location(
    -58.3707,
    -34.5988
  )

  //PlaceOfShow
  val lunaParkPlaceOfShow = Stadium(
    "Luna Park",
    lunaParkLocation,
    180000.toBigDecimal()
  )

  //StatusShow
  val statusLunaParkShow = StatusShow(
    "PrecioBase",
    1.8.toBigDecimal()
  )

  // Shows
  val laRenga: Show = Show(
    "La Renga",
    lunaParkPlaceOfShow,
    "Cosquin",
    100000.00.toBigDecimal(),
    statusLunaParkShow,
    "src/main/resources/assets/la-renga.jpg"
  )

  describe("User test.") {
    it("User add friend successfully.") {
      //Act
      adrian.addFriend(joaquin)

      //Assert
      adrian.getFriends().size.shouldBe(1)
    }

    it("User remove friend successfully.") {
      //Arrange
      adrian.addFriend(joaquin)

      //Act
      adrian.removeFriend(joaquin)

      //Assert
      adrian.getFriends().size.shouldBe(0)
    }

    it("User add show successfully.") {
      //Act
      adrian.addShow(laRenga)

      //Assert
      adrian.getShows().size.shouldBe(1)
    }

    it("User remove show successfully.") {
      //Arrange
      adrian.addShow(laRenga)

      //Act
      adrian.removeShow(laRenga)

      //Assert
      adrian.getShows().size.shouldBe(0)
    }

    it("Add credit to user.") {
      //Act
      joaquin.addCredit()

      //Assert
      joaquin.availableMoney.shouldBe(1100.toBigDecimal())
    }
  }
})