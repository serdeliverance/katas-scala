package io.github.serdeliverance.leetcode

import io.github.serdeliverance.leetcode.PivotIndex.pivotIndex
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PivotIndexSpec extends AnyWordSpec with Matchers {

  "#pivotIndex" should {
    "find pivot index" in {
      val result = pivotIndex(Array(1, 2, 4, 8, 3, 4))

      result mustBe 3
    }
  }
}
