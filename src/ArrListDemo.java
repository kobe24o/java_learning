import java.util.*;

class ArrListDemo {
    public static void main(String[] args){
        ArrayList al = new ArrayList();
        System.out.println("al 的初始大小：" + al.size());
        // al 的初始大小：0
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        al.add(1,"A2");
        System.out.println("al size: " + al.size());
        // al size: 7
        System.out.println("al 的内容：" + al);
        // al 的内容：[C, A2, A, E, B, D, F]

        al.remove("F");
        al.remove(2);
        System.out.println("al size: " + al.size());
        // al size: 5
        System.out.println("al 的内容：" + al);
        // al 的内容：[C, A2, E, B, D]

        ArrayList al1 = new ArrayList();
        al1.add(1);
        al1.add(2);
        al1.add(3);
        al1.add(4);
        System.out.println("al1 的内容：" + al1);
        // al1 的内容：[1, 2, 3, 4]
        Object o[] = al1.toArray();
        int sum = 0;
        for(int i = 0; i < o.length; ++i)
            sum += ((Integer)o[i]).intValue();
        System.out.println("sum: " + sum); // sum: 10

        LinkedList ll = new LinkedList();
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, 1);
        System.out.println(ll);
        // [A, 1, F, B, D, E, C, Z]
        ll.remove("F");
        ll.remove(2);
        System.out.println(ll);
        // [A, 1, D, E, C, Z]
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
        // [1, D, E, C]
        ll.set(2, "changed");
        System.out.println(ll);
        // [1, D, changed, C]

        HashSet hs = new HashSet();
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add(1);
        System.out.println(hs);
        // [A, 1, B, C] 无序

        TreeSet ts = new TreeSet();
        ts.add("C");
        ts.add("B");
        ts.add("D");
        ts.add("A");
        ts.add("Aa");
        System.out.println(ts);
        // [A, Aa, B, C, D] 有序

        System.out.println(al);
        // [C, A2, E, B, D]
        Iterator it = al.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.print(" "+ obj);
        } // 使用 iterator 遍历
        //  C A2 E B D
        System.out.println();

        ListIterator lit = al.listIterator();
        while(lit.hasNext()){
            Object obj = lit.next();
            lit.set(obj+"*");
        }
        System.out.println("打印修改后的内容：");
        it = al.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.print(" "+ obj);
        } // C* A2* E* B* D*
        System.out.println();

        System.out.println("逆序输出：");
        while(lit.hasPrevious()){
            Object obj = lit.previous();
            System.out.print(" "+ obj);
        } // D* B* E* A2* C*
        System.out.println();

        // HashMap
        HashMap hm = new HashMap();
        hm.put("Michael", 18);
        hm.put("Ming", 19);

        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }
        int age = ((Integer)hm.get("Michael")).intValue();
        hm.put("Michael", age+2);
        i = set.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }

        // TreeMap
        TreeMap tm = new TreeMap();
        tm.put(18, "Michael");
        tm.put(19, "Ming");
        tm.put(0, "Java");
        // values
        Collection col = tm.values();
        Iterator it1 = col.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        // keySet
        Collection col1 = tm.keySet();
        Iterator it2 = col1.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        // entrySet, K V 对
        Collection col2 = tm.entrySet();
        Iterator it3 = col2.iterator();
        while(it3.hasNext()){
            System.out.println(it3.next());
        }
    }
}
