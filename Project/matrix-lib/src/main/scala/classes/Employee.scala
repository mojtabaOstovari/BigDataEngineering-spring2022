//package classes
//
////class Employee (firstName: String, lastName: String)
//
////class Employee (val firstName: String, lastName: String)
////class Employee (val firstName: String, var lastName: String)
//
//import scala.beans.BeanProperty
//
////class Employee (@BeanProperty val firstName: String, @BeanProperty var lastName: String)
//
//class Employee (@BeanProperty val firstName: String,
//                @BeanProperty var lastName: String,
//                val title: String) {
//  require(firstName.nonEmpty, "First name can not be empty.")
//  if (title.contains("Senior")) throw new IllegalArgumentException("test")
//  val test = "salam"
////  def this(firstName: String, lastName: String) = this(firstName, lastName, "Programmer")
//  def this(firstName: String, lastName: String) = {
//    this(firstName, lastName, "Programmer")
//    println("constructor")
//  }
//  def fullName = s"$firstName $lastName"
////  def changeLastName(newName: String) = new Employee(firstName, newName, title)
//}
//
////class Department(val name: String)
//
//class Manager(firstName:String, lastName:String, title:String, val department:Department) extends
//  Employee(firstName, lastName, title) {
//  override def fullName = s"$firstName $lastName, ${department.name} Manager"
////
////  def copy(firstName:String = this.firstName, lastName:String = this.lastName,
////           title:String = this.title, department: Department = this.department) = {
////    new Manager(firstName, lastName, title, department)
////  }
//}
//
//case class Department(val name: String)
//
//object Main {
//  def main(args: Array[String]): Unit = {
//    val ada = new Employee("Ada", "Lovelace")
//    println(ada.firstName)
//    //
//    val newAda = new Employee("Ada", "Lovelace")
//    println(newAda.lastName)
////    newAda.setLastName("test")
//    newAda.lastName = "test"
//    println(newAda.lastName)
//    println(newAda.title)
//    println(newAda.test)
//    //
////        println(newAda.lastName)
//
//    val dennis = new Employee(lastName="Ritchie", firstName="Dennis")
//    println(s"The first name is ${dennis.firstName}")
//    println(s"The last name is ${dennis.lastName}")
//    //
//    println(ada.fullName)
//    println(newAda.fullName)
//    println(dennis.fullName)
//    //
//      try {
//        new Employee("", "Taheri", "Singer")
//      } catch {
//        case iae:IllegalArgumentException => println(iae.getMessage)
//      } finally {
//        println("Continuing with our program")
//      }
//    //
//        try {
//          new Employee("Linus", "Torvalds", "Senior C Programmer")
//        } catch {
//          case iae:IllegalArgumentException => println(iae.getMessage)
//        } finally {
//          println("Continuing with our program")
//        }
//    //
//    val mathematics = Department("Mathematics")
//    val math = Department("Mathematics")
//    println(math == mathematics)
//    val alan:Manager = new Manager("Alan", "Turing", "Mathematician, Logician", mathematics)
//    println(alan.department.name)
//    //
//    val alanEmployee:Employee = alan
//    //
//    println(ada.firstName)
//    println(newAda.firstName)
//    println(dennis.firstName)
//    println(alan.firstName)
//    println(alanEmployee.firstName)
//    //
//    //    //println(alanEmployee.department.name)
//    //
//    //    def extractFirstName(e:Employee) = e.firstName
//    //
//    //    println(extractFirstName(ada))
//    //    println(extractFirstName(dennis))
//    //    println(extractFirstName(alan))
//    //
////        println(ada.fullName)
////        println(newAda.fullName)
//    //    println(dennis.fullName)
//        println(alan.fullName)
//        println(alanEmployee.fullName)
//    //
//    //    val alanNewJob = alan.copy(title="Supreme Encryption Specialist")
//    //    println(alanNewJob.title)
//
//  }
//}
