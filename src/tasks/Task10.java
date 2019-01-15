package tasks;

// Horstmann 1, p 755
// Threads

public class Task10 implements TasksMainMethod {
    @Override
    public void run() {

        ThreadTest test = new ThreadTest();

        Thread t1, t2;
        Runnable r1 = () -> {
            test.longMethod();
        };
        t1 = new Thread(r1);

        Runnable r2 = () -> {
            test.shortMethod();;
        };
        t2 = new Thread(r2);

        t1.setPriority(5);
        t2.setPriority(5);

        t1.start();
        t2.start();
    }
}

class ThreadTest{
    public synchronized void longMethod(){
        System.out.println("long start");
        for(int i=0; i < 100; i++){
            double k = Math.sqrt(i);
            System.out.println(k);
        }
        System.out.println("long end");
    }
    public synchronized void shortMethod(){
        System.out.println("SHORT");
    }
}