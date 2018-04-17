package lesson3

object GenericsMergeSort {
  def msort[T](xs: List[T])(lt: (T, T) => Boolean) : List [T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]) : List[T] = (xs, ys) match {
        case (Nil, x) => x
        case (y, Nil) => y
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }

  def msort2[T](xs: List[T])(order: Ordering[T]) : List [T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]) : List[T] = (xs, ys) match {
        case (Nil, x) => x
        case (y, Nil) => y
        case (x :: xs1, y :: ys1) =>
          if (order.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort2(fst)(order), msort2(snd)(order))
    }
  }

  def msort3[T](xs: List[T])(implicit order: Ordering[T]) : List [T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]) : List[T] = (xs, ys) match {
        case (Nil, x) => x
        case (y, Nil) => y
        case (x :: xs1, y :: ys1) =>
          if (order.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort2(fst)(order), msort2(snd)(order))
    }
  }
}

object Main extends App {
  val nums = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
  println(GenericsMergeSort.msort(nums)((x, y) => x < y))
  println(GenericsMergeSort.msort(fruits)((x, y) => x.compareTo(y) < 0))

  println(GenericsMergeSort.msort2(nums)(Ordering.Int))
  println(GenericsMergeSort.msort2(fruits)(Ordering.String))

  println(GenericsMergeSort.msort3(nums))
  println(GenericsMergeSort.msort3(fruits))
}
