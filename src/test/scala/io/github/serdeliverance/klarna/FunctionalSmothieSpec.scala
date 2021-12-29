package io.github.serdeliverance.klarna

import io.github.serdeliverance.klarna.FunctionalSmothie.ingredients
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FunctionalSmothieSpec extends AnyWordSpec with Matchers {

  "#FunctionalSmothie" should {
    "retrieve ingredients correctly" in {
      val result = ingredients("Classic", List("strawberry"), MenuIngredientsProvider())

      result mustBe "banana,honey,ice,mango,peach,pineapple,yogurt"
    }
  }
}
