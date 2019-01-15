package tasks;

//Horstmann part 1 ASSERTIONS

import java.util.Scanner;

public class Task29 implements TasksMainMethod {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        int var = sc.nextInt();

        assert(var >= 0) : var;

        System.out.println("the var is: " + var);
    }
}
