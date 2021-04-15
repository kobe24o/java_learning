object HelloWorld {
    def main(args: Array[String]):Unit = { // Unit 相当于 void
        println("Hello World!")
        var myVar : String = "Foo"
        val myVal : String = "Too"
        myVar = "hello"
        // myVal = "world" // val 相当于常量，不能再次赋值
        val a, b, c = 100 // 不能分别赋值
        println(a,b,c) //(100,100,100)
        var pa = (40, "foo")
        println(pa) // (40,foo)
        if(a < 200)
            println("a < 200")
        else if(a == 200)
            println("a == 200")
        else
            println("a > 200")

        var n = 10
        while(n > 0){
            println(n)
            n -= 1
        }
        n = -1
        do{
            println(n)
            n -= 1
        }while(n > 0)

        for(x <- 1 to 10){
            println(x) // 包含结束的数
        }
        for(x <- 1 to 3; y <- 1 to 3){
            println(x, y) // 双重循环
        }
        var numList = List(100,2,3,4,5)
        for(a <- numList){
            println(a)
        }
        // 过滤元素
        for(a <- numList if a < 5; if a != 3){
            println(a)
        }
        // for yield ： for 的返回值作为变量存储
        var returnVal = for{a <- numList if a < 5; if a != 3} yield a
        for(a <- returnVal)
            println(a)

        import scala.util.control._
        val loop = new Breaks
        loop.breakable{
            for(a <- numList){
                println(a)
                if(a == 3)
                    loop.break
            }
        }
        println("after break")

        // val 定义函数， def 定义方法
        class Test{
            def method(x:Int) = x + 3 // 多行语句，可用{}

            val func = (x:Int) => x + 3
        }
        var obj = new Test()
        println(obj.method(2)) // 5
        println(obj.func(2)) // 5

        // 可变参数
        def printString(s : String*) = {
            for(si <- s)
                println(si)
        }
        printString("hello","michael","scala");

        //指定参数，默认参数
        def addInt(a:Int, b:Int=2, c:Int=3) : Int = {
            var sum = 0
            sum = a+b+c
            println(a,b,c)
            return sum
        }
        println(addInt(1)) // 6

        // 匿名函数
        var mul = (x:Int, y:Int) => x*y
        println(mul(3,4))
        var userDir = () => {System.getProperty("user.dir")}
        println(userDir())

        // 偏应用函数是一种表达式，你不需要提供函数需要的所有参数
        // 只需要提供部分，或不提供所需参数
        import java.util.Date
        def log(date : Date, message : String) = {
            println(date + "-----" + message)
        }
        val date = new Date
        val logWithDateBound = log(date, _ : String)
        logWithDateBound("message1")
        Thread.sleep(1000)
        logWithDateBound("message2")
        Thread.sleep(1000)
        logWithDateBound("message3")

        // 闭包
        var factor = 3
        val multi = (i : Int) => i*factor
        println(multi(5)) // 15
        factor = 2
        println(multi(5)) // 10

        // 数组
        var z1 : Array[String] = new Array[String](3)
        var z2 = new Array[String](3) // 两种方式定义
        z1(0) = "michael"; z1(1) = "scala"; z1(2) = "!"
        for(z <- z1)
            println(z)

        var z3 = Array("hello","michael","!!!")
        for(z <- z3)
            println(z)

        // 求和，求最大
        var nums = Array(1.9, 2, -1, 0.1)
        var sum = 0.0; var maxv = -100000.0
        for(i <- 0 to (nums.length-1)){
            sum += nums(i)
            if(nums(i) > maxv)
                maxv = nums(i)
        }
        println(printf("sum: %f, maxv: %f",sum, maxv))
        // sum: 3.000000, maxv: 2.000000()

        // 多维数组
        import Array._
        val mat = Array.ofDim[Int](3,3)
        for(i <- 0 to 2; j <- 0 to 2)
            mat(i)(j) = i*3+j;
        for(i <- 0 to 2; j <- 0 to 2)
            print(mat(i)(j) + " ") // 0 1 2 3 4 5 6 7 8
        println()
        // 合并数组
        var nums2 = Array(1,2,3)
        var nums3 = Array(4,5,6,7)
        var allnums = concat(nums2, nums3)
        for(x <- allnums)
            print(x + " ") // 1 2 3 4 5 6 7
        println()
        var nums4 = range(5, 8)
        for(x <- nums4)
            print(x + " ") // 5 6 7
        println()
        var nums5 = range(5, 18, 2) // 左闭右开，间距 2
        for(x <- nums5)
            print(x + " ") // 5 7 9 11 13 15 17
        println()
    }
}