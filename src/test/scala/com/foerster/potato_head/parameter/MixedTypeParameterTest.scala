package com.foerster.potato_head.parameter

import com.foerster.potato_head.variability.{MandatoryParameter, RangeParameter}
import org.specs2.mutable.SpecificationWithJUnit
object MixedTypeParameterTest {

  case class MixedParam(value: Option[Int]) extends RangeParameter[Int] with MandatoryParameter[Int] {
    override val upperBound: Int = 100
    override val lowerBound: Int = 10
  }

}

/**
 * Created by foerster on 26/02/15. Ninja
 */
class MixedTypeParameterTest extends SpecificationWithJUnit {
  import MixedTypeParameterTest._
  "Mixed Type Parameter Specifications".title
  
  "Range and Mandatory Parameter" should {
    "be invalide when the value is not set" in {MixedParam(None).check must_== false }
    "be valide when the value is in the range" in {MixedParam(Some(42)).check must_== true}
    "be invalide when the value is outside the range" in {MixedParam(Some(117)).check must_== false}
    
  }
  

}
