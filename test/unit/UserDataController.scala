package unit.controller

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._


/**
  * Created by developer on 06/02/2017.
  */
class UserDataControllerSpec extends PlaySpec with OneAppPerTest {

  "UserDataFormController" should {

    "return a list of users for a GET on /users path" in {
      val content = contentAsString(route(app, FakeRequest(GET, "/users")).get)
      content must include  ("<h1>Users</h1>")
      content must include  ("<th>First Name</th>")
      content must include  ("<th>Last Name</th>")
    }

    "display the create user form for a GET on /user path" in {
      val content = contentAsString(route(app, FakeRequest(GET, "/user")).get)
      content must include  ("<title>User Data</title>")
      content must include  ("<h1>Create New User</h1>")
      content must include  ("<label for=\"firstName\">First Name</label>")
      content must include  ("<label for=\"lastName\">Last Name</label>")
    }

    "redirect to users path on a POST to /user path" in {
      val result = route(app, FakeRequest(POST, "/user")
        .withFormUrlEncodedBody(("firstName","bob"),("lastName","Brown")))
        result.map(status(_)) mustBe Some(SEE_OTHER)
        result.map(headers(_)) mustBe Some(Map("Location"-> "/users"))
      val content = contentAsString(result.get)
      content must be ("")
    }

    "check form errors displays when no values sent" in {
      val content = contentAsString(route(app, FakeRequest(POST, "/user")
        .withFormUrlEncodedBody(("firstName",""),("lastName",""))).get)
      content must include ("Enter your first name in full")
      content must include ("Enter your last name in full")
    }

  }

}
