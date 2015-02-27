package week0

import scala.util._
/**
 * @author luis
 */
object Shuffle {
  implicit class Shuffle(lista: List[Int])(implicit t: String) {
    t match {
      case "palgorithm" => shuffle(lista)
    }
  }

    def shuffle(lista: List[Int]): List[Int] = lista match {

    case Nil                => throw new Exception("Empty List")

    case y if y.length == 2 => y.tail++List(y.head)

    case y => Random.nextInt(y.init.length) match {

      case 0                           => lista.head :: shuffle(List(lista.last) ++ lista.init.tail)

      case z if z == lista.init.length => lista.init.last :: shuffle(lista.init.init ++ List(lista.last))

      case z                           => lista(z) :: shuffle((lista.init take z) ++ List(lista.last) ++ (lista.init drop z + 1))

    }

  }  
}