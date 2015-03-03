package com.foerster.potato_head.parameter

import com.foerster.potato_head.variability.MandatoryParameter
import org.specs2.mutable.SpecificationWithJUnit

object MandatoryParameterTest {

  case class MandatoryParam(value: Option[Int]) extends MandatoryParameter[Int]

}
/**
 * Created by foerster on 27/01/15. Ninja
 */
class MandatoryParameterTest extends SpecificationWithJUnit{
  import MandatoryParameterTest._
  "Mandatory Parameter Specifications ".title



  "A MandatoryParameter" should {
    "be false if value is not set" in {MandatoryParam(None).check must_== false}
    "be true if value is set" in {MandatoryParam(Some(42)).check must_== true}
  }

}
