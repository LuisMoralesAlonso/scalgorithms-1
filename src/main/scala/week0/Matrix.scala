package week0

/**
 * @author luis
 */
class Matrix[T](nrow: Int, ncol: Int, data: List[List[T]], byRow: Boolean = false) {
  require(
    byRow match {
      case true  => { data.length == nrow; data.forall(row => row.length == ncol) }
      case false => { data.length == ncol; data.forall(col => col.length == nrow) }
    })

  def isSquared: Boolean = nrow == ncol
}