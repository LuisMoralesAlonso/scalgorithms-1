package week1

/**
 * @author luis
 */

import scala.reflect._
object Sort {
  def selectionSort[A <% Ordered[A]](lista: Seq[A]): Seq[A] = {
    def stepOrder(acc: Seq[A], lista: Seq[A]): Seq[A] = lista match {
      case Nil => acc
      case _   => lista.min +: stepOrder(acc, lista.diff(Seq(lista.min)))
    }
    stepOrder(Seq(), lista)
  }

  def insertionSort[A <%Ordered[A]](xs: Array[A])(implicit ctag: ClassTag[A]): Array[A] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        insertionSort(xs filter (pivot >)),
        xs filter (pivot ==),
        insertionSort(xs filter (pivot <)))
    }
  }
}