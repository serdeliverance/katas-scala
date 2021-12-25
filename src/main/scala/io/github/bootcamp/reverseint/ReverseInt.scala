package io.github.bootcamp.reverseint

object ReverseInt {

  def reverseInt(number: Int): Int = {
    val digits = number.toString.toList

    digits.head match {
      case '-' => (-1) * reverseDigits(List.empty, digits.tail)
      case _   => reverseDigits(List.empty, digits)
    }
  }

  def reverseDigits(reversed: List[Char], remaining: List[Char]): Int =
    remaining match {
      case Nil            => reversed.mkString.toInt
      case ::(head, next) => reverseDigits(head :: reversed, next)
    }
}
