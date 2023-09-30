import compleatTasksModule1.CompleatTasks._

object Main {

  def main(args: Array[String]): Unit = {
    println("Hello world ")



   /**           Задание 1           */
    println("------Задание 1-------")
    val numbers: Seq[Int] = Seq(2,0,4,-4,5,3,1,-1)
    printEvens(numbers)

    /**         Задание 2            */
    println("------Задание 2-------")
    println(toOdd(numbers))

    /**         Задание 3            */
    println("------Задание 3-------")
    filterEven( numbers.toArray).foreach(x => print(s"$x "))
    println

    /**         Задание 4           */
    println("------Задание 4-------")
    filterOdd(numbers.toArray).foreach(x => print(s"$x "))
    println
    filterOdd2(numbers.toArray).foreach(x => print(s"$x "))
    println
    filterOdd3(numbers.toArray).foreach(x => print(s"$x "))
    println
    filterOdd4(numbers.toArray).foreach(x => print(s"$x "))
    println
  }


}