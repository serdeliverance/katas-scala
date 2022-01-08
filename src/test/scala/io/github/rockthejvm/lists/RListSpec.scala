package io.github.rockthejvm.lists

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

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
  }
}
