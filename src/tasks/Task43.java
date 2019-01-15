package tasks;

import tasks.UTILS.Pair;

import java.time.LocalDate;
import java.util.ArrayList;

//page 402
//WILDCARDS
public class Task43 implements TasksMainMethod {
    @Override
    public void run() {
        Pair<?> pair = new Pair<String>("f", "g");

        //getFirst() may be assigned only to Object
        Object o = pair.getFirst();

        String s = (String)pair.getSecond();

        System.out.println((String)o + " " + s);
    }


}
