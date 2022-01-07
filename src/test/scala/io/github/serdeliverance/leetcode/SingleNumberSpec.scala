package io.github.serdeliverance.leetcode

import io.github.serdeliverance.leetcode.SingleNumber.singleNumber
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class SingleNumberSpec extends AnyWordSpec with Matchers {

  "#singleNumber" should {
    "calculate correctly" in {
      val result = singleNumber(List(4, 1, 2, 1, 2))

      result mustBe 4
    }

    "calculate correctly #2" in {
      val result = singleNumber(List(2, 2, 1))

      result mustBe 1
    }
  }
}
