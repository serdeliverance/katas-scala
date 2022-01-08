package io.github.rockthejvm.lists

import scala.annotation.tailrec

sealed abstract class RList[+T] {
  def head: T
  def tail: RList[T]
  def isEmpty: Boolean

  def ::[S >: T](elem: S): RList[S] = new ::(elem, this)

  def apply(index: Int): T

  def length: Int

  def reverse: RList[T]

  def ++[S >: T](anotherList: RList[S]): RList[S]

  def removeAt(index: Int): RList[T]

  def map[S](f: T => S): RList[S]

  def flatMap[S](f: T => RList[S]): RList[S]

  def filter(f: T => Boolean): RList[T]
}

case object RNil extends RList[Nothing] {
  override def head: Nothing        = throw new NoSuchElementException
  override def tail: RList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean     = true

  override def toString: String = "[]"

  override def apply(index: Int): Nothing = throw new NoSuchElementException

  override def length: Int = 0

  override def reverse: RList[Nothing] = this

  override def ++[S >: Nothing](anotherList: RList[S]): RList[S] = anotherList

  override def removeAt(index: Int): RList[Nothing] = this

  override def map[S](f: Nothing => S): RList[S] = this

  override def flatMap[S](f: Nothing => RList[S]): RList[S] = this

  override def filter(f: Nothing => Boolean): RList[Nothing] = this
}

case class ::[+T](override val head: T, override val tail: RList[T]) extends RList[T] {
  override def isEmpty: Boolean = false

  override def apply(index: Int): T = {
    @tailrec
    def applyTailrec(list: RList[T], currentIndex: Int): T =
      list match {
        case RNil           => throw new NoSuchElementException
        case ::(head, tail) => if (currentIndex == index) head else applyTailrec(tail, currentIndex + 1)
      }

    if (index < 0) throw new NoSuchElementException
    else applyTailrec(this, 0)
  }

  override def length: Int = {
    @tailrec
    def lengthTailRec(remaining: RList[T], result: Int): Int =
      if (remaining.isEmpty) result
      else lengthTailRec(remaining.tail, result + 1)

    lengthTailRec(this, 0)
  }

  override def reverse: RList[T] = {
    @tailrec
    def reverseTailrec(remaining: RList[T], reversed: RList[T]): RList[T] =
      if (remaining.isEmpty) reversed
      else reverseTailrec(remaining.tail, remaining.head :: reversed)
    reverseTailrec(this, RNil)
  }

  override def ++[S >: T](anotherList: RList[S]): RList[S] = {
    @tailrec
    def concatTailrec(remainingList: RList[S], acc: RList[S]): RList[S] =
      if (remainingList.isEmpty) acc
      else concatTailrec(remainingList.tail, remainingList.head :: acc)

    concatTailrec(this.reverse, anotherList)
  }

  override def removeAt(index: Int): RList[T] = {
    @tailrec
    def removeAtTailrec(currentIndex: Int, remaining: RList[T], predecessors: RList[T]): RList[T] =
      if (currentIndex == index) predecessors.reverse ++ remaining.tail // ???
      else if (remaining.tail.isEmpty) this
      else removeAtTailrec(currentIndex + 1, remaining.tail, remaining.head :: predecessors)

    if (index < 0) this
    else if (index == 0) this.tail
    else removeAtTailrec(0, this, RNil)
  }

  override def map[S](f: T => S): RList[S] = {
    @tailrec
    def mapTailrec(remaining: RList[T], result: RList[S]): RList[S] =
      if (remaining.isEmpty) result.reverse
      else mapTailrec(remaining.tail, f(remaining.head) :: result)

    mapTailrec(this, RNil)
  }

  override def flatMap[S](f: T => RList[S]): RList[S] = {
    @tailrec
    def flatMapTailrec(remaining: RList[T], result: RList[S]): RList[S] =
      if (remaining.isEmpty) result.reverse
      else flatMapTailrec(remaining.tail, f(remaining.head).reverse ++ result)

    flatMapTailrec(this, RNil)
  }

  override def filter(predicate: T => Boolean): RList[T] = {
    @tailrec
    def filterTailrec(remaining: RList[T], result: RList[T]): RList[T] =
      if (remaining.isEmpty) result.reverse
      else if (predicate(remaining.head)) filterTailrec(remaining.tail, remaining.head :: result)
      else filterTailrec(remaining.tail, result)

    filterTailrec(this, RNil)
  }

  override def toString: String = {
    @tailrec
    def toStringTailrec[T](remaining: RList[T], result: String): String =
      if (remaining.isEmpty) result
      else if (remaining.tail.isEmpty) s"$result${remaining.head}"
      else toStringTailrec(remaining.tail, s"$result${remaining.head}, ")

    "[" + toStringTailrec(this, "") + "]"
  }
}
