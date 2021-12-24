package io.github.bootcamp

import io.github.bootcamp.Palindrome.isPalindrome
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PalindromeAltSpec extends AnyWordSpec with Matchers {

  "#PalidromeAlt" should {
    "return true" in {
      val result = isPalindrome("abba")

      result mustBe true
    }

    "return false" in {
      val result = isPalindrome("asdfgh")

      result mustBe false
    }
  }
}
