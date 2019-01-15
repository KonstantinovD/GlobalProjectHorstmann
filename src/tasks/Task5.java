package tasks;

import java.util.Scanner;

public class Task5 implements TasksMainMethod {
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("First");
            case 2:
                System.out.println("Second");
            case 3:
                System.out.println("Third");
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }
}
