package tasks;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task55 implements TasksMainMethod {
    @Override
    public void run() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(1, "first");
        map.put(2, "second");
        map.put(3, "third");
        map.put(4, "четыре");
        map.put(5, "пять");

        LinkedHashMap<Integer, String> mapAutoDeleting = new LinkedHashMap<>(16, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                if(size() <= 5) return false;
                Iterator<String> it = this.values().iterator();
                String sLast = null;
                while(it.hasNext()){
                    sLast = it.next();
                }
                if(sLast.startsWith("F")){
                    return false;
                }
                return true;
            }
        };
        mapAutoDeleting.put(1, "aa");
        mapAutoDeleting.put(2, "bb");
        mapAutoDeleting.put(3, "ccc");
        mapAutoDeleting.put(4, "d");
        mapAutoDeleting.put(5, "eeeeeee");


        map.forEach((k,v)->{
            System.out.println(v);
        });

        //sep
        System.out.println("---------");

        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();


        map.put(3, map.get(3).concat("MEW"));

        map.forEach((k,v)->{
            System.out.println(v);
        });

        //sep
        System.out.println("---------------");
        System.out.println("-auto deleting-");
        //sep
        System.out.println("---------------");

        mapAutoDeleting.forEach((k,v)->{
            System.out.println(v);
        });
        //sep
        System.out.println("---------------");

        mapAutoDeleting.put(17, "NO!"); //No смещает первый элемент - а

        mapAutoDeleting.forEach((k,v)->{
            System.out.println(v);
        });
        //sep
        System.out.println("---------------");

        mapAutoDeleting.put(44, "FRONT");//FRONT элементов не смещает, т к начинается c F

        mapAutoDeleting.forEach((k,v)->{
            System.out.println(v);
        });


    }
}
