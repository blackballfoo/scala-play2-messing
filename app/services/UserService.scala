package services

import com.google.inject.ImplementedBy
import models.UserData

import scala.collection.mutable.ArrayBuffer

/**
  * Created by developer on 03/02/2017.
  */
@ImplementedBy(classOf[UserServiceImpl])
trait UserService {

  private val users = ArrayBuffer(
    UserData("Fred", "FlintStone"),
    UserData("Wilma", "FlintStone"),
    UserData("Tony", "Stark")
  )
  
  def getUsers()= users

  def addUser(user: UserData): Unit = {
    users.append(user)
  }
}

class UserServiceImpl extends UserService
