package io.github.serdeliverance.leetcode

object SingleNumber {

  def singleNumber(nums: List[Int]): Int =
    nums.fold(0)((a, b) => a ^ b)

}
