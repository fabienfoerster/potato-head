package com.foerster.potato_head.potato

import com.foerster.potato_head.potato.basic.BasicPotatoHeadBuilder
import com.foerster.potato_head.potato.upgraded.UpgradedPotatoHeadBuilder

/**
 * Created by foerster on 03/03/15. Ninja
 */
object UpgradedMain extends App{

  
  import com.foerster.potato_head.potato.upgraded.PotatoComponents._
  val goodPotato = UpgradedPotatoHeadBuilder("Zorro",200,90,Seq(eyes,nose,ears,glasses1))
  println(goodPotato)
  
  println("\n\nSeparation between good and bad\n\n")

  val badPotato = UpgradedPotatoHeadBuilder("Sergeant Garcia",400,200,Seq(feet,arms,eyes,nose,shoes1,shoes2))
  println(badPotato)
}
