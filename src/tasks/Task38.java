package tasks;

import tasks.Task34.Pair;

import java.util.function.Supplier;

public class Task38 implements TasksMainMethod {
    @Override
    public void run() {
        Pair<String> p = makePair(String::new);
        System.out.println(p.second);
        System.out.println(p.first);
    }

    public static <T> Pair<T> makePair(Supplier<T> constr){
        return new Pair<>(constr.get(), constr.get());
    }
}
