package tasks;

import java.lang.reflect.Method;

public class Task19 implements TasksMainMethod{
    @Override
    public void run() {
        try {
            Method square = Task19.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);

            printTable(1, 10, 10, square);
            printTable(1, 10, 10, sqrt);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * Returns square of the number
     * @param x number
     * @return square of the number
     */
    public static double square(double x){
        return x*x;
    }

    /**
     * Prints x and y values of specified method as a table
     * @param from
     * @param to
     * @param n
     * @param f
     */
    public static void printTable(double from, double to, int n, Method f){
        //print method signature
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for(double x = from; x <= to; x+= dx){
            try{
                double y = (Double) f.invoke(null, x);
                //null because method is static
                System.out.printf("%10.4f | %10.4f%n", x, y);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
