package week1

/**
 * @author luis
 */

import scala.reflect._

object Sort {
  def selectionSort[A <% Ordered[A]](xs: Array[A])(implicit ctag: ClassTag[A]): Array[A] = {
    def stepOrder(acc: Array[A], xs: Array[A]): Array[A] = xs match {
      case xs if xs.isEmpty => acc
      case _                => xs.min +: stepOrder(acc, xs.diff(Array(xs.min)))
    }
    stepOrder(Array(), xs)
  }

  def quickSort[A <% Ordered[A]](xs: Array[A])(implicit ctag: ClassTag[A]): Array[A] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        quickSort(xs filter (pivot >)),
        xs filter (pivot ==),
        quickSort(xs filter (pivot <)))
    }
  }

  def insertionSort[A <% Ordered[A]](xs: List[A]): List[A] = {
    def insert(list: List[A], value: A) = list.span(x => x < value) match {
      case (lower, upper) => lower ::: value :: upper
    }
    xs.foldLeft(List.empty[A])(insert)
  }
}