package controllers

import javax.inject.{Inject, Singleton}

import play.api._
import play.api.mvc._
import models.UserData
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.i18n.{DefaultMessagesApi, I18nSupport}
import play.i18n.MessagesApi

import scala.collection.mutable.ArrayBuffer


/**
  * Created by blackballfoo on 30/01/2017.
  */
@Singleton
class UserDataFormController @Inject()(val messagesApi: DefaultMessagesApi)  extends Controller with I18nSupport {

  private val users = ArrayBuffer(
    UserData("Fred", "FlintStone"),
    UserData("Wilma", "FlintStone"),
    UserData("Tony", "Stark")
  )

 def listUsers = Action { implicit request =>
    // Pass an unpopulated form to the template
    Ok(views.html.listUsers(users.toSeq))
  }

  def createUser = Action{ implicit request =>
    // Pass an unpopulated form to the template
    Ok(views.html.createUser(UserDataFormController.createUserDataForm))
  }

  def newUser = Action(parse.form(UserDataFormController.createUserDataForm)) { request =>
    val user = request.body
    println("new User created")
    users.append(user)
    Redirect(routes.UserDataFormController.listUsers)
  }


}

object UserDataFormController {
   val createUserDataForm = Form(
       mapping(
         "firstName" -> text,
         "lastName" -> text
       )(UserData.apply)(UserData.unapply)
     )
}