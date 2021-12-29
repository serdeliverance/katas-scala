package io.github.serdeliverance.toptal

import io.github.serdeliverance.toptal.LargerNumberOfWords.largerNumberOfWords
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LargerNumberOfWordsSpec extends AnyWordSpec with Matchers {

  "#solution" should {
    "doSomething" in {
      val result = largerNumberOfWords("We test coders. Give us a try?")

      result mustBe 4
    }

    "doSomething with other input" in {
      val result = largerNumberOfWords("Forget Cvs..Save time . x x")

      result mustBe 2
    }
  }
}
