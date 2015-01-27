package com.foerster.potato_head

import com.foerster.potato_head.variability.RangeParameter
import org.specs2.mutable._

/**
 * Created by foerster on 27/01/15.
 */
class RangeParameterTest extends SpecificationWithJUnit {

  "Range Parameter Specifications ".title

  case class Test(value: Int) extends RangeParameter {
    override def upperBound: Int = 10

    override def lowerBound: Int = 100
  }



  "A RangeParameter" should {
    "be false if value is greater than upper bound" in { Test(102).check must_== false}
    "be false if value is smaller than lower bound" in { Test(9).check must_== false}
    "be true if value is smaller than upper bound and greater than lower bound" in { Test(42).check must_== true}
  }

}
