package io.github.bootcamp

/**
  * No tailrec solution
  */
object Palindrome {

  def isPalindrome(word: String): Boolean =
    word == reverse(word.toList)

  def reverse(chars: List[Char]): String =
    chars match {
      case Nil            => chars.mkString
      case ::(head, next) => reverse(next) :+ head
    }
}
