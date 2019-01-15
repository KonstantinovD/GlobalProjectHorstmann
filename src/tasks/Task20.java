package tasks;

//Horstmann part 1 page 279
//Timer beep

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Task20 implements TasksMainMethod {
    @Override
    public void run() {
        ActionListener listener = new TimePrinter();

        Timer t = new Timer(5000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program7");
        System.exit(0);
    }

    class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is "+ new Date());
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
