package testPackage.java;
class testPackage {
    public String talk(){
        return "talk()";
    }
}
class testAnother{
    public static void main(String[] args){
        System.out.println(new testPackage().talk());
    }
}
