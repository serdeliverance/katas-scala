package io.github.serdeliverance.fpexercises.lists

import scala.annotation.tailrec

sealed abstract class RList[+T] {
  def head: T
  def tail: RList[T]
  def isEmpty: Boolean

  def get(index: Int): T

  def length: Int

  def ::[S >: T](elem: S): RList[S] = new ::(elem, this)
}

case object RNil extends RList[Nothing] {
  override def head: Nothing        = throw new NoSuchElementException
  override def tail: RList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean     = true

  override def get(index: Int): Nothing = throw new NoSuchElementException

  override def length: Int = 0

  override def toString: String = "[]"
}

case class ::[+T](override val head: T, override val tail: RList[T]) extends RList[T] {
  override def isEmpty: Boolean = false

  override def get(index: Int): T =
    if (index >= tail.length + 1) throw new NoSuchElementException
    else ???

  override def length: Int = ???

  override def toString: String = {

    @tailrec
    def toStringTailRec(remaining: RList[T], result: String): String =
      if (remaining.isEmpty) result
      else if (remaining.tail.isEmpty) s"$result${remaining.head}"
      else toStringTailRec(remaining.tail, s"$result${remaining.head}, ")

    "[" + toStringTailRec(this, "") + "]"
  }
}

object ListProblems extends App {

  val aSmallList = 1 :: 2 :: 3 :: RNil // RNil.::(3).::(2).::(1)
  println(aSmallList)
}
