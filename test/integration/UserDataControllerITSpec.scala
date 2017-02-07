package integration

import org.scalatestplus.play._

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
class UserDataControllerITSpec extends PlaySpec with OneServerPerTest with OneBrowserPerTest with HtmlUnitFactory {

  "UserDataController" should {
    "user create form should work from within a browser" in {
      go to ("http://localhost:" + port + "/user")
      pageSource must include ("Create New User")
    }

    "user list page should work from within a browser" in {
      go to ("http://localhost:" + port + "/users")
      pageSource must include ("Users")
    }
  }

}
