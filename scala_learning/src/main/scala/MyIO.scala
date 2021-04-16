object MyIO {
    import java.io._

    def main(args: Array[String]): Unit = {

        // 写入文件
        val writer = new PrintWriter(new File(("test.txt")))
        writer.write("scala hah\nhello michael") // 产生文件 test.txt (内容scala hah...)
        writer.close()

        // 从屏幕获取输入
        val input = scala.io.StdIn.readLine()
        println(input) // 讲输入的内容打印出来

        // 从文件读取
        import scala.io.Source
        Source.fromFile("test.txt").foreach{
            print
        }
        // scala hah
        // hello michael
    }
}
