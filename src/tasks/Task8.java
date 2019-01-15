package tasks;

public class Task8 implements TasksMainMethod{

    private double var;

    @Override
    public void run() {
        System.out.println(sb);

        String str = "? Not!";

        sb.append(str);

        System.out.println(sb);

        System.out.println(var);
    }

    private final StringBuilder sb = new StringBuilder("empty");

}

