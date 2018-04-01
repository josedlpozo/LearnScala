package funsets

object Main extends App {

  import FunSets._

  println(contains(singletonSet(1), 1))

  println(contains(union(singletonSet(1), singletonSet(2)), 3))

  println(forall(x => x % 2 == 0, y => y % 3 == 0))
}
