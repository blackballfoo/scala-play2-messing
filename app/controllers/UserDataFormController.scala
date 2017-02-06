package controllers

import java.util.UUID
import javax.inject.{Inject, Singleton}

import models.UserData
import play.api.data.Form
import play.api.data.Forms._
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

  def createUser = Action{ implicit request =>
    // Pass an unpopulated form to the template
    val userData
    Ok(views.html.createUser(UserDataFormController.createUserDataForm))
  }

  def handleUserFormPost = Action(parse.form(UserDataFormController.createUserDataForm,
    onErrors = (formWithErrors: Form[UserData]) => BadRequest(views.html.createUser(formWithErrors)))) { request =>
    request.session("")
    val user = request.body
    println("new User created")
    userService.addUser(user)
    val userId = UUID.randomUUID();
    Redirect(routes.UserDataFormController.listUsers).withSession("user"->userId.toString)
  }


}

object UserDataFormController {
   val createUserDataForm = Form(
       mapping(
         "firstName" -> text.verifying("Enter First Name", {!_.isEmpty}),
         "lastName" -> text.verifying("Enter Last Name", {!_.isEmpty})
       )(UserData.apply)(UserData.unapply)
     )
}


