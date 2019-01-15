package tasks;


import java.util.HashMap;
import java.util.Map;

public class Task53 implements TasksMainMethod {
    @Override
    public void run() {
        Map<String, String> staff = new HashMap<>();
        staff.put("144-25", "Amy Lee");
        staff.put("567-24", "Harry Hacker");
        staff.put("157-62", "Gary Cooper");
        staff.put("456-62", "Francesca Cruz");

        System.out.println(staff);
        //sep
        System.out.println("---------");

        staff.remove("157-62");
        staff.remove("333"); //does nothing

        staff.put("456-62", "Tom Mann");
        System.out.print("find elem:  ");

        System.out.println(staff.get("567-24"));//find value
        //sep
        System.out.println("---------");

        for(Map.Entry<String, String> entry: staff.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }





    }
}
