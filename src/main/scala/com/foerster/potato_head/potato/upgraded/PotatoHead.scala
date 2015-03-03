package com.foerster.potato_head.potato.upgraded

import com.foerster.potato_head.potato.upgraded.PotatoHead.PotatoHeight
import com.foerster.potato_head.variability._
/**
 * Created by foerster on 03/03/15. Ninja
 */

trait Component extends Feature{

  override val parameters: Option[Seq[Parameter[Any]]] = None
  val name : String
  val height: Int
  val width: Int
}

object PotatoHead {
  import scala.language.implicitConversions
  def apply(name:String,height:Int,width:Int,components: Seq[Component with Feature]) = new PotatoHead(name,height,width,components)
  
  case class PotatoHeight(value: Option[Int]) extends RangeParameter[Int] {
    override val upperBound: Int = 300
    override val lowerBound: Int = 100
  }
  implicit def int2Potatoheight(h: Int) : PotatoHeight  = PotatoHeight(Some(h))
  
  case class PotatoWidth(value: Option[Int]) extends RangeParameter[Int] {
    override val upperBound: Int = 100
    override val lowerBound: Int = 10
  }
  
  implicit def values2PotatoWith(w:Int) : PotatoWidth = PotatoWidth(Some(w))
  
}

class PotatoHead(
                val name : String,
                val height: Int,
                val width: Int,
                val components: Seq[Component]
      ) {
  val potatoRatio: Double = height / width
  override def toString: String = s"This PotatoHead name is $name \n" ++
  s"Height : $height \n" ++
  s"Width : $width \n" ++
  s"Patatoid ratio : $potatoRatio \n" ++
  "He is composed of : \n" ++
    (components mkString "\n")
  
}




