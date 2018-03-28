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
}