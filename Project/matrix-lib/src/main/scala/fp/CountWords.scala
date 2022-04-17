package fp

import scala.io.Source

object CountWords {
  def main(args: Array[String]): Unit = {
    Source.fromFile("/home/abol/Documents/BigData/codes/matrix-lib/src/main/scala/fp/PatternMatching.scala").
      getLines().
      flatMap(line => line.split(" ")).
      toList.
      groupBy((word: String) => word.length).
      map(x => (x._1, x._2.length)).
      foreach(println)
  }
}
