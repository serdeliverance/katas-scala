package io.github.bootcamp

import scala.annotation.tailrec

object PalindromeTR {

  def isPalindrome(word: String): Boolean =
    word == reverse(word.toList, List.empty)

  @tailrec
  def reverse(reversed: List[Char], chars: List[Char]): String =
    chars match {
      case Nil            => reversed.mkString
      case ::(head, next) => reverse(head :: reversed, next)
    }
}
