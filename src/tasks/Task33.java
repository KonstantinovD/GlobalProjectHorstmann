package tasks;

import javax.swing.*;

//page 383
public class Task33 implements TasksMainMethod {
    @Override
    public void run() {
        String middle = ArrayAlg.getMiddle("He", "She", "It");
        System.out.println(middle);

        //interesting error, можно узнать какой тип выводит компилятор в этом случае
        //JButton btn =  ArrayAlg.getMiddle("Hello", 0, null);

    }


    static class ArrayAlg
    {
        public static <T> T getMiddle(T... a){
            return a[a.length / 2];
        }
    }

}
