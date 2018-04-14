object sort {

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => x :: Nil
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  def isort(xs: List[Int]) : List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  isort(List(9, 1, 2, 298, 0))
}