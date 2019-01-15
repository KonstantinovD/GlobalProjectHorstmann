package tasks;
import java.lang.Math.*;
import static java.lang.Math.*;

public class Task1 implements  TasksMainMethod {
    @Override
    public void run() {

        double inf = 1.0/0.0;
        System.out.println(inf);

        inf = -1.0F/0.0F;
        System.out.println(inf);

        inf = 24.8/0.0;
        System.out.println(inf);

        System.out.println(Double.isInfinite(inf));

        System.out.println("pop\u005btyy"); // \u005B = [

        System.out.println((-15%(-4)));
        System.out.println(floorMod(-15, -4));



    }

}
