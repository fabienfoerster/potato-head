package com.foerster.potato_head

import com.foerster.potato_head.potato.PotatoHead

/**
 * Created by foerster on 29/01/15. Ninja
 */
object Main extends App {
  val potato = new PotatoHead(Some("henry"),Some(172))
  println(potato.potatoHeight.check)
  println(potato.potatoName.check)
}
