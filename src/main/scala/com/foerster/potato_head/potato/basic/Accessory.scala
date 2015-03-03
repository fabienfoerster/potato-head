package com.foerster.potato_head.potato.basic

/**
 * Created by foerster on 03/03/15. Ninja
 */
trait Accessory extends Component {
  override def toString: String = s"Accessory $name with size $height x $width"
}

case class Glasses( height:Int, width: Int) extends Accessory{
  override val name = "Glasses"
}

case class Earrings( height:Int, width: Int) extends Accessory{
  override val name = "Earrings"
}

case class Gloves( height:Int, width: Int) extends Accessory{
  override val name = "Gloves"
}

case class Shoes( height:Int, width: Int) extends Accessory{
  override val name = "Shoes"
}


