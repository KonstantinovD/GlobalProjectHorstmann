package tasks;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Task22 implements TasksMainMethod {
    @Override
    public void run() {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Stop beep");
        clock.setBeep(false);
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals
 */
class TalkingClock
{
    private int interval;
    private boolean beep;

    /**
     * Construct a talking clock
     * @param interval the interval between messages (in ms)
     * @param beep true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock
     */
    public void start(){
        int frog = 12;


        class TimePrinter implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
                if(frog == 12){
                    System.out.println("NoChanges");
                }
            }
        }

        //frog = 45;

        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();


    }

    public void setBeep(boolean beep){
        this.beep = beep;
    }

    /*
    public class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }*/
}

