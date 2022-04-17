package fp

object PatternMatching {
  def patternMatching(candidate: String): Int = {
    candidate match {
      case "One" => 1
      case "Two" => 2
      case _ => -1
    }
  }

  def main(args: Array[String]): Unit = {
    println(patternMatching("One"))
    println(caseClassesPatternMatching(Bird("kaftar")))
    println(constantsPatternMatching(6))
    println(sequencesPatternMatching(List(1, 2)))
    val m1 = Mammal("salam", true)
    val m2 = Mammal("salam", true)
    println(m1 == m2)
    println(tuplesPatternMatching((1, 2)))
    println(regexPatterns("1234"))
    println(regexPatterns("salam"))
    println(regexPatterns("1salam23#4"))
    val x: Option[Int] = None
    println(x.getOrElse(1))
    println(patternGuards(List(1, 2, 3), 1))
    println(caseClassesPatternMatching(Mammal("salam", true)))
  }
//  Case Classes
  abstract class Animal

  case class Mammal(name: String, fromSea: Boolean) extends Animal

  case class Bird(name: String) extends Animal

  case class Fish(name: String) extends Animal

  def caseClassesPatternMatching(animal: Animal): String = {
    animal match {
      case m: Mammal => "dkkk"
      case Mammal(name, fromSea) => s"I'm a $name, a kind of mammal. Am I from the sea? $fromSea"
      case Mammal(name, _) => s"I'm a $name, a kind of mammal. Am I from the sea?"
      case Bird(name) => s"I'm a $name, a kind of bird"
      case _ => "I'm an unknown animal"
    }
  }
//  Constants
  def constantsPatternMatching(constant: Any): String = {
    constant match {
      case 0 => "I'm equal to zero"
      case 4.5d => "I'm a double"
      case false => "I'm the contrary of true"
      case _ => s"I'm unknown and equal to $constant"
    }
  }
//  Sequences
  def sequencesPatternMatching(sequence: Any): String = {
    sequence match {
      case List(singleElement) => s"I'm a list with one element: $singleElement"
      case List(_, _*) => s"I'm a list with one or multiple elements: $sequence"
      case Vector(1, 2, _*) => s"I'm a vector: $sequence"
      case _ => s"I'm an unrecognized sequence. My value: $sequence"
    }
  }
//  Tuples
  def tuplesPatternMatching(tuple: Any): String = {
    tuple match {
      case (first, second) => s"I'm a tuple with two elements: $first & $second"
      case (first, second, third) => s"I'm a tuple with three elements: $first & $second & $third"
      case _ => s"Unrecognized pattern. My value: $tuple"
    }
  }
//  Typed Patterns
  def typedPatternMatching(any: Any): String = {
    any match {
      case string: String => s"I'm a string. My value: $string"
      case a: Int => s"I'm an integer. My value: $a"
      case _ => s"I'm from an unknown type. My value: $any"
    }
  }
//  Regex Patterns
  def regexPatterns(toMatch: String): String = {
    val numeric = """([0-9]+)""".r
    val alphabetic = """([a-zA-Z]+)""".r
    val alphanumeric = """([a-zA-Z0-9]+)""".r

    toMatch match {
      case numeric(value) => s"I'm a numeric with value $value"
      case alphabetic(value) => s"I'm an alphabetic with value $value"
      case alphanumeric(value) => s"I'm an alphanumeric with value $value"
      case _ => s"I contain other characters than alphanumerics. My value $toMatch"
    }
  }
//  Options: Some<T> and None
  def optionsPatternMatching(option: Option[String]): String = {
    option match {
      case Some(value) => s"I'm not an empty option. Value $value"
      case None => "I'm an empty option"
    }
  }
//  Variable Binding
  def binderPatternMatching(animal: Any): String = {
    animal match {
      case m@Mammal(_, true) => {
        s"${m.name} is a mammal from sea"
      }
      case Mammal(name, fromSea) => s"${name} is a mammal, fromSea:${fromSea}"
      case _ => "unknown animal"
    }
  }
  def binderPatternWithPartMatch(animal: Any): String = {
    animal match {
      case Mammal(name @ "Lion", _) => s"$name is a mammal"
      case _ => "unknown"
    }
  }
//  Pattern Guards
  def patternGuards(toMatch: Any, maxLength: Int): String = {
    toMatch match {
      case list: List[Any] if (list.size <= maxLength) => "List is of acceptable size"
      case list: List[Any] => "List has not an acceptable size"
      case string: String if (string.length <= maxLength) => "String is of acceptable size"
      case string: String => "String has not an acceptable size"
      case _ => "Input is neither a List nor a String"
    }
  }
//  Catch Blocks
  def catchBlocksPatternMatching(exception: Exception): String = {
    try {
      throw exception
    } catch {
      case ex: IllegalArgumentException => "It's an IllegalArgumentException"
      case ex: RuntimeException => "It's a RuntimeException"
      case _ => "It's an unknown kind of exception"
    }
  }
}
