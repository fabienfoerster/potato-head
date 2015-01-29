import com.foerster.potato_head.variability.{MandatoryParameter, RangeParameter}
import AddHeight._
class AddHeight(val max: MaxParam) {


}

object AddHeight {
  case class MaxParam(value: Option[Int]) extends RangeParameter[Int] with MandatoryParameter[Int] {
    override val upperBound: Int = 100
    override val lowerBound: Int = 10
  }

  implicit def int2MaxParam(i: Int): MaxParam = MaxParam(Some(i))
}
val test = new AddHeight(12)
test.max.check