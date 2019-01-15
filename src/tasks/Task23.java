package tasks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Task23 implements TasksMainMethod {
    @Override
    public void run() {
        Employee empl_1 = new Employee("InnerLocal", 750){
            public String toString(){
                return "Employee inner local object";
            }
        };

        Employee empl_2 = new Employee("Normal Man", 630);

        System.out.println(empl_1.toString());
        System.out.println(empl_2.toString());

        System.out.println( empl_1.getClass() == empl_2.getClass());

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = 0;
            }
        };
        System.out.println(al.getClass());
        System.out.println(empl_1.getClass());
        System.out.println(empl_2.getClass());

    }
}
