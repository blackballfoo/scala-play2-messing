package controllers

import javax.inject.{Inject, Singleton}

import forms.UserDataForm
import forms.model.UserDataCreateViewModel
import play.api.data.Form
import play.api.i18n.{DefaultMessagesApi, I18nSupport}
import play.api.mvc._
import services.UserService


/**
  * Created by blackballfoo on 30/01/2017.
  */
@Singleton
class UserDataFormController @Inject()(val messagesApi: DefaultMessagesApi, val userService : UserService)  extends Controller with I18nSupport {

 def listUsers = Action { implicit request =>
    Ok(views.html.listUsers(userService.getUsers))
  }

  def createForm = Action{ implicit request =>
    // Pass an unpopulated form to the template
    Ok(views.html.createUser(UserDataForm.userDataCreateForm()))
  }

  def handleUserFormPost = Action(parse.form(UserDataForm.userDataCreateForm(),
    onErrors = (formWithErrors: Form[UserDataCreateViewModel]) => BadRequest(views.html.createUser(formWithErrors)))) { request =>
    userService.addUser(request.body.userData)
    Redirect(routes.UserDataFormController.listUsers)
  }

}

object UserDataFormController
//{
//
//
//  def validate( userData: UserData ) = {
//    val p  = Pattern.compile("[a-zA-Z]");
//    userData match {
//      case UserData( firstName ,lastName ) =>
//        (p.matcher(firstName).find() && p.matcher(lastName).find())
//      case _ =>
//        false
//    }
//  }
//}