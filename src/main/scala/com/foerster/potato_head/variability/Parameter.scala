package com.foerster.potato_head.variability

/**
 * Created by foerster on 27/01/15. Ninja
 */
trait Parameter[T] {
  val value : T
  def check(implicit f : T => Ordered[T]) :Boolean
}



trait RangeParameter[T]  extends Parameter[T]{
  def upperBound: T
  def lowerBound: T

  override def check(implicit f : T => Ordered[T]) :Boolean = value <= upperBound && value >= lowerBound
}



