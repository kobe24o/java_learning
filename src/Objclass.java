class Person4 extends Object{ // extends Object 可省略
    private String name = "Michael";
    private int age = 18;
    public Person4()
    {
        System.out.println("无参构造方法");
    }
    public Person4(String name, int age)
    {
        this();
        this.name = name;
        this.age = age;
    }
    static{
        System.out.println("person4 类内静态代码块");
    }

    // 覆写父类 Object 的 equals
    public boolean equals(Object o)
    {
        boolean eq = true;
        Person4 p1 = this;
        if(o instanceof Person4)
        {
            Person4 p2 = (Person4) o;
            eq = (p1.name==p2.name && p1.age==p2.age);
        }
        else
            eq = false;
        return eq;
    }
}

//接口对象实例化
interface Usb{
    public void start();
    public void stop();
}

class MoveDisk implements Usb
{
    public void start(){
        System.out.println("MoveDisk start...");
    }
    public void stop(){
        System.out.println("MoveDisk stop...");
    }
}
class Mp3 implements Usb
{
    public void start(){
        System.out.println("Mp3 start...");
    }
    public void stop(){
        System.out.println("Mp3 stop...");
    }
}

class Computer{
    public void work(Usb u){
        u.start();
        u.stop();
    }
}

class test4{

    public static void main(String[] args)
    {
        Person4 p1 = new Person4("Michael", 18);
        Person4 p2 = new Person4("Michael", 18);
        System.out.println(p1.equals(p2) ? "eq" : "not eq");

        new Computer().work(new MoveDisk());
        new Computer().work(new Mp3());
    }
    static{
        System.out.println("main 之前的静态代码块");
    }
}
