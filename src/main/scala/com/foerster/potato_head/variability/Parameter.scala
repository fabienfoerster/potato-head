package com.foerster.potato_head.variability

/**
 * Created by foerster on 27/01/15. Ninja
 */

abstract class Parameter[+T] {
  val value : Option[T]
  def check :Boolean = true
}

object Parameter {
  def defaultValue[U]: U = { class Default[U] {var default: U = _ }; new Default[U].default }
  
  import scala.language.implicitConversions
  implicit def paramToValue[U](param: Parameter[U]): U = param.value match {
    case Some(x) => x
    case None => defaultValue[U]
  }
  
}

abstract class RangeParameter[T <% Ordered[T]]  extends Parameter[T]{
  val upperBound: T
  val lowerBound: T

  private def rangeCheck(implicit ordering: Ordering[T]) :Boolean = { value match {
   case Some(x) if ordering.lteq(x,upperBound) && ordering.gteq(x,lowerBound) => true
   case None => true
   case _ => false
 } }

  override def check: Boolean = super.check && rangeCheck
}

trait MandatoryParameter[T] extends  Parameter[T] {
  override def check: Boolean = super.check && { value match {
    case Some(x) => true
    case None => false
  } }
}

trait RelationParameter[T] extends Parameter[T] {
  val otherParam: Parameter[T]
  
  def relation(first:Parameter[T],second:Parameter[T] ) : Boolean
  
  override def check: Boolean = super.check && relation(this,otherParam)
}







