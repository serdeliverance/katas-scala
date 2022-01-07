package io.github.ctci

import io.github.ctci.BinarySearch.search
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BinarySearchSpec extends AnyWordSpec with Matchers {

  "#BinarySearch" should {
    "find element" in {
      val result = search(7, Array(1, 2, 7, 9, 11, 22))

      result mustBe 2
    }

    "not find element" in {
      val result = search(3, Array(1, 2, 7, 9, 11, 22))

      result mustBe -1
    }
  }
}
