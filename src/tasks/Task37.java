package tasks;

import java.util.ArrayList;
import java.util.Collection;
import tasks.Task34.Pair;

public class Task37 implements TasksMainMethod {
    @Override
    public void run() {
        Collection<Pair<String>> table = new ArrayList<>();
        Pair<String> p1 = new Pair<>("First", "word");
        Pair<String> p2 = new Pair<>("Second", "WORD");
        Pair<Integer> p3 = new Pair<>(12, 44);

        addAll(table, p1, p2);

        for(Pair p : table){
            System.out.println(p.first + " " + p.second);
        }
    }

    public static <T> void addAll(Collection<T> coll, T... ts)
    {
        for(T t : ts) coll.add(t);
    }
}
