package io.github.serdeliverance

object SplitIntoTwo extends App {

  def splitIntoTwo(arr: Array[Int]): Int =
    if (arr.length > 2) calculateSplitIntoTwo(1, arr(0), arr.sum - arr(0), arr, 0)
    else 1

  def calculateSplitIntoTwo(
      splitPoint: Int,
      leftSideSum: Int,
      rightSideSum: Int,
      array: Array[Int],
      combinationsCount: Int
    ): Int =
    if (splitPoint == array.length) combinationsCount
    else {
      calculateSplitIntoTwo(splitPoint + 1,
                            leftSideSum + array(splitPoint),
                            rightSideSum - array(splitPoint),
                            array,
                            if (leftSideSum > rightSideSum) combinationsCount + 1 else combinationsCount)
    }
}
