package lesson1

import lesson1.Hierarchies.Empty
import lesson1.Hierarchies.NonEmpty

object Hello {

  def main(args: Array[String]): Unit = {
    println("Hello world")

    println(Empty contains 1)
    println(new NonEmpty(1, Empty, Empty) contains 1)
    println(new NonEmpty(1, Empty, Empty) contains 2)

  }

}
