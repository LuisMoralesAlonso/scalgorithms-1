package week1

/**
 * @author luis
 */
object SequenceIntervals {
  trait SeqIntervals[T] {
    def find(seq: Seq[T], index: Int): T
    def connected(a: Int, b: Int, seq: Seq[T]): Boolean
    def count(seq: Seq[T]): Int
  }

  implicit object SeqIntervalsInt extends SeqIntervals[Int] {
    def find(seq: Seq[Int], p: Int): Int = seq(p)
    def connected(p: Int, q: Int, seq: Seq[Int]): Boolean = find(seq, p) == find(seq, q)
    def count(seq: Seq[Int]): Int = seq.distinct.size
  }
  
  implicit object SeqIntervalsDouble extends SeqIntervals[Double] {
    def find(seq: Seq[Double], p: Int): Double = seq(p)
    def connected(p: Int, q: Int, seq: Seq[Double]): Boolean = find(seq, p) == find(seq, q)
    def count(seq: Seq[Double]): Int = seq.distinct.size
  }
}