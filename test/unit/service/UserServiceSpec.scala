package unit.service

import domain.UserData
import org.scalatest.FunSuite
import services.UserServiceImpl

/**
  * Created by developer on 03/02/2017.
  */
class UserServiceSpec extends FunSuite{

  test("Initial size of User list should be 3") {
    val service = new UserServiceImpl
    assert(service.getUsers().size==3)
  }

  test("size of User list should be 4 after 1 addition") {
    val service = new UserServiceImpl
    service.addUser(UserData("Peter", "Pan"))
    assert(service.getUsers().size==4)
  }

}
