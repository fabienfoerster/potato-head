package com.foerster.potato_head.potato.upgraded

/**
 * Created by foerster on 03/03/15. Ninja
 */

object PotatoComponents {
  
  // BODY PARTS
  val nose: Nose = Nose(height = 20, width = 30)
  val eyes : Eyes = Eyes(height = 10, width = 10)
  val mouth : Mouth = Mouth(height = 3, width = 60)
  val ears : Ears = Ears(height = 30, width = 10)
  val feet : Feet = Feet(height = 42, width = 5)
  val arms = Arms(height = 100, width = 20)
  
  //ACCESSORIES
  val earrings = Earrings(3,3, requiredFeatures = Some(Seq(ears)))
  val glasses1 : Glasses = Glasses(15,60,requiredFeatures = Some(Seq(ears,nose)),notWantedParameter = Some(Seq(glasses2)))
  val glasses2: Glasses = Glasses(15,60,requiredFeatures = Some(Seq(ears,nose)), notWantedParameter = Some(Seq(glasses1)))
  val gloves1: Gloves = Gloves(5,5,requiredFeatures = Some(Seq(arms)), notWantedParameter = Some(Seq(gloves2 )))
  val gloves2: Gloves = Gloves(5,5,requiredFeatures = Some(Seq(arms)), notWantedParameter = Some(Seq(gloves1 )))
  val shoes1: Shoes = Shoes(42,6,requiredFeatures = Some(Seq(feet)), notWantedParameter = Some(Seq(shoes2)))
  val shoes2: Shoes = Shoes(42,6,requiredFeatures = Some(Seq(feet)), notWantedParameter = Some(Seq(shoes1 )))

}

