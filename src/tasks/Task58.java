package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task58 implements TasksMainMethod {


    @Override
    public void run() {
        List<String> names = Arrays.asList("Amy", "Bob", "Carl");//effective using of resources

        List<Integer> single = Collections.singletonList(25);


        List<String> sentence = new ArrayList<>();
        Collections.addAll(sentence, "hello", "how", "are", "you", "i", "am", "fine", "and", "you");

        List<String> sentencePart = sentence.subList(4, 7);
        for(String s : sentencePart) System.out.print(s + " ");
        System.out.println();
        sentencePart.clear(); //operation is made over the sentence elements

        for(String s : sentence) System.out.print(s + " ");
        System.out.println();


    }


}
