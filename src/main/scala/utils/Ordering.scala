package utils

/**
 * @author luis
 */
object Ordering {
    implicit def RectangleToInt(sqr: Rectangle): Int = sqr.area
    implicit object RectangleOrdering extends Ordering[Rectangle] {
      def compare(x: Rectangle, y: Rectangle) = x.area compare y.area
    }

  
  class Rectangle(x: Int, y: Int) {
    def area: Int = x * y
    override def toString = "Area: " + area
  }
  
/*  
 *  Ahora ya podemos ordenar colecciones de "Cuadrados", en este caso basados en su area
 *  List(new Square(1,1), new Square(2,2)).sorted
 *  Que retornaría: List[utilss.Ordering.Rectangle] = List(Area: 1, Area: 4)
 */
}