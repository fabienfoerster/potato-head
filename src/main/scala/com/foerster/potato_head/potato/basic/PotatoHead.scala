package com.foerster.potato_head.potato.basic

/**
 * Created by foerster on 03/03/15. Ninja
 */

trait Component {
  val name : String
  val height: Int
  val width: Int
}

object PotatoHead {
  def apply(name:String,height:Int,width:Int,components: Seq[Component]) = new PotatoHead(name,height,width,components)
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




