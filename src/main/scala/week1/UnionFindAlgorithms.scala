package week1

/**
 * @author luis
 */
object UnionFindAlgorithms {
  import SequenceIntervals._
  def quickUnion[T](vec: Seq[T], p: Int, q: Int)(implicit intervals: SeqIntervals[T]): Seq[T] = if (intervals.connected(p, q, vec)) vec else vec map (r => if (r == intervals.find(vec, p)) intervals.find(vec, q) else r)

}