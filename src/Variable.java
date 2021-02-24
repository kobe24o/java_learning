public class Variable {
    static final int YEAR = 365;
    // 常量使用 final 修饰, 不可修改，类似C++的 const

    static int day = 0;
    // 成员变量

    public static void main(String[] args)
    {
        System.out.println("2年有：" + 2*YEAR + "天");
        for(int i = 0; i < 3; ++i)
        {
            System.out.println(++day);
        }

        byte a1 = Byte.MAX_VALUE, a2 = Byte.MIN_VALUE;
        System.out.println(a1 + " " + a2);// 127 -128

        short b1 = Short.MAX_VALUE, b2 = Short.MIN_VALUE;
        System.out.println(b1 + " " + b2);// 32767 -32768

        int c1 = Integer.MAX_VALUE, c2 = Integer.MIN_VALUE;
        System.out.println(c1 + " " + c2); // 2147483647 -2147483648

        long d1 = Long.MAX_VALUE, d2 = Long.MIN_VALUE;
        System.out.println(d1 + " " + d2);
        // 9223372036854775807 -9223372036854775808

        float num = 3.0e2F;// 或者 3.0f
        System.out.println(num*num);// 9.0

        double num2 = 5.2e52D;
        double num3 = 1.1E51;
        System.out.println(num2+num3);// 5.31E52

        char ch1 = 97;
        char ch2 = 'a';
        System.out.println(ch1);// a
        System.out.println(ch2);// a

        boolean flag = false;
        if(flag)
            System.out.println("flag is " + flag);
        else
            System.out.println("flag is " + flag);

        int x = 100;
        double y = 3.0;
        System.out.println(x/y);// 33.333333333333336
        // 类型转换

        int z = 3;
        System.out.println(x/z); // 33
        System.out.println((float)x/z);// 33.333332
        System.out.println(x/(float)z);// 33.333332
        System.out.println((float)x/(float)z);// 33.333332

        int A = (int)1e301;
        System.out.println(A);// 2147483647
    }
}