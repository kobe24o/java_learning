public class HelloWorld { // HelloWorld 需要和文件名一致，因为 public
    // 一个文件最多一个 public 类
    // 如果该文件没有 public 类，则文件名随意取
    public static void main(String[] args) {
        float i =  10.2f;
        i++;//浮点数可以 ++
        System.out.println(i);//追加换行 print + line

        String $var$name$ = "变量名可以有$";
        System.out.println($var$name$);

        String greet = "hello Michael!";
        System.out.print("我写的第一个Java程序：" + greet);//不换行

        /*
         * 多行注释
         */

        /**
         * 程序文档注释，可以用工具生成文档
         */
    }
}