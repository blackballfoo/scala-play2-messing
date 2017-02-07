package forms.model

import domain.UserData

/**
  * Created by developer on 06/02/2017.
  */
case class UserDataCreateViewModel (firstName: String, lastName: String) {
  val userData = UserData(firstName, lastName)
}

//case class UserDataEditViewModel (firstName: String, lastName: String) {
//  def this(ud: UserData) = this(ud.firstName, ud.lastName)
//  val userData = UserData(firstName, lastName)
//}
