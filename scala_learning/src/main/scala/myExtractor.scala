object myExtractor {
    //提取器使用模式匹配
    def main(args : Array[String]) = {
        val x = myExtractor(5) // 自动调用apply
        println(x) // 10

        x match{ // 在提取器对象中使用 match 语句是，unapply 将自动执行
            case myExtractor(num) => println(x, num) // 自动调用 unapply (10,5)
            case _ => println("无法计算")
        }
    }
    def apply(x : Int) = {
        x*2
    }
    def unapply(z : Int) = {
        if(z%2 == 0)
            Some(z/2)
        else
            None
    }
}
