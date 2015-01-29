package com.foerster.potato_head

import com.foerster.potato_head.variability.RangeParameter
import org.specs2.mutable._

/**
 * Created by foerster on 27/01/15. Ninja
 */
class RangeParameterTest extends SpecificationWithJUnit {

  "Range Parameter Specifications ".title

  case class Test(value: Option[Int]) extends RangeParameter[Int] {
    override val upperBound: Int = 100
    override val lowerBound: Int = 10
  }



  "A RangeParameter" should {
    " be true if value is not set" in { Test(None).check must_== true}
    "be false if value is greater than upper bound" in { Test(Some(102)).check must_== false}
    "be false if value is smaller than lower bound" in { Test(Some(9)).check must_== false}
    "be true if value is smaller than upper bound and greater than lower bound" in { Test(Some(42)).check must_== true}
  }

}
