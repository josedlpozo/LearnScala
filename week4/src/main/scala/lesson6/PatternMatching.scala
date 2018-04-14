package lesson6

trait Expr3 {
  def eval(): Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Product(e1, e2) => e1.eval * e2.eval
  }

  def show(): String = this match {
    case Number(n) => n.toString
    case Sum(e1, e2) => e1.show + " + " + e2.show
    case Product(e1, e2) => "(" + e1.show + " * " + e2.show + ")"
  }
}

case class Number(n: Int) extends Expr3
case class Sum(e1: Expr3, e2: Expr3) extends Expr3
case class Product(e1: Expr3, e2: Expr3) extends Expr3

object Number {
  def apply(n: Int): Number = new Number(n)
}

object Sum {
  def apply(e1: Expr3, e2: Expr3): Sum = new Sum(e1, e2)
}

object Product {
  def apply(e1: Expr3, e2: Expr3): Product = new Product(e1, e2)
}