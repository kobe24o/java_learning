import name1.java.*;
import name1.java.Myhome;
//import name2.java.Myhome; // 同名不能让你一起导入

import javax.swing.*;
class testImport {
    public static void main(String[] args){
        Myhome home1 = new Myhome();
        home1.print();

        name2.java.Myhome home2 = new name2.java.Myhome();
        home2.print();
    }
}
