package tasks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task13 implements TasksMainMethod {
    @Override
    public void run() {
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}


// Класс Магазин, хранящий произведенные товары
class Store{
    private int product=0;
    private Lock locker;
    private Condition productState;

    public Store(){
        locker = new ReentrantLock();
        productState = locker.newCondition();
    }

    public void get() {
        locker.lock();
        try {
            while (product < 1) {
                productState.await();
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);

            productState.signalAll();

        }catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            locker.unlock();
        }
    }
    public synchronized void put() {
        while (product>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}
// класс Производитель
class Producer implements Runnable{

    Store store;
    Producer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
// Класс Потребитель
class Consumer implements Runnable{

    Store store;
    Consumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}