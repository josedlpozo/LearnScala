package lesson1

object objects {

  abstract class Boolean {

    def ifThenElse[T](t: => T, e: => T) : T

    def < (x: Boolean) = ifThenElse(NOUP, YEP)

    def && (x: => Boolean) : Boolean = ifThenElse(x, NOUP)

    def || (x: => Boolean) : Boolean = ifThenElse(YEP, x)
    
  }

  object YEP extends Boolean {
    override def ifThenElse[T](t: => T, e: => T) = t
  }

  object NOUP extends Boolean {
    override def ifThenElse[T](t: => T, e: => T) = e
  }
}