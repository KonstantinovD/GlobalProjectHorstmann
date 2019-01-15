package tasks;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
public class Task57 implements TasksMainMethod{
    @Override
    public void run() {
        IdentityHashMap identityHashMap = new IdentityHashMap<>();

        Integer value = Integer.valueOf(2);

        identityHashMap.put(2, "brend");
        identityHashMap.put(value, 134);

        System.out.println(identityHashMap.get(2));
        System.out.println(identityHashMap.get(value));
    }
}


