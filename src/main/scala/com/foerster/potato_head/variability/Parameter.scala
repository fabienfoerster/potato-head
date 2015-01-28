package com.foerster.potato_head.variability

/**
 * Created by foerster on 27/01/15. Ninja
 */
trait Parameter[T] {
  val value : T
  def check : Boolean
}

trait RangeParameter  extends Parameter[Int]{
  def upperBound: Int
  def lowerBound: Int

  override def check :Boolean = value <= upperBound && value >= lowerBound
}



