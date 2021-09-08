package io.github.serdeliverance

object MoreProfitableOperation extends App {

  def maxProfit(pricesAsString: String): Int = {
    val prices       = pricesAsString.split(",").toList.map(_.toInt)
    val combinations = calculatePriceDifferences(prices, List.empty)

    combinations.sorted.reverse.headOption.getOrElse(0)
  }

  private def calculatePriceDifferences(prices: List[Int], combinations: List[Int]): List[Int] =
    if (prices.isEmpty || prices.length == 1) combinations.map(changeSign).filter(diff => diff >= 0)
    else
      calculatePriceDifferences(prices.tail, combinations ++ calculateCombinationDiffs(prices.head, prices.tail))

  private def calculateCombinationDiffs(elem: Int, listOfNums: List[Int]): List[Int] =
    listOfNums.map(num => elem - num)

  private def changeSign(num: Int): Int = num * -1

  println(maxProfit("7,6,4,3,1"))
}
