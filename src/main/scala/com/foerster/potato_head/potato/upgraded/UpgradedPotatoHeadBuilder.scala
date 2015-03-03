package com.foerster.potato_head.potato.upgraded

import com.foerster.potato_head.potato.upgraded.PotatoHead.{PotatoWidth, PotatoHeight}
import com.foerster.potato_head.variability.{FeaturesSequence, Feature}

/**
 * Created by foerster on 03/03/15. Ninja
 */
object UpgradedPotatoHeadBuilder {
  def apply(name:String,height:PotatoHeight,width:PotatoWidth, components: Seq[Component with Feature]) : PotatoHead = {
    height.check
    width.check
    val features : FeaturesSequence = components
    if(!features.check) println("WARNING : The potatoHead you built is invalide")
    PotatoHead(name,height,width,components)
  }
}
