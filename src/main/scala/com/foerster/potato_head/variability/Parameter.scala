package com.foerster.potato_head.variability

/**
 * Created by foerster on 27/01/15. Ninja
 */

trait Parameter[T] {
  val value : Option[T]
  def check :Boolean = true
}

abstract class RangeParameter[T <% Ordered[T]]  extends Parameter[T]{
  val upperBound: T
  val lowerBound: T

  private def rangeCheck(implicit ordering: Ordering[T]) :Boolean = super.check && { value match {
   case Some(x) if ordering.lteq(x,upperBound) && ordering.gteq(x,lowerBound) => true
   case None => true
   case _ => false
 } }

  override def check: Boolean = rangeCheck
}

trait MandatoryParameter[T] extends  Parameter[T] {
  override def check: Boolean = super.check && { value match {
    case Some(x) => true
    case None => false
  } }
}








