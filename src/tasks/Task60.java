package tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task60 implements TasksMainMethod {
    @Override
    public void run() {
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i <= 49; i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);

        Collections.sort(winningCombination, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o1%10 - o2%10;
            }
        }.reversed());
        System.out.println(winningCombination);
    }
}
