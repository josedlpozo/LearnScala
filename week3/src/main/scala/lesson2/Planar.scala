package lesson2

trait Planar {

  def height: Int
  def width: Int

  def surface = height * width

}
