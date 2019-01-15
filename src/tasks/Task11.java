package tasks;


public class Task11 implements TasksMainMethod {
    @Override
    public void run() {

        Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread th, Throwable ex) {
                System.out.println("" +
                        ": " + ex);
            }
        };
        Thread t = new Thread() {
            public void run() {
                System.out.println("Sleeping ...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted.");
                }
                System.out.println("Throwing exception ...");
                throw new RuntimeException();

            }
        };
        t.setUncaughtExceptionHandler(h);
        t.start();
    }
}
