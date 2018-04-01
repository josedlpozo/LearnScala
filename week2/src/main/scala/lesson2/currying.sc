object currying {
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)

    sumF
  }

  def sumCubes = sum(x => x * x * x)

  def sumId = sum(x => x)

  sumId(5, 6)



  def sumCurry(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumCurry(f)(a + 1, b)

  sumCurry(x => x)(5, 6)


  def product(f: Int => Int)(a: Int, b: Int): Int = if (a > b) 1
    else f(a) * product(f)(a + 1, b)

  product(x => x * x)(1, 2)

  def factorial(n: Int) : Int = product(x => x)(n - 1, n)

  factorial(4)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int) : Int = if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  mapReduce(x => x, (x, y) => x + y, 0)(1, 2)
}