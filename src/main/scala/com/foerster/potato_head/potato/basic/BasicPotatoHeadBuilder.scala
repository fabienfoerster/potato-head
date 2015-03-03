package com.foerster.potato_head.potato.basic

/**
 * Created by foerster on 03/03/15. Ninja
 */
object BasicPotatoHeadBuilder {
  def apply(name:String,height:Int,width:Int, components: Seq[Component]) : PotatoHead = PotatoHead(name,height,width,components)
}
