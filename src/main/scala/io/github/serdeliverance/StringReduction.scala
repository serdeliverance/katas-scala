package io.github.serdeliverance

/**
  * Write an algorithm that reduce an string apply the following rule:
  *
  * 1. if two adyacent characters are distinct, reduce it to another character
  * 2. return the size of the reduced string
  * 3. available characters: a, b and c
  *
  * Example: if I receive the string "aabc", in the first iteration I will reduce ab to c.
  * So the reduced string for this iteration will be acc. In the following iteration I can reduce
  * ac to b, so we will have bc by the end of this iteration. In the last iteration, we'll reduce bc to a,
  * returning 1 as the size of the reduced string.
  */
object StringReduction {

  def StringReduction(str: String): Int = reduce(str, "xxx")

  val availableChars = List('a', 'b', 'c')

  def reduce(currentString: String, prevString: String): Int =
    if (currentString == prevString) currentString.length
    else {
      var i             = 0
      var reduceApplied = false

      while (i < currentString.length - 1 && !reduceApplied) {
        val current = currentString.charAt(i)
        val next    = currentString.charAt(i + 1)

        if (current == next) {
          i += 1
        } else {
          reduceApplied = true
        }
      }

      if (!reduceApplied) reduce(currentString, currentString)
      else {
        val reducedFragment =
          availableChars.find(c => c != currentString.charAt(i) && c != currentString.charAt(i + 1)).get.toString
        val nextString = currentString.substring(0, i).concat(reducedFragment).concat(currentString.substring(i + 2))
        reduce(nextString, currentString)
      }
    }
}
