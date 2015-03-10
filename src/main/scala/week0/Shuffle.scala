package week0

import scala.util._
/**
 * @author luis
 */
object Shuffle {
  def shuffle(lista: List[Int], t: String): List[Int] = t match {
    case "palgorithm" => palgorithm(lista)
    case "sattolo"    => sattolo(lista)
  }

  def palgorithm(lista: List[Int]): List[Int] = lista match {
    case Nil                => throw new Exception("Empty List")
    case y if y.length == 2 => y.tail ++ List(y.head)
    case y => Random.nextInt(y.length) match {
      case 0                           => lista.head :: palgorithm(List(lista.last) ++ lista.init.tail)
      case z if z == lista.init.length => lista.last :: palgorithm(lista.init)
      case z                           => lista(z) :: palgorithm((lista.init take z) ++ List(lista.last) ++ (lista.init drop z + 1))
    }
  }

  def sattolo(lista: List[Int]): List[Int] = lista match {
    case Nil                => throw new Exception("Empty List")
    case y if y.length == 2 => y.tail ++ List(y.head)
    case y => Random.nextInt(y.init.length) match {
      case 0                           => lista.head :: sattolo(List(lista.last) ++ lista.init.tail)
      case z if z == lista.init.length => lista.init.last :: sattolo(lista.init.init ++ List(lista.last))
      case z                           => lista(z) :: sattolo((lista.init take z) ++ List(lista.last) ++ (lista.init drop z + 1))
    }
  }
}