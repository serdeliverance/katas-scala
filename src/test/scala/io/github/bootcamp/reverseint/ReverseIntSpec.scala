package io.github.bootcamp.reverseint

import io.github.bootcamp.reverseint.ReverseInt.reverseInt
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ReverseIntSpec extends AnyWordSpec with Matchers {

  "#reverseInt function" should {
    "reverse an int number successfully" in {
      val result = reverseInt(15)

      result mustBe 51
    }

    "reverse an int number with zero digits successfully" in {
      val result = reverseInt(500)

      result mustBe 5
    }

    "reverse negative numbers preserving the negative sign" in {
      val result = reverseInt(-15)

      result mustBe -51
    }

    "reverse negative number with zero digits successfully" in {
      val result = reverseInt(-90)

      result mustBe -9
    }
  }
}
