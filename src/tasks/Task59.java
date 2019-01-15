package tasks;

import java.util.Collections;
import java.util.List;

public class Task59 implements TasksMainMethod {

    @Override
    public void run() {
        List<String> str = this.getList();

        str.add("Peter"); //Exception
    }

    List<String> names;

    List<String> getList(){
        Collections.addAll(names, "Anna", "Pyotr", "Maxim", "Leonid", "Vasiliy");
        return Collections.unmodifiableList(names);

        //Collections.unmodifiableCollection();
    }
}
