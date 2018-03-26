import scala.annotation.tailrec

object tailrecursive {

  @tailrec
  def factorial(n: Int, acc: Int = 1) : Int = if (n == 0) acc else factorial(n - 1, acc * n)

  def factorialBlock(n: Int) : Int = {
    def loop(n: Int, acc: Int) : Int = if (n == 0) acc else loop(n - 1, acc * n)

    loop(n, 1)
  }

  factorial(4)
  factorialBlock(4)
}