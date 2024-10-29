package ar.edu.unsam.phm.backendgrupo2.ServiceTest

import ar.edu.unsam.phm.backendgrupo2.domain.*
import ar.edu.unsam.phm.backendgrupo2.repository.UserRepository
import ar.edu.unsam.phm.backendgrupo2.service.UserService
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class UserServiceTest : DescribeSpec({
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
    "Japón",
    LocalDate.of(1997, 3, 30),
    40258359,
    12345,
    100.toBigDecimal(),
    consumer
  )
  val joaquin: User = User(
    "Joaquin",
    "Ibarra",
    "Joaq9730",
    "https://www.image.com/resources/adrian-ibarra",
    "Paraguay",
    LocalDate.of(1997, 3, 30),
    40258359,
    12345,
    1.1.toBigDecimal(),
    consumer
  )

  // Services
  val userService: UserService = UserService().apply {
    this.repository = UserRepository()
  }

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

  describe("User service test.") {
    it("Get all users successfully.") {
      //Act
      userService.create(adrian)
      userService.create(joaquin)

      //Assert
      userService.getAll().size.shouldBe(2)
    }

    it("Get user by id successfully.") {
      //Arrange
      userService.create(adrian)
      userService.create(joaquin)

      //Act
      val user: User = userService.getOneById(0)

      //Assert
      user.name.shouldBe("Adrian")
    }

    it("Create user successfully.") {
      //Act
      userService.create(adrian)

      //Assert
      userService.getAll().size.shouldBe(1)
    }

    it("Update user successfully.") {
      //Arrange
      val newUser: User = User(
        "Adrian Joel",
        "Ibarra",
        "adri9730",
        "https://www.image.com/resources/adrian-ibarra",
        "Japón",
        LocalDate.of(1997, 3, 30),
        40258359,
        12345,
        1.1.toBigDecimal(),
        consumer
      )
      newUser.id = 0
      userService.create(adrian)

      //Act
      userService.update(newUser)
      val adrianNewUser: User = userService.getOneById(0)

      //Assert
      adrianNewUser.name.shouldBe("Adrian Joel")
    }

    it("Delete user successfully.") {
      //Arrange
      userService.create(adrian)

      //Act
      userService.delete(adrian)

      //Assert
      userService.getAll().size.shouldBe(0)
    }

    it("Get friends by user successfully.") {
      //Arrange
      userService.create(joaquin)

      //Act
      adrian.addFriend(joaquin)
      userService.create(adrian)

      //Assert
      userService.getFriends(adrian.id).size.shouldBe(1)
    }

    it("Get shows by user successfully.") {
      //Arrange
      userService.create(joaquin)

      //Act
      adrian.addShow(laRenga)
      userService.create(adrian)

      //Assert
      userService.getShows(adrian.id).size.shouldBe(1)
    }

    it("Get comments by user successfully.") {
      //Arrange
      userService.create(joaquin)

      //Act
      adrian.addShow(laRenga)
      userService.create(adrian)

      //Assert
      userService.getComments(adrian.id).size.shouldBe(0)
    }

    it("Add credit to user successfully.") {
      //Arrange
      userService.create(adrian)

      //Act
      userService.addCreditToUser(adrian.id)

      //Assert
      adrian.availableMoney.shouldBe(1000.0.toBigDecimal())
    }

    it("User delete a friend successfully.") {
      //Arrange
      userService.create(adrian)
      userService.create(joaquin)
      adrian.addFriend(joaquin)

      //Act
      userService.removeFriend(joaquin.id, adrian.id)

      //Assert
      userService.getFriends(adrian.id).size.shouldBe(0)
    }
  }
})