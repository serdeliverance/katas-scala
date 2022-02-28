package io.github.rockthejvm.lists

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

import io.github.rockthejvm.lists.RList._

class RListSpec extends AnyWordSpec with Matchers {
  "Non empty Rlist" should {

    val list = 1 :: 2 :: 3 :: RNil

    "return length correctly" in {

      val result = list.length

      result mustBe 3
    }

    "reverse list" in {
      val result = list.reverse

      val expected = 3 :: 2 :: 1 :: RNil

      result mustBe expected
    }

    "concat list successfully" in {
      val anotherList = 4 :: 5 :: RNil

      val result = list ++ anotherList

      val expected = 1 :: 2 :: 3 :: 4 :: 5 :: RNil

      result mustBe expected
    }

    "remove element when index < 0" in {
      val result = list.removeAt(-1)

      result mustBe list
    }

    "remove element correctly" in {
      val result = list.removeAt(1)

      val expected = 1 :: 3 :: RNil

      result mustBe expected
    }

    "remove element when index out of bound" in {
      val result = list.removeAt(5)

      result mustBe list
    }

    "remove element when index == 0" in {
      val result = list.removeAt(0)

      result mustBe list.tail
    }

    "map elements correctly" in {
      val result = list.map(n => n.toString)

      val expected = "1" :: "2" :: "3" :: RNil

      result mustBe expected
    }

    "flatMap elements correctly" in {
      val result = list.flatMap(n => n :: n + 1 :: RNil)

      val expected = 1 :: 2 :: 2 :: 3 :: 3 :: 4 :: RNil

      result mustBe expected
    }

    "filter elements correctly" in {
      val result = list.filter(n => n > 1)

      val expected = 2 :: 3 :: RNil

      result mustBe expected
    }

    "rle list correctly" in {
      val someList = 1 :: 1 :: 1 :: 2 :: 2 :: 3 :: 4 :: 5 :: 5 :: RNil

      val result = someList.rle

      result mustBe (1, 3) :: (2, 2) :: (3, 1) :: (4, 1) :: (5, 2) :: RNil
    }

    "head option" in {
      val result = list.headOption

      result mustBe Some(1)
    }

    "duplicate each" in {
      val result = list.duplicateEach(3)

      result mustBe 1 :: 1 :: 1 :: 2 :: 2 :: 2 :: 3 :: 3 :: 3 :: RNil
    }

    "sorte elements" in {
      val anotherList = 1 :: 5 :: 2 :: 7 :: 3 :: 9 :: 10 :: RNil
      val result = anotherList.sorted((x, y) => x > y)

      result mustBe 10 :: 9 :: 7 :: 5 :: 3 :: 2 :: 1 :: RNil
    }
  }

  "Empty list" should {

    val list: RList[Int] = RNil

    "return length equals to 0" in {
      val result = list.length

      result mustBe 0
    }

    "reverse list" in {
      val result = list.reverse

      result mustBe RNil
    }

    "map elements correctly" in {
      val result = list.map(n => n.toString)

      result mustBe RNil
    }

    "flatMap elements correctly" in {
      val result = list.flatMap(n => n :: n :: RNil)

      result mustBe RNil
    }

    "filter elements correctly" in {
      val result = list.filter(n => n > 1)

      result mustBe RNil
    }

    "rle elements correctly" in {
      val result = list.rle

      result mustBe RNil
    }

    "head option correctly" in {
      val result = list.headOption

      result mustBe None
    }

    "duplicate each" in {
      val result = list.duplicateEach(3)

      result mustBe RNil
    }

    "sorte elements" in {
      val result = list.sorted((x, y) => x > y)

      result mustBe RNil
    }
  }

  // Companion methods
  "fill elements correctly on non empty list" in {
    val result = fill(3)(1)

    result mustBe 1 :: 1 :: 1 :: RNil
  }
}
