package com.foerster.potato_head.potato

import com.foerster.potato_head.potato.basic.BasicPotatoHeadBuilder


/**
 * Created by foerster on 03/03/15. Ninja
 */
object BasicMain extends App{
  
  import com.foerster.potato_head.potato.basic.PotatoComponents._
  val potatoRodrigo = BasicPotatoHeadBuilder("Roberto",200,90,Seq(eyes1,nose1,glasses,feet,arms,gloves))
  println(potatoRodrigo)
  

}
