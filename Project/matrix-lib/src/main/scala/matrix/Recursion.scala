package matrix

import scala.annotation.tailrec

object Recursion {
  def main(args: Array[String]): Unit = {
    val n = 1000000
    var start = System.nanoTime()
    factorial2(n)
    println(System.nanoTime() - start)
    start = System.nanoTime()
    fac(n)
    println(System.nanoTime() - start)
  }

  def factorial(n:Int): BigInt = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  def factorial2(n:Int): BigInt = {
    @tailrec
    def fact(n:BigInt, acc:BigInt):BigInt = {
      if (n <= 1) acc
      else fact(n - 1, acc * n)
    }

    fact(n, 1)
  }

  val fac = (n: Int) => (1 to n).map(BigInt(_)).reduce(_*_)
}
