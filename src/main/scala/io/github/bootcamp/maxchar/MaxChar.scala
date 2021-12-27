package io.github.bootcamp.maxchar

/**
  * Solution using combinators
  */
object MaxChar {

  def maxChar(str: String): Char =
    str.toList
      .groupBy(identity)
      .map(entry => (entry._1, entry._2.size))
      .toList
      .sortBy(_._2)
      .reverse
      .head
      ._1
}
