package tasks;


import tasks.UTILS.Pair;

import java.io.File;

public class Task42 implements TasksMainMethod{

    @Override
    public void run() {
        Pair<String> strP = new Pair<>("Hi","hello");
        Pair errorPair = strP;

        Integer gh = 12;

        errorPair.setFirst(gh);

        //no errors if this line of code and lower one exist
        errorPair.setFirst("Rename");

        //no errors without this line of code
        System.out.println(strP.getFirst());
    }



}
