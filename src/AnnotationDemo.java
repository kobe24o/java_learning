import java.lang.annotation.Annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

class Person5 {
    public String say(){
        return "人在说话！";
    }
}

class Student5 extends Person5{
    @Override // 明确表示是覆写的函数，名称保持一致
    public String say() {
        return "学生在说话！";
    }

    @Deprecated // 不建议使用的操作，使用会出现警告
    public String getInfo(){
        return "hello";
    }
}

//自定义Annotation
@Documented
//@Inherited
//@Target(value=ElementType.METHOD) // 只能在方法上使用
@Target(value = {ElementType.METHOD, ElementType.TYPE}) // 多个选项
@Retention(value=RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    public String key() default "Michael";
    public String value() default "Ming";
    public EnumDemo.Color color() default EnumDemo.Color.RED;//限定参数范围
    public String[] url();
}


@MyAnnotation(color= EnumDemo.Color.BLUE, key="Michael", value="Ming",
        url={"https://michael.blog.csdn.net/","abc.xxx"})
class Info{
    @Override
    @Deprecated
    @SuppressWarnings(value = "")
    public String toString(){
        return "hello";
    }
}
class subclass1 extends Info{

}

public class AnnotationDemo{
    @SuppressWarnings("deprecated")//压制警告信息
    public static void main(String[] args){
        Student5 s = new Student5();
        System.out.println(s.say());
        System.out.println(s.getInfo());
        subclass1 ss = new subclass1();
    }
}