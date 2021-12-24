package io.github.bootcamp.palindrome

/**
  * More efficient solution
  *
  */
object PalindromeAlt {

  def isPalindrome(word: String): Boolean =
    if (word.size >= 2) {
      val middleIdx = word.length / 2 - 1
      val chars     = word.toCharArray

      !(0 to middleIdx).exists(idx => chars(idx) != chars(chars.length - 1 - idx))
    } else true
}
