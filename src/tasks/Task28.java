package tasks;

//Creating your own Exception class

import java.util.Scanner;

public class Task28 implements TasksMainMethod {
    @Override
    public void run() {
        try{
            Scanner sc = new Scanner(System.in);
            int val = sc.nextInt();

            int result = Factorial.getFactorial(val);
            System.out.println(result);
        }
        catch(FactorialException ex){

            //System.out.println(ex.getMessage());
            //System.out.println(ex.getNumber());
            ex.printStackTrace();
            try{
                Thread.sleep(1000);
            }catch (Exception e){}
            System.out.println("[");
            System.out.println(ex.getMessage());
            System.out.print("]");
        }
    }
}


class Factorial{

    public static int getFactorial(int num) throws FactorialException{

        int result=1;
        if(num<1) throw new FactorialException("The number is less than 1", num);

        for(int i=1; i<=num;i++){
            result*=i;
        }
        return result;
    }
}

class FactorialException extends Exception{
    private int number;
    public int getNumber(){return number;}
    public FactorialException(String message, int num){
        super(message);
        number=num;
    }
}