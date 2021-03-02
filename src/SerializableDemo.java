import java.io.*;

class Person6 implements Serializable{ // 实现了Serializable,可序列化
    private transient String name;
    private transient int age;
    public Person6(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "name: " + name + ", age: " + age;
    }
}

public class SerializableDemo {
    public static void serialize(File f) throws Exception{
        OutputStream outputFile = new FileOutputStream(f);
        ObjectOutputStream cout = new ObjectOutputStream(outputFile);
        cout.writeObject(new Person6("Michael", 18));
        cout.close();
    }
    public static void deserialize(File f) throws Exception{
        InputStream inputFile = new FileInputStream(f);
        ObjectInputStream cin = new ObjectInputStream(inputFile);
        Person6 p = (Person6) cin.readObject();
        System.out.println(p);
        // name: Michael, age: 18
    }
    public static void main(String[] args) throws Exception{
        File f = new File("SerializedPersonInfo.txt");
        serialize(f);
        deserialize(f);
    }
}
