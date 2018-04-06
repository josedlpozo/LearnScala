package lesson3

object App {

  def main(args: Array[String]): Unit = {
    def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
    println(singleton(1).head)
    println(singleton(1).tail)
  }
}
