package controllers

import java.util.regex.Pattern
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
    Ok(views.html.createUser(UserDataFormController.createUserDataForm))
  }

  def handleUserFormPost = Action(parse.form(UserDataFormController.createUserDataForm,
    onErrors = (formWithErrors: Form[UserData]) => BadRequest(views.html.createUser(formWithErrors)))) { request =>
    val user = request.body
    println("new User created")
    userService.addUser(user)
    Redirect(routes.UserDataFormController.listUsers)
  }


}

object UserDataFormController {
   val createUserDataForm = Form(
       mapping(
         "firstName" -> nonEmptyText,
         "lastName" -> nonEmptyText
       )(UserData.apply)(UserData.unapply) verifying("Failed form constraints!", fields => fields match {
         case userData => validate(userData)
       })
     )

  def validate( userData: UserData ) = {
    val p  = Pattern.compile("[a-zA-Z]");
    userData match {
      case UserData( firstName ,lastName ) =>
        (p.matcher(firstName).find() && p.matcher(lastName).find())
      case _ =>
        false
    }
  }
}


