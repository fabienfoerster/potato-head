package com.foerster.potato_head.parameter

import com.foerster.potato_head.variability.MandatoryParameter
import org.specs2.mutable.SpecificationWithJUnit

case class TestMandatory(value: Option[Int]) extends MandatoryParameter[Int]

/**
 * Created by foerster on 27/01/15. Ninja
 */
class MandatoryParameterTest extends SpecificationWithJUnit{

  "Mandatory Parameter Specifications ".title



  "A MandatoryParameter" should {
    "be false if value is not set" in {TestMandatory(None).check must_== false}
    "be true if value is set" in {TestMandatory(Some(42)).check must_== true}
  }

}
