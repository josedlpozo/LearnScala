package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = if (c == 0) 1 else if (r == 0) 0 else {
      pascal(c, r - 1) + pascal(c - 1, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop (chars: List[Char], nOpen: Int, nClose: Int) : Boolean = if (chars.isEmpty) nOpen == nClose else {
        val open = if (chars.head == '(') nOpen + 1 else nOpen
        val close = if (chars.head == ')') nClose + 1 else nClose
        loop(chars.tail, open, close)
      }

      if (chars.contains('(') || chars.contains(')')) loop(chars, 0, 0)
      else false
    }

  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = if (money == 0) 1
      else if (coins.isEmpty || money < 0) 0
      else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
