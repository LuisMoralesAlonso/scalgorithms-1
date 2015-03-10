package week1

/**
 * @author luis
 */
  abstract class SeqIntervals[T](seq: Seq[T]) {
    def find(index: Int): T    
    def connected(p: Int, q: Int): Boolean = find(p)==find(q)
    def union(p: Int, q: Int): SeqIntervals[T]    
    def count: Int = seq.distinct.size 
    override def toString = seq.toString()
  }

  class QuickFind[T](seq: Seq[T]) extends SeqIntervals[T](seq: Seq[T]) {
    def find(p: Int): T = seq(p)
    def union(p: Int, q: Int): SeqIntervals[T] = 
      if (connected(p, q)) this else new QuickFind(seq map (r => if (r == find(p)) find(q) else r))
  }
  
  class QuickUnion[T](seq: Seq[T]) extends SeqIntervals[T](seq: Seq[T]) {
    def find(p: Int): T = seq(p)
    def union(p: Int, q: Int): SeqIntervals[T] = 
      if (connected(p, q)) this else new QuickFind(seq map (r => if (r == find(p)) find(q) else r))
  }
