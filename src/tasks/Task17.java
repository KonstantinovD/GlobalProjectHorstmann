package tasks;
//Horstmann part 1 page 252 (Reflection)

import tasks.task17.ObjectAnalyzer;

import java.util.ArrayList;

public class Task17 implements TasksMainMethod {
    @Override
    public void run() {

        ArrayList<Integer> squares = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
