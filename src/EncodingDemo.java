import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class EncodingDemo {
    public static void main(String[] args){
        try {
            byte[] b = "一起来学习Java吧！".getBytes("GB2312");
            OutputStream out = new FileOutputStream(new File("encode.txt"));
            out.write(b);
            out.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.getProperties().list(System.out);
    }
}
