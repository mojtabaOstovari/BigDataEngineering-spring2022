package fp

object Implicit {

  implicit def intToSeq(i: Int): Seq[Int] = Seq(i)

  case class test(a: Int)
//  implicit def +(t: test): Int =

  def multiply(implicit by: Int) = 5 * by

  def main(args: Array[String]): Unit = {
    val i = 1
    println(i + 10)
    println(i.map(_ + 2))

    implicit val multiplier=2
    println(multiply)

    implicit class Bike(j: Int) {
      def start: Unit = println("bike is starting")
      def stop: Unit = println("bike is stop")
    }
    i.start
    i.stop
  }
}
