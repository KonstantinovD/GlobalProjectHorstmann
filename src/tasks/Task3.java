package tasks;

public class Task3 implements TasksMainMethod {
    @Override
    public void run() {
        double x = 10000.0/3.0;
        System.out.println(x);
        System.out.printf("%2.2f", x);
        System.out.printf("%9.2f", x);//выведет дополнительно 2 начальных пробела,
        //т. к. имеем 3333.33 - ширина равна 7
        System.out.printf("%2.2f", x);
    }
}
