object operators {

  class Rational(x: Int, y: Int) {
    require(y != 0, "Denominator should be different than 0")

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // Secondary constructor
    def this(x: Int) = this(x, 1)

    val numer = x
    val denom = y

    def +(rational: Rational): Rational = new Rational(numer * rational.denom + rational.numer * denom,
      denom * rational.denom)

    def unary_- : Rational = new Rational(-numer, denom)

    def -(rational: Rational): Rational = this + -rational

    def < (rational: Rational) = numer * rational.denom < rational.numer * denom

    def max(rational: Rational) = if (this < rational) rational else this

    override def toString: String = numer / gcd(x, y) + "/" + denom / gcd(x, y)
  }

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x + y
  x - y - z
  y + y

  x max y

  val other = new Rational(2)
}