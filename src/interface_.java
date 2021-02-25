// 接口
// 数据成员全部是常量 final 初始化
// 所有方法全部是 abstract
interface Person3 {
    final String name = "Michael"; // 必须初始化，final 可省略
    int age = 18;
    String occupation = "工程师";
    public abstract void talk1(); // abstract 可省略
}
interface Worker1{
    String tool = "hammer";
}

// 类可以实现多个接口
class Student2 implements Person3, Worker1
{
    // 要实例化，必须覆写 talk
    public void talk1()
    {
        System.out.println("name: " + this.name + ", age: " + this.age
                        + ", occupation: " + this.occupation
                        + ", tool: " + this.tool);
    }
}

// 接口可以继承于多个接口 （类的继承只能继承1个父类）
interface AnotherInterface extends Person3, Worker1
{
    String state = "person3+worker1";
    public void talk2();//抽象方法
}

class Student3 implements AnotherInterface{
    // Student3 要实现 Person3, Worker1, AnotherInterface 3个接口
    public void talk1(){
        System.out.println("每个抽象方法要覆写,talk1()");
    }
    public void talk2(){
        System.out.println("每个抽象方法要覆写,talk2()");
    }
}
class test3
{
    public static void main(String[] args){
        Student2 s2 = new Student2();
        s2.talk1();

        Student3 s3 = new Student3();
        s3.talk1();
        s3.talk2();
    }
}