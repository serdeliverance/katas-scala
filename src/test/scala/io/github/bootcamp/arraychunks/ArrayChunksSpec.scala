package io.github.bootcamp.arraychunks

import io.github.bootcamp.arraychunks.ArrayChunks.arrayChunks
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ArrayChunksSpec extends AnyWordSpec with Matchers {

  "#arraychunk" should {
    "chunk([1, 2, 3, 4], 2) into [[1, 2], [3, 4]]" in {
      val result = arrayChunks(List(1, 2, 3, 4), 2)

      result mustBe List(List(1, 2), List(3, 4))
    }

    "chunk([1, 2, 3, 4, 5], 2) into [[1, 2], [3, 4], [5]]" in {
      val result = arrayChunks(List(1, 2, 3, 4, 5), 2)

      result mustBe List(List(1, 2), List(3, 4), List(5))
    }

    "chunk([1, 2, 3, 4, 5, 6, 7, 8], 3) into [[1, 2, 3], [4, 5, 6], [7, 8]]" in {
      val result = arrayChunks(List(1, 2, 3, 4, 5, 6, 7, 8), 3)

      result mustBe List(List(1, 2, 3), List(4, 5, 6), List(7, 8))
    }

    "chunk([1, 2, 3, 4, 5], 4) into [[1, 2, 3, 4], [5]]" in {
      val result = arrayChunks(List(1, 2, 3, 4, 5), 4)

      result mustBe List(List(1, 2, 3, 4), List(5))
    }

    "chunk([1, 2, 3, 4, 5], 10) into [[1, 2, 3, 4, 5]]" in {
      val result = arrayChunks(List(1, 2, 3, 4, 5), 10)

      result mustBe List(List(1, 2, 3, 4, 5))
    }
  }
}
