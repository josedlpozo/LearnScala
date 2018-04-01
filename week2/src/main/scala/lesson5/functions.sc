object functions {

  class Rational(x: Int, y: Int) {
    require(y != 0, "Denominator should be different than 0")
    private def gcd(a: Int, b: Int) : Int = if (b == 0) a else gcd(b, a % b)

    // Secondary constructor
    def this(x: Int) = this(x, 1)

    val numer = x / gcd(x, y)
    val denom = y / gcd(x, y)

    def add(rational: Rational): Rational = new Rational(numer * rational.denom + rational.numer * denom,
      denom * rational.denom)

    def neg(): Rational = new Rational(- numer, denom)

    def sub(rational: Rational): Rational = add(rational.neg())

    def less(rational: Rational) = numer * rational.denom < rational.numer * denom

    def max(rational: Rational) = if (this.less(rational)) rational else this

    override def toString: String = numer + "/" + denom
  }

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.add(y)
  x.sub(y).sub(z)
  y.add(y)

  val other = new Rational(2)
}