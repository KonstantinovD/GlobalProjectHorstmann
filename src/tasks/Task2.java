package tasks;

import java.io.Console;

public class Task2 implements TasksMainMethod {
    @Override
    public void run() {
        Console cons = null;
        cons = System.console();
        String username = cons.readLine();
        System.out.println(username);
    }
}
