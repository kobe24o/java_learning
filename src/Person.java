class Person {
    String name;
    int age;
    public Person(){}//构造函数，与类同名，没有返回值
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    String talk()
    {
        return "i am " + name + ", age " + age;
    }
    boolean equals(Person a){
        return this.name == a.name && this.age == a.age;
    }
}

class test
{
    public static void main(String[] args)
    {
        Person p1 = new Person();//创建对象p1
        p1.name = "Michael";
        p1.age = 18;
        p1.talk();// i am Michael, age 18

        Person p2 = new Person();//创建对象p2
        p2.name = "Michael";
        p2.age = 18;

        // == 比较内存地址
        if(p1 == p2)
            System.out.println("p1 == p2");
        else
            System.out.println("p1 != p2, 比较的是地址");
        // equals() 比较内容
        if(p1.equals(p2))
            System.out.println("p1, p2 内容一样");

        // 对象的数组
        Person[] p = {new Person("Michael", 18),
                        new Person("Michael",19),
                        new Person()};//静态初始化
        for(int i = 0; i < p.length; i++)
            System.out.println(p[i].talk());

        Person pp [] = new Person[3];
        for(int i = 0; i < pp.length; ++i)
            pp[i] = new Person();//动态初始化
    }
}