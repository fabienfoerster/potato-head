package com.foerster.potato_head.parameter

import com.foerster.potato_head.variability.{Parameter, RelationParameter}
import org.specs2.mutable.SpecificationWithJUnit

case class TestRelation(value: Option[Int]) extends RelationParameter[Int]  {
  override val otherParam: Parameter[Int] = TestRange(Some(100))

  override def relation(first: Parameter[Int], second: Parameter[Int]): Boolean = first.value match {
    case Some(x) => second.value match {
      case Some(y) if x < y => true
      case _ => false      
    }
    case _ => false
  }
}

/**
 * Created by foerster on 27/02/15. Ninja
 */
class RelationParameterTest extends SpecificationWithJUnit {
  
  "Relation Parameter Specifications".title
  
  "A relation Parameter " should {
    "be invalide if the value is not set " in { TestRelation(None).check must_== false}
    "be valide if the value respect the relation condition" in { TestRelation(Some(50)).check must_== true}
    "be invalide if the value don't respect the relation condition" in { TestRelation(Some(101)).check must_== false}
    
    
  }

}
