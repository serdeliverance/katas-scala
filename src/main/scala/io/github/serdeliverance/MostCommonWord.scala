package io.github.serdeliverance

object MostCommonWord extends App {

  def mostCommonWord(parrafo: String, palabrasNoPermitidas: Array[String]): String =
    parrafo.toLowerCase.trim
      .split(" ")
      .toList
      .map(removeSpecialCharacters)
      .filterNot(word => palabrasNoPermitidas.contains(word))
      .groupBy(identity)
      .map(entry => (entry._1, entry._2.length))
      .toList
      .sortWith((entry1, entry2) => entry1._2 > entry2._2)
      .head
      ._1

  private def removeSpecialCharacters(word: String): String =
    word.replaceAll("[^a-zA-Z]+", "")

  val parrafo              = "Bob hit a ball!!, the hit BALL flew long after it was hit."
  val palabrasNoPermitidas = Array("hit")

  println(mostCommonWord(parrafo, palabrasNoPermitidas))
}
