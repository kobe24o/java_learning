object myClass {
    import java.io._
    class Point(xc : Int, yc : Int){
        var x : Int = xc
        var y : Int = yc
        def move(dx:Int, dy:Int): Unit ={
            x += dx
            y += dy
            println("x : " + x)
            println("y : " + y)
        }
    }

    // 继承,只能单继承
    class Piont3D( val xc : Int, val yc : Int,
                  val zc : Int) extends Point(xc, yc){
        var z : Int = zc
        def move(dx:Int, dy:Int, dz:Int): Unit ={
            x += dx
            y += dy
            z += dz
            println("x : " + x)
            println("y : " + y)
            println("z : " + z)
        }
    }
    def main(args: Array[String]) = {
        val p1 = new Point(10, 20)
        p1.move(2, 3)
        // x : 12
        // y : 23

        val p2 = new Piont3D(10, 30, 50)
        p2.move(1,2,3)
        // x : 11
        // y : 32
        // z : 53

        val fred = new Employee
        fred.name = "Fred"
        fred.salary = 50000
        println(fred) // myClass$Employee[name=Fred][salary=50000.0]


        val p3 = new Point2(2, 3)
        val p4 = new Point2(2, 4)
        val p5 = new Point2(3, 3)

        println(p3.isNotEqual(p4)) // false
        println(p3.isNotEqual(p5)) // true
        println(p3.isNotEqual(2)) // true
    }
    class Person {
        var name = ""
        override def toString = getClass.getName + "[name=" + name + "]"
    }

    class Employee extends Person {
        var salary = 0.0
        override def toString = super.toString + "[salary=" + salary + "]"
    }

    // Trait 特征， 很像 Java 的抽象类
    trait Equal {
        def isEqual(x : Any) : Boolean
        def isNotEqual(x : Any) : Boolean = !isEqual(x)
    }
    class Point2(xc : Int, yc : Int) extends Equal {
        var x : Int = xc
        var y : Int = yc
        def isEqual(obj : Any) = {
            obj.isInstanceOf[Point2] && obj.asInstanceOf[Point2].x == x
        }
    }
}
