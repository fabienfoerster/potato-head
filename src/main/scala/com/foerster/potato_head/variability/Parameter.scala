package com.foerster.potato_head.variability

import com.typesafe.scalalogging.slf4j.LazyLogging

/**
 * Created by foerster on 27/01/15. Ninja
 */

abstract class Parameter[+T] extends LazyLogging{
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
   case _ => logger.info("Value is outside the range ["+lowerBound+","+upperBound+"] in RangeParameter");false
 } }

  override def check: Boolean = super.check && rangeCheck
}

trait MandatoryParameter[T] extends  Parameter[T] {
  override def check: Boolean = super.check && { value match {
    case Some(x) => true
    case None =>  logger.info("MandatoryParameter but not value set"); false
  } }
}

trait RelationParameter[T] extends Parameter[T] {
  val otherParam: Parameter[T]
  
  def relation(first:Parameter[T],second:Parameter[T] ) : Boolean
  
  override def check: Boolean = super.check && {
    if (relation(this, otherParam)) true
    else { logger.info("Relation in RelationParameter is not satisfied"); false }
  }
}







