

def sum(x: Int, y: Int): Int = x + y

sum(3, 2)

val sum2: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
  override def apply(v1: Int, v2: Int): Int = v1 + v2
}

val r2: Int = sum2(2, 3) // 5

val sum3: (Int, Int) => Int = sum _

sum3(2, 3) // 5

List(sum2, sum3)

val divide: PartialFunction[(Int, Int), Int] = new PartialFunction[(Int, Int), Int] {
  override def isDefinedAt(x: (Int, Int)): Boolean = x._2 != 0

  override def apply(v1: (Int, Int)): Int = v1._1 / v1._2
}
if (divide.isDefinedAt(4,2))  divide(4,2)

//divide(4,0)

val divide2: PartialFunction[(Int, Int), Int] = {
  case (a, b) if b != 0 => a / b
}


divide2.isDefinedAt(5, 0) // false
if (divide2.isDefinedAt(4, 2)) divide2(4, 2)

trait Printer {
  def apply(s: String, n:Int): Unit
}

val p: Printer = (a,b) => println(s"$a $b")

p("Привет ад номер", 5)