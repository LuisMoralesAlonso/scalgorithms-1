package week0

/**
 * @author luis
 */
object BinarySearch {
  def binsearch(x: Int, numbers: List[Int]): Int = {
    def binsearchAcc(acc: Int, numbers: List[Int]): Int = numbers match {
      case Nil => throw new Exception("Empty list.")
      case y if y.length.equals(1) => if(y(0).equals(x)) acc else throw new NoSuchElementException("Number " + x + " not in List.")
      case y =>
        val mid = numbers.length / 2; numbers(mid).compare(x) match {
          case y if y > 0  => binsearchAcc(acc, numbers.dropRight(mid))
          case y if y < 0  => binsearchAcc(acc+mid, numbers.drop(mid))
          case y if y == 0 => acc+mid
        }
    }
    binsearchAcc(0,numbers)
  }                                               //> res1: Boolean = true
}