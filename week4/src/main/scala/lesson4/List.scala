package lesson4

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class  Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

object Nil extends List[Nothing] {
  def isEmpty = false

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {

  def apply[T]() = Nil

  def apply[T](x1: T) = new Cons[T](x1, Nil)

  def apply[T](x1: T, x2: T) = new Cons[T](x1, new Cons[T](x2, Nil))

}

object test {
  val x: List[String] = Nil
}
