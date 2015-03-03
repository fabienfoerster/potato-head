package com.foerster.potato_head.feature

import com.foerster.potato_head.variability.{FeaturesSequence, Feature, Parameter, ExclusiveFeature}
import org.specs2.mutable.SpecificationWithJUnit

object ExclusiveFeatureTest {
  case class ExcFeature(val notWantedParameter: Option[Seq[Feature]]) extends ExclusiveFeature {
    override val parameters: Option[Seq[Parameter[Any]]] = None
  } 
  
  val exclusive1 = ExcFeature(None)
  val exclusive2 = ExcFeature(Some(Seq(exclusive1)))
  val exclusive3 = ExcFeature(Some(Seq(exclusive2)))
  
  val goodSequence: FeaturesSequence = Seq(exclusive1,exclusive3)
  val wrongSequence: FeaturesSequence = Seq(exclusive2,exclusive1)
  
}

/**
 * Created by foerster on 02/03/15. Ninja
 */
class ExclusiveFeatureTest extends SpecificationWithJUnit {
  import ExclusiveFeatureTest._
  "Exclusive Feature Specifications".title
  
  "A FeatureSequence" should {
    "be valide if no contraint has been violated" in {goodSequence.check must_== true}
    "be invalide if a contraint has been violated" in {wrongSequence.check must_== false}
    
  }

}
