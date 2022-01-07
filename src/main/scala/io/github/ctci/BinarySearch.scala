package io.github.ctci

object BinarySearch {

  private val NOT_FOUND = -1

  def search(n: Int, elements: Array[Int]): Int = {
    def doSearch(n: Int, lowIdx: Int, topIdx: Int, elements: Array[Int]): Int =
      if (lowIdx == topIdx) NOT_FOUND
      else {
        val mediumIdx = (topIdx - lowIdx) / 2
        if (elements(mediumIdx) == n) mediumIdx
        else if (elements(mediumIdx) < n) doSearch(n, mediumIdx + 1, topIdx, elements)
        else doSearch(n, lowIdx, mediumIdx - 1, elements)
      }

    doSearch(n, 0, elements.length - 1, elements)
  }
}
