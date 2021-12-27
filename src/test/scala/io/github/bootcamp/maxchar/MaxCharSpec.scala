package io.github.bootcamp.maxchar

import io.github.bootcamp.maxchar.MaxChar.maxChar
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MaxCharSpec extends AnyWordSpec with Matchers {

  "#MaxChar" should {
    "return max char correctly" in {
      val result = maxChar("abccccccccd")
      result mustBe 'c'
    }

    "return max char correctly again" in {

      val result = maxChar("apple 12311111")
      result mustBe '1'
    }
  }
}
