package io.github.serdeliverance.leetcode

/**
  * Easy | Neetcode
  *
  */
object PivotIndex {

  private val NOT_FOUND = -1

  def pivotIndex(nums: Array[Int]): Int = {
    def retrievePivotIndex(pos: Int, leftSum: Int, rightSum: Int, nums: Array[Int]): Int =
      if (leftSum == rightSum) pos
      else if (pos > nums.length - 2) NOT_FOUND
      else retrievePivotIndex(pos + 1, leftSum + nums(pos), rightSum - nums(pos + 1), nums)

    if (nums.length <= 2) NOT_FOUND
    else retrievePivotIndex(1, nums(0), nums.sum - nums(0) - nums(1), nums)
  }
}
