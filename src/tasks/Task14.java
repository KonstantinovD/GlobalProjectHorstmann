package tasks;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task14 implements TasksMainMethod{
    public static AtomicInteger count = new AtomicInteger(0);



    @Override
    public void run() {
        Thread t_1 = new Thread(new MyRunnable());
        Thread t_2 = new Thread(new MyRunnable());
        try {
            t_1.start();
            t_2.start();
            t_1.join();
            t_2.join();
        }catch(InterruptedException ex){
            System.out.println("Interrupt");
        }
        System.out.println(count);

    }

    public static void incrementCoint(){
        count.addAndGet(1);
    }

    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<100000; i++){
                incrementCoint();
                if(i == 50000){
                    System.out.println("half");
                }
            }
            System.out.println("end");
        }
    }

}
