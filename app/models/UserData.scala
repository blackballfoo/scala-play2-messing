package models

import play.api.data.validation.ValidationError

import scala.collection.mutable.ListBuffer

/**
  * Created by blackballfoo on 30/01/2017.
  */
case class UserData(firstName: String, lastName: String) {

  def validate(): List[ValidationError] = {
    val errors = ListBuffer[ValidationError]()
    if(firstName =="chimp"){
      errors += new ValidationError(Seq("firstName","NoNameGiven"))
    }
    errors.toList
  }
}

