package io.github.serdeliverance

object Sum extends App {

  def sum(ints: List[Int]) =
    calculateSum(ints)

  def calculateSum(ints: List[Int], sum: Int = 0): Int =
    ints match {
      case Nil => sum
      case x :: tail => calculateSum(tail, x + sum)
    }

  println(sum(List(1, 2, 3)))
}
