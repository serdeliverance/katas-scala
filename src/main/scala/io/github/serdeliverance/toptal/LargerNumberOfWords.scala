package io.github.serdeliverance.toptal

/**
  * Larger number of words
  */
object LargerNumberOfWords {

  def largerNumberOfWords(s: String): Int =
    s.split(Array('.', '!', '?'))
      .filter(_.nonEmpty)
      .map(sentence => sentence.split(' ').count(_.nonEmpty))
      .max
}
