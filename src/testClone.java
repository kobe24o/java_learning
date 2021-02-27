class Employee implements Cloneable {
    private String name;
    private int age;
    public Employee(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public String toString(){
        return "name: "+this.name+" age: "+this.age;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

class test5{
    public static void main(String[] args){
        Employee e1 = new Employee("Michael", 18);
        Employee e2 = null;
        try{
            e2 = (Employee) e1.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        e2.setName("Ming");
        e2.setAge(19);
        System.out.println("两个对象的地址比较："+(e1 == e2));
        System.out.println(e1);
        System.out.println(e2);
    }
}
