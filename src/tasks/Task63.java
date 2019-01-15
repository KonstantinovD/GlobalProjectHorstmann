package tasks;

import java.util.Scanner;

public class Task63 implements TasksMainMethod {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

          double value = Double.parseDouble("0,4");


        double x = sc.nextDouble();
        double error = sc.nextDouble();

        System.out.println(countSum(x, error));
    }

    private double countSum(double x, double error){
        double sum = 0;

        double powerPart = (double)x/3; //to reduce division
        double currentX = powerPart;//first member of power part progression

        int k = 0;
        double member = 0;
        do{
            sum += member * (k%2 == 0 ? 1 : -1);
            k++;
            member =  (k+1) * currentX;
            currentX *= powerPart;
        }while(member >= error);


        try {
            throw new MyException("Exception: Wrong number of arguments!");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return sum;

    }
}

class MyException extends Exception {
    public MyException() { super(); }
    public MyException(String message) { super(message); }
    public MyException(String message, Throwable cause) { super(message, cause); }
    public MyException(Throwable cause) { super(cause); }

    @Override
    public void printStackTrace() {
        System.err.println(this.getMessage());
    }
}
