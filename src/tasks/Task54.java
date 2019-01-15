package tasks;

import java.util.WeakHashMap;

public class Task54 implements TasksMainMethod{
    @Override
    public void run() {
        WeakHashMap<Integer, String> whm = new WeakHashMap<>();

        int first = 10;
        int second = 20;

        whm.put(first, "first");
        whm.put(second, "second");

        {
            int temp = 33;
            whm.put(123, "third");
            whm.put(temp, "fourth");

        }


        whm.forEach((k, v)->{
            System.out.println(k + ": " + v);
        });

        //sep
        System.out.println("---------");

        for(int i=0; i<10; i++) {
            try {
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            whm.forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });
            //sep
            System.out.println("---------");
        }


    }
}
