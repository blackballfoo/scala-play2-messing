package forms.model

import domain.UserData

/**
  * Created by developer on 06/02/2017.
  */
case class UserDataCreateViewModel (firstName: String, lastName: String) {
  val userData = UserData(firstName, lastName)
}
