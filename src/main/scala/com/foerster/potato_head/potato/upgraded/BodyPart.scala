package com.foerster.potato_head.potato.upgraded

import com.foerster.potato_head.variability.MandatoryFeature

/**
 * Created by foerster on 03/03/15. Ninja
 */
trait BodyPart extends Component with MandatoryFeature {
  override def toString: String = s"Body Part $name with size $height x $width"
}

case class Nose( height:Int,  width:Int) extends BodyPart {
  override val name: String = "Nose"
}

case class Ears( height:Int,  width:Int) extends BodyPart {
  override val name: String = "Ears"
}

case class Eyes( height:Int,  width:Int) extends BodyPart {
  override val name: String = "Eyes"
}
case class Mouth( height:Int,  width:Int) extends BodyPart {
  override val name: String = "Mouth"
}

case class Arms( height:Int,  width:Int) extends BodyPart {
  override val name: String = "Arms"
}

case class Feet( height:Int,  width:Int) extends BodyPart {
  override val name: String = "Feet"
}
