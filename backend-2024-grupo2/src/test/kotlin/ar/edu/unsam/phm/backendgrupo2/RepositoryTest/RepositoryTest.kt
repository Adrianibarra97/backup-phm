package ar.edu.unsam.phm.backendgrupo2.RepositoryTest

import ar.edu.unsam.phm.backendgrupo2.domain.Consumer
import ar.edu.unsam.phm.backendgrupo2.domain.User
import ar.edu.unsam.phm.backendgrupo2.repository.UserRepository
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class RepositoryTest : DescribeSpec({
  isolationMode = IsolationMode.InstancePerTest

  describe("Repository test.") {
    val consumer: Consumer = Consumer("Consumer")

    it("Create new user successfully.") {
      //Arrange
      val testRepository = UserRepository()
      val newUser: User = User(
        "Adrian",
        "Ibarra",
        "adri9730",
        "https://www.image.com/resources/adrian-ibarra",
        "Portugal",
        LocalDate.of(1997, 3, 30),
        40258359,
        12345,
        1.1.toBigDecimal(),
        consumer
      )

      //Act
      testRepository.create(newUser)

      //Assert
      testRepository.amountOfObjects().shouldBe(1)
    }

    it("update user successfully.") {
      //Arrange
      val testRepository = UserRepository()
      val updatedUser: User = User(
        "Adrian",
        "Ibarra",
        "adri9730",
        "https://www.image.com/resources/adrian-ibarra",
        "Honduras",
        LocalDate.of(1997, 3, 30),
        40258359,
        12345,
        1.1.toBigDecimal(),
        consumer
      )
      testRepository.create(updatedUser)

      //Act
      updatedUser.password = 123456
      testRepository.update(updatedUser)

      //Assert
      updatedUser.password.shouldBe(123456)
    }

    it("Delete user successfully.") {
      //Arrange
      val testRepository = UserRepository()
      val adrian: User = User(
        "Adrian",
        "Ibarra",
        "adri9730",
        "https://www.image.com/resources/adrian-ibarra",
        "El Salvador",
        LocalDate.of(1997, 3, 30),
        40258359,
        12345,
        1.1.toBigDecimal(),
        consumer
      )
      testRepository.create(adrian)

      //Act
      testRepository.delete(adrian)

      //Assert
      testRepository.amountOfObjects().shouldBe(0)
    }

    it("Create many users successfully.") {
      //Arrange
      val testRepository = UserRepository()
      val adrian: User = User(
        "Adrian",
        "Ibarra",
        "adri9730",
        "https://www.image.com/resources/adrian-ibarra",
        "Venezuela",
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
        "Bélgica",
        LocalDate.of(1997, 3, 30),
        40258359,
        12345,
        1.1.toBigDecimal(),
        consumer
      )

      //Act
      testRepository.createObjects(mutableListOf<User>(adrian, joaquin))

      //Assert
      testRepository.amountOfObjects().shouldBe(2)
      testRepository.getOneById(0).name.shouldBe("Adrian")
      testRepository.getOneById(1).name.shouldBe("Joaquin")
    }
  }
})