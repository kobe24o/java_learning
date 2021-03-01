import java.util.*;

class comparatorDemo implements Comparator {
    public int compare(Object o1, Object o2) {
        String a, b;
        a = (String) o1;
        b = (String) o2;
        return b.compareTo(a); // 从大到小排序
        // return a.compareTo(b); // 从小到大排序
    }
}


class test6{
    public static void main(String[] args){
        TreeSet ts = new TreeSet(new comparatorDemo());//传入比较器
        ts.add("C");
        ts.add("A");
        ts.add("D");
        Iterator it = ts.iterator();
        while(it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        } // D C A

        String a = "Aaaab", b = "A";
        System.out.println(a.compareTo(b));

        TreeMap tm = new TreeMap(new comparatorDemo());
        tm.put("Michael", 18);
        tm.put("Ming", 18);
        tm.put("ABC", 19);
        Set set = tm.entrySet();
        Iterator it1 = set.iterator();
        while(it1.hasNext()){
            Object o = it1.next();
            System.out.println(o);
        }
        // Ming=18
        // Michael=18
        // ABC=19
    }
}
