package com.foerster.potato_head.variability

/**
 * Created by foerster on 27/01/15. Ninja
 */
trait Parameter[T] {
  val value : Option[T]
  def check(implicit f : T => Ordered[T]) :Boolean = true
}

trait RangeParameter[T]  extends Parameter[T]{
  val upperBound: T
  val lowerBound: T

  override def check(implicit f : T => Ordered[T]) :Boolean = super.check && { value match {
    case Some(x) if x <= upperBound && x >= lowerBound => true
    case None => true
    case _ => false
  } }
}

trait MandatoryParameter[T] extends  Parameter[T] {
  override def check(implicit f: (T) => Ordered[T]): Boolean = super.check && { value match {
    case Some(x) => true
    case None => false
  } }
}








