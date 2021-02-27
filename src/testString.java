import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class testString {
    public static void main(String [] args)
    {
        String s = "Michael";
        s += ", ok";
        System.out.println(s);
        StringBuffer x = new StringBuffer("Ming");
        x.append("ming").append(", good!");
        System.out.println(x.toString());
        // 频繁修改字符串，使用 StringBuffer 性能更好

        String s1 = "10";
        int n = Integer.parseInt(s1,16);// x 进制
        System.out.println(++n);

        // System 类, 如打印系统信息
        Properties sp = System.getProperties();
        Enumeration e = sp.propertyNames();
        while(e.hasMoreElements()) {
            String key = (String) e.nextElement();
            System.out.println(key + " = " + sp.getProperty(key));
        }
//        System.exit(-1);
        Runtime run = Runtime.getRuntime();
        try{
            run.exec("notepad.exe");
        }
        catch (Exception ep){
            ep.printStackTrace();
        }

        // 时间类
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1.get(c1.YEAR)+"年"+(c1.get(c1.MONTH)+1)+"月"+
                c1.get(c1.DAY_OF_MONTH)+"日"+c1.get(c1.HOUR_OF_DAY)+":"+
                c1.get(c1.MINUTE)+":"+c1.get(c1.SECOND));

        c1.add(c1.DAY_OF_MONTH, 3);
        System.out.println(c1.get(c1.YEAR)+"年"+(c1.get(c1.MONTH)+1)+"月"+
                c1.get(c1.DAY_OF_MONTH)+"日"+c1.get(c1.HOUR_OF_DAY)+":"+
                c1.get(c1.MINUTE)+":"+c1.get(c1.SECOND));

        SimpleDateFormat sp1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy年MM月dd日 hh点mm分ss秒");
        try{
            Date d = sp1.parse("2021-2-26 23:02:03");
            System.out.println(sp2.format(d));
        }
        catch (ParseException e2){
            e2.printStackTrace();
        }

        // random
        Random r = new Random();
        for(int i = 0; i < 5; ++i)
            System.out.print(r.nextInt(100)+"\t");
    }
}
