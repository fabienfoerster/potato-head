package com.foerster.potato_head.feature

import com.foerster.potato_head.variability._
import org.specs2.mutable.SpecificationWithJUnit

object FeatureTest {
  import com.foerster.potato_head.parameter.RangeParameterTest._
  import com.foerster.potato_head.parameter.MandatoryParameterTest._
  val param1 = RangeParam(Some(12)) // reminder a RangeParam is valide between 10 and 100
  val param2 = RangeParam(Some(5))
  val param3 = MandatoryParam(Some(42))
  
  case class ImplFeature( parameters: Option[Seq[Parameter[Any]]]) extends Feature {
  }
  
  val goodFeature =  ImplFeature(Some(Seq(param1,param3)))
  val badFeature = ImplFeature(Some(Seq(param1,param2,param3)))
  
}

/**
 * Created by foerster on 02/03/15. Ninja
 */
class FeatureTest extends SpecificationWithJUnit {
  import FeatureTest._
  "Feature Specifications".title
  
  "A feature" should {
    "be valide if all its parameters are valide" in { goodFeature.check must_== true}
    "be invalide as soon as one parameter is invalide" in {badFeature.check must_== false}
    
  }
  
  
  
}
