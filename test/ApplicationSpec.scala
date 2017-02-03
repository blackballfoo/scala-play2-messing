import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._
import play.mvc.Result

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends PlaySpec with OneAppPerTest {

  "Routes" should {

    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }

  }

  "HomeController" should {

    "render the index page" in {
      val home = route(app, FakeRequest(GET, "/")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Your new application is ready.")
    }

  }

  "UserDataFormController" should {

    "return a list of users for a GET on /users path" in {
      contentAsString(route(app, FakeRequest(GET, "/users")).get) must include  ("<h1>Users</h1>")
      contentAsString(route(app, FakeRequest(GET, "/users")).get) must include  ("<tr><td>Fred</td><td>FlintStone</td></tr>")
    }

    "display the create user form for a GET on /user path" in {
      contentAsString(route(app, FakeRequest(GET, "/user")).get) must include  ("<h2>Users Form Fields</h2>")
      contentAsString(route(app, FakeRequest(GET, "/user")).get) must include  ("<input type=\"text\" id=\"firstName\" name=\"firstName\" value=\"\" />")
    }

    "redirect to users path on a POST to /user path" in {
      route(app, FakeRequest(POST, "/user")
        .withFormUrlEncodedBody(("firstName","bob"),("lastName","Brown"))).map(status(_)) mustBe Some(SEE_OTHER)
      route(app, FakeRequest(POST, "/user")
        .withFormUrlEncodedBody(("firstName","Bobby"),("lastName","Brown")))
        .map(headers(_)) mustBe Some(Map("Location"-> "/users"))
    }


  }

}
