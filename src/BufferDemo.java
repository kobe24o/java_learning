import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BufferDemo {
    public static void main(String[] args){
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while(true){
            System.out.println("请输入数字：");
            try{
                str = buf.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            int i = -1;
            try{
                i = Integer.parseInt(str);
                i++;
                System.out.println("+1 后的数字为：" + i);
                break;
            }
            catch(Exception e){
                System.out.println("输入内容不是整数，请重新输入！");
            }
        }
    }
}
