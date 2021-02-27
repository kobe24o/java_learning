class TestTryCatch {
    public static void main(String[] args){
        try {
            int arr[] = new int[5];
            arr[7] = 10;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组范围越界！");
            System.out.println("异常："+e);
        }
        finally {
            System.out.println("一定会执行finally语句块");
        }
        System.out.println("end!!!");

        int a = 5, b = 0;
        try{
            if(b == 0)
                throw new ArithmeticException("一个算术异常，除数0");
            else
                System.out.println(a+"/"+b+"="+ a/b);
        }
        catch(ArithmeticException e){
            System.out.println("抛出异常："+e);
        }

        TestTryCatch obj = new TestTryCatch();
        try{
            obj.add(4, 0);
        }
        catch (Exception e){
            System.out.println("必须处理异常："+e);
        }

        try{
            throw new MyException("自定义异常！");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    void add(int a, int b) throws Exception{
        int c = a/b;
        System.out.println(a+"/"+b+"="+c);
    }
}

class MyException extends Exception{
    public MyException(String msg){
        // 调用 Exception 类的构造方法，存入异常信息
        super(msg);
    }
}