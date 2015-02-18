package week0

object BinCoefficients {
  def binomial(i: Int, j: Int): Int = i match {
    case 0 => throw new Exception("Invalid parameter: i=" + i)
    case 1 => if (j == 1) 1 else throw new Exception("Invalid parameters: i=" + i + ", j=" + j)
    case i => j match {
      case 0                => throw new Exception("Invalid parameter: j=" + j)
      case 1                => binomial(i - 1, j)
      case y if i.equals(y) => binomial(i - 1, i - 1)
      case _                => binomial(i - 1, j - 1) + binomial(i - 1, j)
    }
  } //> binomial: (i: Int, j: Int)Int
}