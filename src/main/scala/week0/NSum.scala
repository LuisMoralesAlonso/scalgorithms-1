package week0

/**
 * @author luis
 */
object ThreeSum {
  def getSumsNum(num: Int, resto: List[Int], acc: List[(Int, Int, Int)]): List[(Int, Int, Int)] = resto.length match {
    case y if y <= 1 => acc
    case _ => (num + resto.head + resto.last) match {
      case y if y == 0 => getSumsNum(num, resto.init.tail, (num, resto.head, resto.last) :: acc)
      case y if y < 0  => getSumsNum(num, resto.tail, acc)
      case y if y > 0  => getSumsNum(num, resto.init, acc)
    }
  }

  def get3Sums(nums: List[Int]): List[(Int, Int, Int)] = nums.length match {
    case y if y < 3 => throw new Exception("Empty List or Not Enough Numbers")
    case y          => (for (i <- 0 to nums.length - 1) yield (getSumsNum(nums(i), nums drop (i + 1), List()))).toList.flatten
  }

}