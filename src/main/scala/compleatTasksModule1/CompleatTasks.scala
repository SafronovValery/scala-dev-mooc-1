package compleatTasksModule1

import scala.annotation.tailrec

object CompleatTasks {

  //в Commit 2 - несущественные исправления удучшающие стиль.


  /**
   * Задание 1. Написать ф-цию метод isEven, которая будет вычислять является ли число четным
   */

  def isEven(x: Int): Boolean = x % 2 == 0

  val stringEven: Boolean => String = a => if (a) "четное" else "нечетное"

  def printEvens(ns: Seq[Int]): Unit = ns.map {
    x => s"$x   ${stringEven(isEven(x))}"
  }.foreach(println)

  /**
   * Задание 2. Написать ф-цию метод isOdd, которая будет вычислять является ли число нечетным
   */

  def isOdd(x: Int): Boolean = !isEven(x)

  def toOdd(ns: Seq[Int]): Seq[Boolean] = ns.map(isOdd)

  /**
   * Задание 3. Написать ф-цию метод filterEven, которая получает на вход массив чисел и возвращает массив тех из них,
   * которые являются четными
   */

  def filterEven(arr: Array[Int]): Array[Int] = arr.flatMap(x => Some(x).filter(isEven))

  /**
   * Задание 4. Написать ф-цию метод filterOdd, которая получает на вход массив чисел и возвращает массив тех из них,
   * которые являются нечетными
   */

  def filterOdd(arr: Array[Int]): Array[Int] = arr.flatMap(x => if (isEven(x)) None else Some(x))


  def filterOdd2(arr: Array[Int]): Array[Int] = {
    def filterFunction(l: List[Int]): List[Int] = l match {
      case Nil => List[Int]()
      case head :: tail if isOdd(head) => head +: filterFunction(tail)
      case _ :: tail => filterFunction(tail)
    }

    filterFunction(arr.toList).toArray
  }

  def filterOdd3(arr: Array[Int]): Array[Int] = {
    @tailrec
    def filterFunction(l: List[Int], acc: List[Int]): List[Int] = l match {
      case Nil => acc
      case head :: tail if isOdd(head) => filterFunction(tail, head +: acc)
      case _ :: tail => filterFunction(tail, acc)
    }

    filterFunction(arr.toList, List()).reverse.toArray
  }

  //комментарий добавлять надо в начало поскольку добавление в еонец дорогая операция для List

  def filterOdd4(arr: Array[Int]): Array[Int] = arr.toList
    .foldLeft(List[Int]())((acc, x) => if (isOdd(x)) x +: acc else acc)
    .reverse.toArray


  //для безопасности стэка на длинных списках надо использовать метод FoldLeft
  //поскольку  его рекуривное определение содержит хвостовую рекурсию, которая оптимизируется компилятором

  //в реализациях filterOdd3 filterOdd4, чтобы сохранить порядок  элементов
  // список полученный рекурсией надо инверировать, посколько построение списка начинается  только когда
  // рекурсия начнет разворачиваться от последнего элемента

}
