import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

class FileDemo {
    public static void main(String[] args){
        File f = new File("file.txt");
        if(f.exists())
            f.delete();
        else{
            try{
                f.createNewFile();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("name获取文件名:"+f.getName());
        System.out.println("getPath()获取文件路径："+f.getPath());
        System.out.println("getAbsolutePath()绝对路径："+f.getAbsolutePath());
        System.out.println("getParent()父文件夹名："+f.getParent());
        System.out.println("exists()文件存在吗？"+f.exists());
        System.out.println("canWrite()文件可写吗？"+f.canWrite());
        System.out.println("canRead()文件可读吗？"+f.canRead());
        System.out.println("isDirectory()是否是目录？"+f.isDirectory());
        System.out.println("isFile()是否是文件？"+f.isFile());
        System.out.println("isAbsolute()是否是绝对路径名称？"+f.isAbsolute());
        System.out.println("lastModified()最后修改时间："+f.lastModified());
        System.out.println("length()文件长度-字节单位："+f.length());
    }
}


class Employee1{
    String name;
    int age;
    final static int LEN = 8;
    public Employee1(String name, int age){
        if(name.length() > LEN){
            name = name.substring(0,8);
        }
        else {
            while(name.length() < LEN)
                name = name + " ";
        }
        this.name = name;
        this.age = age;
    }
}
class RandomFileDemo{
    public static void main(String[] args) throws Exception{
        Employee1 e1 = new Employee1("Michael___",18);
        Employee1 e2 = new Employee1("Ming",19);
        Employee1 e3 = new Employee1("ABC",20);
        RandomAccessFile ra = new RandomAccessFile("employee.txt","rw");
        ra.write(e1.name.getBytes());
        ra.writeInt(e1.age);
        ra.write(e2.name.getBytes());
        ra.writeInt(e2.age);
        ra.write(e3.name.getBytes());
        ra.writeInt(e3.age);
        ra.close();

        RandomAccessFile raf = new RandomAccessFile("employee.txt","r");
        int len = 8;
        raf.skipBytes(12);//跳过第一个员工信息，名字8字节，年龄4字节
        System.out.println("第2个员工信息：");
        String str = "";
        for(int i = 0; i < len; ++i)
            str = str+(char)raf.readByte();
        System.out.println("name: "+str);
        System.out.println("age: "+raf.readInt());

        System.out.println("第1个员工的信息：");
        raf.seek(0);//移动到开始位置
        str = "";
        for(int i = 0; i < len; ++i)
            str = str+(char)raf.readByte();
        System.out.println("name: "+str.trim());
        System.out.println("age: "+raf.readInt());

        System.out.println("第3个员工的信息：");
        raf.skipBytes(12); // 跳过第二个员工信息
        str = "";
        for(int i = 0; i < len; ++i)
            str = str+(char)raf.readByte();
        System.out.println("name: "+str.trim());
        System.out.println("age: "+raf.readInt());
        raf.close();
    }
}