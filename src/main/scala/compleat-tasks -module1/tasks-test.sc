

def isEven(x:Int) :Boolean = x % 2 == 0

isEven(2)
isEven(0)
isEven(4)
isEven(-4)
isEven(5)
isEven(3)
isEven(1)
isEven(-1)

def isOdd(x:Int) :Boolean = !isEven(x)

isOdd(2)
isOdd(0)
isOdd(4)
isOdd(-4)
isOdd(5)
isOdd(3)
isOdd(1)
isOdd(-1)

def filterEven(arr: Array[Int]): Array[Int] = arr.map(x => if (isEven(x)) Some(x) else None).flatten

filterEven(Array(1,2,3,4,0,5,-5,-6))
