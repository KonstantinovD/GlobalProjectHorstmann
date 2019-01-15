package tasks;

import java.util.Scanner;

public class Task64 implements TasksMainMethod {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(transformStr(input));
    }

    public String transformStr(String str){
        StringBuilder sb = new StringBuilder(str);

        if(str.isEmpty()) return str;

        int numberOfDuplicates = 0;
        int index = 0;
        char previous = (char)((int)(sb.charAt(0)) + 1);//should be different from the first character

        while(index < sb.length()) {
            char current = sb.charAt(index);
            if (current == previous) {
                numberOfDuplicates++;
                sb.deleteCharAt(index);
                continue;
            }else {
                if (numberOfDuplicates > 0) {
                    sb.insert(index, numberOfDuplicates);
                    index++;
                }
                previous = current;
                numberOfDuplicates = 1;
            }
            index++;
        }
        sb.append(numberOfDuplicates);

        return sb.toString();
    }

}
