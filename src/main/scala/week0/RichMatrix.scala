package week0

import Matrix._
import Row._
import RichMatrix._

/** Methods that are added to List[List[Double]] by an implicit conversion */
case class RichMatrix(m:Matrix){

  def T = transpose(m)

  /** Matrix addition */
  def +(that:RichMatrix) = add( this.m, that.m )

  /** Matrix subtraction */
  def -(that:RichMatrix) = subtract( this.m, that.m )

  /** Matrix multiplication */
  def *(that:RichMatrix) = mXm( this.m, that.m )

  /** Scalar multiplication */
  def *(s:Double) = mXs( this.m, s:Double )

  def unary_- = mXs( this.m, -1.0 )

  def beside(right:RichMatrix) 
    = this.m.zip( right.m ).map{ t:(Row,Row) => t._1 ::: t._2 }

  def above(below:RichMatrix) = this.m ::: below.m

  def minor(i:Int, j:Int) = minorMat(m,i,j)

  def apply(i:Int,j:Int) = m(i)(j)

  def rowCount = m.length
  def colCount = m.head.length

  def isSquare = (rowCount==colCount)

  def toStr = "\n"+m.map{ 
    _.map{"\t" + _}.reduceLeft(_ + _)+"\n"
  }.reduceLeft(_ + _)

  def foreachElement(doit:(Double)=>Unit) {
    for(row <- m){ for( x <- row ){ doit(x) } }
  }

}

object RichMatrix{

  private def posneg(n:Int) = 2*((n+1)%2)-1

  private def transpose(m:Matrix):Matrix = 
    if(m.head.isEmpty) Nil else m.map(_.head) :: transpose(m.map(_.tail))

  private def mXs(m:Matrix, s:Double) = m.map( _.map( _ * s ) )

  private def mXv(m:Matrix, v:Row) = {
    require( rowCount(m)==v.length )
    m.map{ dotProd(_,v) }
  }

  private def mXm(m1:Matrix,m2:Matrix) = {
    require( colCount(m1)==rowCount(m2) )
    m2 map (mXv(transpose(m1),_))  
  }

  private def add(m1:Matrix,m2:Matrix) = m1.zip( m2 ).map{ rows:(Row,Row) =>
    rows._1.zip( rows._2 ).map{ items:(Double,Double) =>
      items._1 + items._2
    }
  }

  private def subtract(m1:Matrix,m2:Matrix) = m1.zip( m2 ).map{ rows:(Row,Row) =>
    rows._1.zip( rows._2 ).map{ items:(Double,Double) =>
      items._1 - items._2
    }
  }

  private def rowCount(m:Matrix) = m.length
  private def colCount(m:Matrix) = m.head.length

  

  private def minorMat(mat:Matrix, i:Int, j:Int) = {
    drop1(mat,i).map{ drop1(_,j) }
  }

  private def drop1[A](list:List[A], i:Int) = {
    if(i==0)
      list.tail
    else{
      val n = list.length
      assert( n>=2 )
      assert( 0<=i && i < n )
      if( i == n-1 )
	list.dropRight(1)
      else
	list.dropRight(n-i) ::: list.drop(i+1)
    }
  }

}