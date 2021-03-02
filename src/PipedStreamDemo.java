import java.io.*;

class Sender extends Thread{
    private PipedOutputStream out = new PipedOutputStream();
    public PipedOutputStream getOutputStream() {
        return out;
    }
    public void run(){
        String s = new String("hello, Michael!");
        try{
            out.write(s.getBytes());//写入，发送
            out.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

class Receiver extends Thread{
    private PipedInputStream in = new PipedInputStream();
    public PipedInputStream getInputStream(){
        return in;
    }
    public void run(){
        String s = null;
        byte buf[] = new byte[1024];
        try{
            int len = in.read(buf);
            s = new String(buf, 0, len);
            System.out.println("收到以下讯息："+s);
            in.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

class PipedStreamDemo {
    public static void main(String[] args){
        try{
            Sender sender = new Sender();
            Receiver receiver = new Receiver();
            PipedOutputStream out = sender.getOutputStream();
            PipedInputStream in = receiver.getInputStream();
            out.connect(in); // 将输出发送到输入
            sender.start();
            receiver.start();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}


class ByteArrayDemo{
    public static void main(String[] args) throws Exception{
        String tmp = "abcdefg**A";
        byte[] src = tmp.getBytes(); // src 为转换前的内存块
        ByteArrayInputStream input = new ByteArrayInputStream(src);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new ByteArrayDemo().transform(input, output);
        byte[] result = output.toByteArray(); // result为转换后的内存块
        System.out.println(new String(result));
        // ABCDEFG**A
    }
    public void transform(InputStream in, OutputStream out){
        int c = 0;
        try{
            while((c=in.read()) != -1)//没有读到流的结尾（-1）
            {
                int C = (int) Character.toUpperCase((char)c);
                out.write(C);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

class SystemPrintDemo{
    public static void main(String[] args){
        PrintWriter out = new PrintWriter(System.out);
        out.print("hello Michael");
        out.println("hello Michael");
        out.close();
    }
}

class FilePrint{
    public static void main(String[] args){
        PrintWriter out = null;
        File f = new File("file1.txt");
        try{
            out = new PrintWriter(new FileWriter(f));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        out.print("Hello Michael!!!");
        out.close();
    }
}

