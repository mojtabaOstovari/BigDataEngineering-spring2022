package fp

import scala.annotation.tailrec

object Factorial {
  def main(args: Array[String]): Unit = {
    val n = 100000
    var start = System.nanoTime()
    factorial(n)
    println(System.nanoTime() - start)
    start = System.nanoTime()
    fac(n)
    println(System.nanoTime() - start)
  }

  def factorial(n:Int): BigInt = {
    @tailrec
    def fact(n:BigInt, acc:BigInt):BigInt = {
      if (n <= 1) acc
      else fact(n - 1, acc * n)
    }

    fact(n, 1)
  }

  val fac = (n: Int) => (1 to n).map(BigInt(_)).reduce(_*_)
}
