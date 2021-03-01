import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

class EnumDemo {
    public enum Color{
        RED, GREEN, BLUE
    }
    public static void main(String[] args){
        Color c = Color.RED;
        System.out.println(c);
        c = Color.GREEN;
        System.out.println(c);
        c = Color.BLUE;
        System.out.println(c);

        switch(c){
            case RED:{
                System.out.println("红色");
                break;
            }
            case GREEN:{
                System.out.println("绿色");
                break;
            }
            case BLUE:{
                System.out.println("蓝色");
                break;
            }
            default:{
                System.out.println("nothing");
            }
        }

        for(Color col : Color.values()) {
            System.out.println(col);
            System.out.println(col.name() + "--->" + col.ordinal());
        }

        // EnumMap
        EnumMap<Color, String> eMap = new EnumMap<Color, String>(Color.class);
        eMap.put(Color.RED, "红色");
        eMap.put(Color.GREEN, "绿色");
        eMap.put(Color.BLUE, "蓝色");
        for(Map.Entry<Color, String> me : eMap.entrySet()){
            System.out.println(me.getKey() + " : " + me.getValue());
        }

        // EnumSet
        EnumSet<Color> eSet = EnumSet.allOf(Color.class);//全部内容设置到集合
        Iterator<Color> iter = eSet.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}

//interface Info{
//    public String getColor();
//}
enum Color {
    RED{
        public String getColor(){
            return "红色";
        }
    },
    GREEN{
        public String getColor(){
            return "绿色";
        }
    },
    BLUE{
        public String getColor(){
            return "蓝色";
        }
    };
    public abstract String getColor();
}
class test8{
    public static void main(String[] args) {
        for(Color col : Color.values()) {
            System.out.println(col.name() + "--->" + col.ordinal() + " " + col.getColor());
        }
    }
}