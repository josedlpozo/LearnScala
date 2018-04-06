package lesson3

import lesson1.{Nat, Succ, Zero}

object polymorphism {

  /*
  Type bounds
   - S <: T --> S is a subtype of T
   - S >: T --> S is a supertype of T, or T is a subtype of S

   [S >: NonEmpty <: IntSet] --> Restrict between any type between NonEmpty and IntSet
   */

  // This doesn't compile because array types are not covariant
  val array : Array[Succ] = Array(new Succ(new Succ(Zero)))
  val b : Array[Nat] = array

}