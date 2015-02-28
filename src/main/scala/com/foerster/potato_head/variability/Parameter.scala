package com.foerster.potato_head.variability

/**
 * Created by foerster on 27/01/15. Ninja
 */

trait Parameter[+T] {
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

trait RelationParameter[T] extends Parameter[T] {
  val otherParam: Parameter[T]
  
  def relation(first:Parameter[T],second:Parameter[T] ) : Boolean
  
  override def check: Boolean = super.check && relation(this,otherParam)
}

trait OrderedParameter[T] extends Parameter[T] {
  // params who must be present before in a ParamSeq
  val requiredParams : Option[Seq[Parameter[Any]]]

  override  def check: Boolean = super.check
}

class ParameterSeq(val params:Seq[Parameter[Any]]) {
  
  private def checkCorrectOrder(orderedParams : Seq[OrderedParameter[Any]]): Boolean = {
    {
      for (param <- orderedParams; listRequire <- param.requiredParams.toList; required <- listRequire if params.indexOf(param) < params.indexOf(required) || params.indexOf(required) == -1) yield {
        false
      }
    }.foldLeft(true)((p1,p2) => p1 && p2)
  }
  
  def check: Boolean = {
    checkCorrectOrder(this.params.filter(p => p.isInstanceOf[OrderedParameter[Any]]).map(p => p.asInstanceOf[OrderedParameter[Any]])) &&
    params.map(p => p.check).foldLeft(true)((check1:Boolean,check2:Boolean)=> check1 && check2)
  }

}

object ParameterSeq {
  def apply(seq: Seq[Parameter[Any]]): ParameterSeq = new ParameterSeq(seq)

  import scala.language.implicitConversions
  implicit def seqToParamSeq(s : Seq[Parameter[Any]]): ParameterSeq = ParameterSeq(s)
  implicit def paramSeqToSeq(paramSeq: ParameterSeq): Seq[Parameter[Any]] = paramSeq.params
  
}





