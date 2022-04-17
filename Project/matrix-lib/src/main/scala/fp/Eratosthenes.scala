package fp

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object Eratosthenes {
  def main(args: Array[String]): Unit = {
//    println(primeStream().take(15).toList)
//    println(calculatePrimes(15))
    val n = 100000
    var start = System.nanoTime()
    calculatePrimesStream(n)
    println(System.nanoTime() - start)
    start = System.nanoTime()
    primesIterative(n)
    println(System.nanoTime() - start)

  }

  def primeStream(stream: LazyList[Int] = LazyList.from(3, 2)): LazyList[Int] = {
    stream.head #:: primeStream(stream.tail.filter(_ % stream.head != 0))
  }

  def calculatePrimes(end: Int): List[Int] = {
    val odds = (3 to Math.sqrt(end).toInt by 2)
    val composites = odds.flatten(i => (i * i to end by 2 * i))
    (3 to end by 2).diff(composites).toList
  }

  def calculatePrimesStream(end: Int): List[Int] = {
    val odds = LazyList.from(3, 2).takeWhile(_ <= Math.sqrt(end).toInt)
    val composites = odds.flatMap(i => LazyList.from(i * i, 2 * i).takeWhile(_ <= end))
    LazyList.from(3, 2).takeWhile(_ <= end).diff(composites).toList
  }

  def primesIterative(end: Int): List[Int] = {
    val primeIndices = ArrayBuffer.fill((end + 1) / 2)(1)

    val intSqrt = Math.sqrt(end).toInt
    for (i <- 3 to end by 2 if i <= intSqrt) {
      for (nonPrime <- i * i to end by 2 * i) {
        primeIndices.update(nonPrime / 2, 0)
      }
    }

    (for (i <- primeIndices.indices if primeIndices(i) == 1) yield 2 * i + 1).tail.toList
  }
}
