package testPackage1.java;
class testPg {
    public String talk(){
        return "talk()";
    }
}
class testAnother{
    public static void main(String[] args){
        System.out.println(new testPg().talk());
    }
}