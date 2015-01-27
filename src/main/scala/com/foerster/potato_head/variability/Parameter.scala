package com.foerster.potato_head.variability

/**
 * Created by foerster on 27/01/15.
 */
trait Parameter[T] {
  val value : T
  def check[T <% Ordered[T]] : Boolean
}

trait RangeParameter  extends Parameter[Int]{
  def upperBound: Int
  def lowerBound: Int

  override def check[T <% Ordered[T]]: Boolean = value match {
      case x if x >= upperBound && x <= lowerBound => true
      case _ => false
  }
}
