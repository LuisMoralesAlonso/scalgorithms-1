package week1

/**
 * @author luis
 */
abstract class SeqIntervals(seq: Seq[Int]) {
  def find(index: Int): Int
  def connected(p: Int, q: Int): Boolean = find(p) == find(q)
  def union(p: Int, q: Int): SeqIntervals
  def count: Int = seq.distinct.size
  override def toString = seq.toString()
}

class QuickFind(seq: Seq[Int]) extends SeqIntervals(seq: Seq[Int]) {
  def find(p: Int): Int = seq(p)
  def union(p: Int, q: Int): SeqIntervals =
    if (connected(p, q)) this else new QuickFind(seq map (r => if (r == find(p)) find(q) else r))
}

class QuickUnion(seq: Seq[Int]) extends SeqIntervals(seq: Seq[Int]) {
  def find(p: Int): Int = p match {
    case index if index == seq(index) => index
    case index => find(seq(index))
  }
  def union(p: Int, q: Int): SeqIntervals =
    if (connected(p, q)) this else new QuickUnion(seq updated (find(p),find(q)))
}
