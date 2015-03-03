package com.foerster.potato_head.feature

import com.foerster.potato_head.variability.{FeaturesSequence, Feature, Parameter, OrderedFeature}
import org.specs2.mutable.SpecificationWithJUnit


object OrderedFeatureTest {
  case class OrdFeature(val requiredFeatures: Option[Seq[Feature]]) extends OrderedFeature {
    override val parameters: Option[Seq[Parameter[Any]]] = None
  }
  val order1 = OrdFeature(None)
  val order2 = OrdFeature(Some(Seq(order1)))
  val order3 = OrdFeature(Some(Seq(order2)))
  
  val goodSequence: FeaturesSequence = Seq(order1,order2)
  val missingFeatureSequence: FeaturesSequence = Seq(order1,order3)
  val wrongOrderSequence: FeaturesSequence = Seq(order2,order1)
  
}







/**
 * Created by foerster on 02/03/15. Ninja
 */
class OrderedFeatureTest extends SpecificationWithJUnit {
  import OrderedFeatureTest._
  "Ordered Feature Specifications".title
  
  "A FeaturesSequence" should {
    "be valide if the feature are in the right order" in {goodSequence.check must_== true}
    "be invalide if a feature needed is missing " in {missingFeatureSequence.check must_== false}
    "be invalide if the features are in the wrong order " in {wrongOrderSequence.check must_== false}
    
    
  }
  

}
