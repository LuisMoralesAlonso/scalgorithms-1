package week0

import Matrix._
import Row._



object Matrix{

  /** A convenient alias */
  type Matrix = List[Row]

  /** effectively add RichMatrix methods to List[List[Double]] */
  implicit def pimp1(m:Matrix) = new RichMatrix(m)

  def apply( rowCount:Int, colCount:Int )( f:(Int,Int) => Double ) = (
      for(i <- 1 to rowCount) yield 
  ( for( j <- 1 to colCount) yield f(i,j) ).toList
    ).toList
}