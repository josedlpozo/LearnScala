object hierarchies {

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

    override def incl(x: Int) =
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(elem, left, right incl x)
      else this

    override def contains(x: Int) =
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true

    override def toString: String = "{" + left + elem + right + "}"
  }

  class Empty extends IntSet {
    override def incl(x: Int) = new NonEmpty(x, new Empty, new Empty)

    override def contains(x: Int) = false

    override def toString: String = "."
  }

  new IntSet {
    override def contains(x: Int): Boolean = false

    override def incl(x: Int): IntSet = this
  }

  abstract class IntSet {
    def incl(x: Int): IntSet

    def contains(x: Int): Boolean
  }


  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4

}