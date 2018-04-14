package lesson5

trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Num(n: Int) extends Expr {
  override def isNumber: Boolean = true

  override def isSum: Boolean = false

  override def numValue: Int = n

  override def leftOp: Expr = throw new Error("Num.leftOp")

  override def rightOp: Expr = throw new Error("Num.rightOp")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  override def isNumber: Boolean = false

  override def isSum: Boolean = true

  override def numValue: Int = throw new Error("Sum.numValue")

  override def leftOp: Expr = e1

  override def rightOp: Expr = e2
}

object test {
  def eval(e: Expr) : Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }

}