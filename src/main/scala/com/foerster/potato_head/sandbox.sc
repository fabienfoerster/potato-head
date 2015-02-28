
import AddHeight._
import com.foerster.potato_head.variability._

class AddHeight(val max: MaxParam) {
}

object AddHeight {
  case class MaxParam(value: Option[Int]) extends RangeParameter[Int] with MandatoryParameter[Int] {
    override val upperBound: Int = 100
    override val lowerBound: Int = 10
  }

  implicit def int2MaxParam(i: Int): MaxParam = MaxParam(Some(i))
}




val test = new AddHeight(MaxParam(None))
test.max.check

class Ops[T : Numeric] {
  import Ordering.Implicits._
  import Numeric.Implicits._
     def add(a: T, b: T) = a + b
     def gt(a: T, b: T) = a > b
   }

val ops = new Ops[Int]
ops.gt(10,100)

case class Truc(name : String)

val p = Truc("fabien")
val q = Truc("adrien")

case class Panda(value: Option[Truc]) extends MandatoryParameter[Truc]

val panda = Panda(Some(Truc("buffy")))
panda.check

case class Salope(value: Option[Int],requiredParams: Option[Seq[Parameter[Any]]]) extends OrderedParameter[Int] {

}

val order1 = Salope(Some(12),None)
val order3 = Salope(Some(14),Some(Seq(order1)))
val order2 = Salope(Some(5),Some(Seq(order1)))


val testSeq: ParameterSeq = Seq(Panda(Some(Truc("fabien"))),order2,order3)
testSeq.check
val groot : Seq[Parameter[Any]] = testSeq