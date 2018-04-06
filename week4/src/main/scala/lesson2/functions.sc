package lesson2

object functions {

  trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
  }

  class  Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: Boolean = false
  }

  class Nil[T] extends List[T] {
    def isEmpty = false

    def head: Nothing = throw new NoSuchElementException("Nil.head")

    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }

  object List {

    def apply[T]() = new Nil[T]

    def apply[T](x1: T) = new Cons[T](x1, new Nil[T])

    def apply[T](x1: T, x2: T) = new Cons[T](x1, new Cons[T](x2, new Nil[T]))

  }
}