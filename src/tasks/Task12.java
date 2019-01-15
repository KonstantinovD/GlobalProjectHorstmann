package tasks;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task12 implements TasksMainMethod {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    @Override
    public void run() {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for(int i=0; i< NACCOUNTS; i++){
            int fromAccount = i;
            Runnable r = () -> {
                try{
                    while(true){
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                }catch (InterruptedException ex){}
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class Bank{
    private Lock bankLock = new ReentrantLock(); //Object of lock class
    private final double[] accounts;

    /**
     * Constructs Bank object
     * @param n number of accounts
     * @param initialBalance initial balance on every account
     */
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another
     * @param from Account money transferred from
     * @param to Account money transferred to
     * @param amount Sum of money
     */
    public void transfer(int from, int to, double amount){
        synchronized (this) {
            if (accounts[from] < amount) {
                System.out.println("no available");
                return;
            }
        }
        bankLock.lock();
        try {
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }finally{
            bankLock.unlock();
        }
    }

    /**
     * Gets sum of balances on all accounts
     * @return Returns the total balance
     */
    public double getTotalBalance(){
        double sum = 0;

        for(double a : accounts){
            sum += a;
        }
        return sum;
    }

    /**
     * Gets the number of accounts
     * @return Returns the number of accounts
     */
    public int size(){
        return accounts.length;
    }
}





