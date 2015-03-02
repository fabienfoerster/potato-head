package com.foerster.potato_head.variability

/**
 * Created by foerster on 02/03/15. Ninja
 */

abstract class Feature {
  
  val parameters: Option[Seq[Parameter[Any]]]
  
  def check: Boolean = parameters match {
    case Some(params) => check(params)
    case None => true
  }
  
  private def check(params : Seq[Parameter[Any]]): Boolean = params match {
    case p :: rest if p.check => check(rest)
    case Nil => true
    case _ => false    
  }
}


trait OrderedFeature extends Feature {
  // params who must be present before in a ParamSeq
  val requiredFeatures : Option[Seq[Feature]]

}

trait ExclusiveFeature extends Feature {
  val notWantedParameter : Option[Seq[Feature]]

}

trait MandatoryFeature[T] extends Feature

class FeaturesSequence(val features:Seq[Feature]) {
  
  private def precedence(feature: Feature , precedents: Seq[Feature]): Boolean = precedents match {
    case p :: rest if features.indexOf(feature) > features.indexOf(p) 
      && features.indexOf(p) != -1 => precedence(feature,rest)
    case Nil => true
    case _ => false
  }
  
  private def noPresence(notWanted: Seq[Feature]): Boolean = notWanted match {
    case feature :: rest if features.indexOf(feature) == -1 => noPresence(rest)
    case Nil => true
    case _ => false
    
  }

  private def checkOrderedFeatures(orderedFeatures : Seq[OrderedFeature]): Boolean = {
    /*{
      for (param <- orderedParams; listRequire <- param.requiredParams.toList; required <- listRequire if features.indexOf(param) < features.indexOf(required)
        || features.indexOf(required) == -1) yield {
        false
      }
    }.foldLeft(true)((p1,p2) => p1 && p2)*/
    orderedFeatures match {
      case f :: rest => precedence(f,f.requiredFeatures.getOrElse(List())) && checkOrderedFeatures(rest)
      case Nil => true
    }
  }

  private def checkExclusiveFeatures(exclusiveFeatures: Seq[ExclusiveFeature]): Boolean = {
   /* {
      for (param <- relouParameters; listRelou <- param.notWantedParameter.toList; relou: Parameter[Any] <- listRelou if features.indexOf(relou) != -1) yield {
        false
      }
    }.foldLeft(true)((p1,p2) => p1 && p2)*/
    exclusiveFeatures match {
      case f :: rest => noPresence(f.notWantedParameter.getOrElse(List())) && checkExclusiveFeatures(rest)
      case Nil => true
      
    }
    
  }

  def check: Boolean = {
    checkOrderedFeatures(this.features.filter(p => p.isInstanceOf[OrderedFeature]).map(p => p.asInstanceOf[OrderedFeature])) &&
      checkExclusiveFeatures(this.features.filter(p => p.isInstanceOf[ExclusiveFeature]).map(p => p.asInstanceOf[ExclusiveFeature])) &&
      features.forall(f => f.check)
  }

}

object FeaturesSequence {
  def apply(seq: Seq[Feature]): FeaturesSequence = new FeaturesSequence(seq)

  import scala.language.implicitConversions
  implicit def seqToParamSeq(s : Seq[Feature]): FeaturesSequence = FeaturesSequence(s)
  implicit def paramSeqToSeq(paramSeq: FeaturesSequence): Seq[Feature] = paramSeq.features

}
