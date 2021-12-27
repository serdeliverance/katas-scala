package io.github.bootcamp.fizzbuzz

object FizzBuzz {

  def fizzbuzz(n: Int): Unit =
    (1 to n)
      .map {
        case n if isMultiplyOf(n, 5) && isMultiplyOf(n, 3) => "fizzbuzz"
        case n if isMultiplyOf(n, 5)                       => "buzz"
        case n if isMultiplyOf(n, 3)                       => "fizz"
        case n                                             => n
      }
      .map(println)

  def isMultiplyOf(n: Int, dividend: Int): Boolean =
    n % dividend == 0

  def main(args: Array[String]): Unit =
    fizzbuzz(15)
}
