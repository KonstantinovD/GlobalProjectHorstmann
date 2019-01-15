import java.util.Scanner;
import tasks.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfTask;
        String taskName = "tasks.Task";

        //reading number of tacks and executing it in case current tack exists
        while(true) {
            System.out.print("input number of the task to execute it: ");
            numberOfTask = scanner.nextInt();
            chooseClass(taskName + numberOfTask);

            //finish or continue?
            if(false == continueExecution(scanner)) { break; }
        }
    }

    //Takes name of class and executes main class method "run"
    private static void chooseClass(String className) {
        try {

            TasksMainMethod obj = (TasksMainMethod)Class.forName(className).getConstructors()[0].newInstance();
            obj.run();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Such tack doesn't exist");
        }
        catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    //User chooses to finish work or to continue execution
    private static boolean continueExecution(Scanner scanner) {
        System.out.print("Do you want to continue? (\"1\" yes/\"0\" no): ");
        int answer = scanner.nextInt();
        //for default, if inputted number isn't a zero, execution will be continued
        if(answer == 0) return false;
        return true;
    }
}