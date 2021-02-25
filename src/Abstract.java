abstract class Person2 { // 抽象类
    String name;
    int age;
    String occupation;
    public abstract void talk();
    public Person2(String name, int age, String occupation)
    {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }
}

class Student1 extends Person2
{
    public Student1(String name, int age, String occupation)
    {
        // 必须明确调用 抽象类的构造方法
        super(name, age, occupation);
    }

    // 要实例化， 必须 覆写 抽象方法 talk
    public void talk()
    {
        System.out.println("覆写talk()");
    }
}

class test2{
    public static void main(String[] args)
    {
        Student1 s = new Student1("Ming", 18, "student");
        s.talk();
    }
}