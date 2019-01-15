package tasks;

import java.util.Date;

public class Task4 implements TasksMainMethod {
    @Override
    public void run() {
        System.out.printf("%1$s %2$te %2$tb", "Due date:", new Date());
    }
}
