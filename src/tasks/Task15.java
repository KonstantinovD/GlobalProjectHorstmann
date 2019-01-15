package tasks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task15 implements TasksMainMethod {

    private Lock semaphore = new ReentrantLock();
    private int counter;
    private Condition enoughStrings;

    public class MyRunnable1 implements Runnable{

        @Override
        public void run() {
            semaphore.lock();
            System.out.println("line 1.first");
            counter++;
            try {
                while(counter < 2)
                    enoughStrings.await();
                System.out.println("line 2.first");
                enoughStrings.signalAll();

            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            finally{
                semaphore.unlock();
            }
        }
    }

    public class MyRunnable2 implements Runnable{
        @Override
        public void run() {
            semaphore.lock();
            System.out.println("line 1.second");
            counter++;
            try {
                while(counter < 2)
                    enoughStrings.await();
                System.out.println("line 2.second");
                enoughStrings.signalAll();

            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            finally{
                semaphore.unlock();
            }
        }
    }


    @Override
    public void run() {
        enoughStrings = semaphore.newCondition();

        Thread t_1 = new Thread(new MyRunnable1());
        Thread t_2 = new Thread(new MyRunnable2());
        t_1.start();
        t_2.start();
    }
}
