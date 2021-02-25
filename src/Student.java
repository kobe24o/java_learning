// 封装、继承、多态
class Person1{
    String name;
    int age;
    private int height;// 私有 封装
    public Person1(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public void talk()
    {
        System.out.println("This is father class talk() !");
    }
    public void setHeight(int h)
    {
        if(h > 0)
            this.height = h;
    }
    public int getHeight()
    {
        return this.height;
    }
}
class Student extends Person1{ // java 一个子类只能有一个父类
    String school;
    public Student(String name, int age, String school)
    {
        super(name,age);//调用父类的构造方法,且必须放在第一行
        this.school = school;

        // super. 调用父类属性、方法
        super.name = "Ming";
        super.age = 19;

        // 私有属性不可修改
        // super.height = 178;
        super.setHeight(178);
    }

    @Override
    public void talk() { // 重写父类方法
        System.out.println("This is sub class talk() !");
        super.talk();//还可以调用父类被覆写的方法
    }
}

class test1{
    public static void main(String[] args){
        Student s1 = new Student("Michael",18,"BJTU");
        System.out.println("name: "+s1.name+", age: "+s1.age+
                ", school: "+s1.school + ", height: " + s1.getHeight());

        s1.talk();

        Person1 p = new Student("Ming",19,"BJTU");
        p.talk();// 多态，父类对象通过子类实例化，调用的是子类的talk

        Student s2 = (Student) p;//向下类型转换，需要强制，向上是自动转的
        s2.talk();// 如果 p 是由 Person1 new 出来的，此处报错
    }
}
