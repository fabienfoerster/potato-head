package com.foerster.potato_head.potato.upgraded

import com.foerster.potato_head.variability.{ExclusiveFeature, Feature, OrderedFeature}

/**
 * Created by foerster on 03/03/15. Ninja
 */
trait Accessory extends Component with OrderedFeature with ExclusiveFeature {
  override def toString: String = s"Accessory $name with size $height x $width"
}

case class Glasses( height:Int, width: Int,
                    requiredFeatures: Option[Seq[Feature]],
                    notWantedParameter: Option[Seq[Feature]]) extends Accessory{
  override val name = "Glasses"
}

case class Earrings( height:Int, width: Int,
                     requiredFeatures: Option[Seq[Feature]]
                     ) extends Accessory{
  override val name = "Earrings"
  override val notWantedParameter: Option[Seq[Feature]] = None
}

case class Gloves( height:Int, width: Int,
                   requiredFeatures: Option[Seq[Feature]],
                   notWantedParameter: Option[Seq[Feature]]) extends Accessory{
  override val name = "Gloves"
}

case class Shoes( height:Int, width: Int,
                  requiredFeatures: Option[Seq[Feature]],
                  notWantedParameter: Option[Seq[Feature]]) extends Accessory{
  override val name = "Shoes"
}




