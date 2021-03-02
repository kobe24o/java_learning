import java.io.*;

class SequenceDemo {
    public static void main(String[] args) throws IOException {
        // 两个文件输入流
        FileInputStream in1 = null, in2 = null;
        // 序列流
        SequenceInputStream s = null;
        FileOutputStream out = null;
        try{
            File inputfile1 = new File("1.txt");
            File inputfile2 = new File("2.txt");
            FileWriter wt = new FileWriter(inputfile1);
            wt.write("the first file.\nhaha! \n");
            wt.close();
            wt = new FileWriter(inputfile2);
            wt.write("the second file..");
            wt.close();

            File outputfile = new File("12.txt");

            in1 = new FileInputStream(inputfile1);
            in2 = new FileInputStream(inputfile2);

            s = new SequenceInputStream(in1, in2);
            out = new FileOutputStream(outputfile);

            int c;
            while((c=s.read()) != -1)
                out.write(c);

            in1.close();
            in2.close();
            s.close();
            out.close();
            System.out.println("合并完成！");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
