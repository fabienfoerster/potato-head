package com.foerster.potato_head.potato

import com.foerster.potato_head.variability.{RangeParameter, MandatoryParameter}

/**
 * Created by foerster on 28/01/15. Ninja
 */
case class PotatoName(value: Option[String]) extends MandatoryParameter[String]
case class PotatoHeight(value: Option[Int]) extends RangeParameter[Int] {
  override def upperBound: Int = 200
  override def lowerBound: Int = 100
}

class PotatoHead(name: Option[String], height: Option[Int]) {
  val potatoName : PotatoName = PotatoName(name)
  val potatoHeight: PotatoHeight = PotatoHeight(height)

}
