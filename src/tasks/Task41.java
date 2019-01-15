package tasks;
//page 397-398
import java.io.File;
import java.util.Scanner;

public class Task41 implements TasksMainMethod {
    @Override
    public void run() {
        new Block(){
            @Override
            public void body() throws Exception {
                Scanner in = new Scanner(new File("ququx"));
                System.out.println(in.next());

                System.out.println("Hi!(x3)");
            }
        }
        .toThread().start();

        System.out.println("Hi!");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("Hi!(x2)");
    }
}

abstract class Block{
    public abstract void body() throws Exception;

    public Thread toThread(){
        return new Thread(){
            @Override
            public void run() {
                try{
                    body();
                }
                catch(Throwable t){
                    Task40.throwAs(t);
                }
            }
        };
    }
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void
    throwAs(Throwable e) throws T{
        throw (T) e;
    }
}

