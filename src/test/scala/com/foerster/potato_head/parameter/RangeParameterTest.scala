package com.foerster.potato_head.parameter

import com.foerster.potato_head.variability.RangeParameter
import org.specs2.mutable._

object RangeParameterTest {
  case class RangeParam(value: Option[Int]) extends RangeParameter[Int] {
    override val upperBound: Int = 100
    override val lowerBound: Int = 10
  }
  
}



/**
 * Created by foerster on 27/01/15. Ninja
 */
class RangeParameterTest extends SpecificationWithJUnit {

  import RangeParameterTest._
  "Range Parameter Specifications ".title


  "A RangeParameter" should {
    " be true if value is not set" in { RangeParam(None).check must_== true}
    "be false if value is greater than upper bound" in { RangeParam(Some(102)).check must_== false}
    "be false if value is smaller than lower bound" in { RangeParam(Some(9)).check must_== false}
    "be true if value is smaller than upper bound and greater than lower bound" in { RangeParam(Some(42)).check must_== true}
  }

}
