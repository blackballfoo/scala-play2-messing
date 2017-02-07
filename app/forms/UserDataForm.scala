package forms


import forms.model.UserDataCreateViewModel
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints

/**
  * Created by developer on 06/02/2017.
  */
object UserDataForm {
  private val Length24 = 24

//  def userDataEditForm(): Form[UserDataEditViewModel] = {
//    Form(mapping(
//        "firstName" -> text.verifying("user.data.form-error.first-name", s => s.length>0).verifying(Constraints.maxLength(Length24)),
//        "lastName" -> text.verifying("user.data.form-error.last-name", s => s.length>0).verifying(Constraints.maxLength(Length24))
//      )(UserDataEditViewModel.apply)(UserDataEditViewModel.unapply))
//  }

  def userDataCreateForm(): Form[UserDataCreateViewModel] = {
    Form(mapping(
      "firstName" -> text.verifying("user.data.form-error.first-name", s => s.length>0).verifying(Constraints.maxLength(Length24)),
      "lastName" -> text.verifying("user.data.form-error.last-name", s => s.length>0).verifying(Constraints.maxLength(Length24))
    )(UserDataCreateViewModel.apply)(UserDataCreateViewModel.unapply))
  }

}
