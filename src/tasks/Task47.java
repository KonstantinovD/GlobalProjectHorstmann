package tasks;


import java.util.ArrayList;
import java.util.Iterator;

public class Task47 implements TasksMainMethod {
    @Override
    public void run() {

        ArrayList<String> al = new ArrayList<>();

        System.out.println(al.add("good"));
        System.out.println(al.add("bad"));
        System.out.println(al.add("good"));
        System.out.println(al.add("good"));

        String duplicate = "duplicate";

        System.out.println(al.add(duplicate));
        System.out.println(al.add(duplicate));

        Iterator<String> it = al.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println();
        System.out.println("subList:");

        al.subList(3, 5).removeIf(s -> {return s.startsWith("g");});

        it = al.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
