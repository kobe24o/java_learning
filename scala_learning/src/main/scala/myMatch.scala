object myMatch {
    def main(args: Array[String]) ={
        println(matchTest(3)) // many
        println(matchTest(2)) // two
        println(matchTest(1)) // one

        println(matchTest1("two")) // 2
        println(matchTest1("test")) // others
        println(matchTest1(1)) // one
        println(matchTest1(6)) // isInt, 顺序遇到符合的就退出，剩余的不匹配

        val alice = new Person("alice", 18)
        val bob = new Person("bob", 19)
        val michael = new Person("michael", 20)
        for(p <- List(alice, bob, michael)){
            p match {
                case Person("alice", 18) => println("hi, alice")
                case Person("bob", 19) => println("hi, bob")
                case Person(name, age) => println(name + " " + age)
            }
        }
        // hi, alice
        // hi, bob
        // michael 20

        // 正则表达式
        import scala.util.matching.Regex
        val pat1 = "Scala".r
        val s = "Scala is scalable and cool"
        println(pat1 findFirstIn s) // Some(Scala)
        val pat2 = new Regex("(S|s)cala") // 首字母 S or s
        println((pat2 findAllIn s).mkString(" - ")) //使用分隔符连接所有匹配
        // Scala - scala
        println(pat2 replaceFirstIn(s, "Java"))
        // Java is scalable and cool
        println(pat2 replaceAllIn(s, "Java"))
        // Java is Javable and cool

        // 异常处理
        import java.io.FileReader
        import java.io.FileNotFoundException
        import java.io.IOException
        try{
            val f = new FileReader("input.txt")
        }
        catch {
            case e : FileNotFoundException => {
                println("missing file!")
            }
            case e : IOException => {
                println("IO Exception")
            } // 一般把具体的异常写在前面，否则捕获了一个普遍的异常，后面的具体异常没有捕获
        }
        // missing file!
        finally { // 都会执行的部分
            println("finally step")
        } // finally step

        // 提取器是一个带有unapply方法的对象
        def apply(user : String, domain : String) = {
            user + "@" + domain
        }
        def unapply(email : String) : Option[(String, String)] = {
            val parts = email split "@"
            if(parts.length == 2)
                Some(parts(0), parts(1))
            else
                None
        }
        println(apply("michael", "csdn.net")) // michael@csdn.net
        println(unapply("michael@csdn.net")) // Some((michael,csdn.net))
        println(unapply("michael csdn")) // None

    }
    def matchTest(x : Int) : String = x match {
        case 1 => "one"
        case 2 => "two"
        case _ => "many" // 类似 default
    }
    def matchTest1(x : Any) : Any = x match {
        case 1 => "one"
        case "two" => 2
        case y : Int => "isInt" // 是不是 Int 类型
        case _ => "others"
    }

    // 样例类
    case class Person(name : String, age : Int)
}
