package tasks;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Task48 implements TasksMainMethod{
    @Override
    public void run() {

        List<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");

        ListIterator<String> iter_1 = list.listIterator();
        ListIterator<String> iter_2 = list.listIterator();

        iter_1.next();


        //changing N1
        list.add("third");

        for(String s : list){
            System.out.println(s);
        }


        //changing N2 - BUT even iter_1 don't work if "changing N1" is done
        iter_1.remove();
        iter_2.next();
        //OR
        /*
        try {
            iter_2.next();
        }catch(Exception ex){
            System.out.println("ERROR");
        }*/
    }
}


