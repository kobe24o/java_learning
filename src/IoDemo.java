
import java.io.*;

class IoDemo {
    public static void main(String[] args){
        // 写文件
        File f = new File("file.txt");
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(f);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        byte b[] = "Hello Michael!".getBytes();
        try{
            out.write(b);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try{
            out.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // 读文件
        FileInputStream in = null;
        try{
            in = new FileInputStream(f);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        byte b1[] = new byte[1024];//开辟空间接收文件读入进来
        int i = 0;
        try{
            i = in.read(b1);//返回读入数据的个数
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try{
            in.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(new String(b,0,i));
    }
}

class CharDemo {
    public static void main(String[] args){
        // 写文件
        File f = new File("file.txt");
        FileWriter out = null;
        try{
            out = new FileWriter(f);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        String str= "Hello Michael!";
        try{
            out.write(str);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try{
            out.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // 读文件
        FileReader in = null;
        try{
            in = new FileReader(f);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        char c1[] = new char[1024];//开辟空间接收文件读入进来
        int i = 0;
        try{
            i = in.read(c1);//返回读入数据的个数
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try{
            in.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(new String(c1,0,i));
    }
}