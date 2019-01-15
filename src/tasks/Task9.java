package tasks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Scanner;
import java.util.*;

public class Task9 implements TasksMainMethod {
    @Override
    public void run() {
        final JFrame frame = new BounceFrame();

        EventQueue.invokeLater(() ->{
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
        });

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        BounceFrame fr = (BounceFrame)frame;
        System.out.println(fr.t.isInterrupted());

        try {
            fr.t.sleep(4000);
            fr.t.interrupt();
        }catch(InterruptedException ex){
            System.out.println("InterExcept");
        }




        System.out.println(Thread.currentThread().getName());
        a = scan.nextInt();
        Thread.currentThread().interrupt();

    }

}


//////////////////////////////////////////////////////////////////////
/**
 * Frame with ball component and buttons
 */
class BounceFrame extends JFrame{
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;
    public Thread t;

    /**
     * Creates frame with component which displays
     * bouncing ball, buttons <b>Start</b> and <b>Close</b>
     */
    public BounceFrame() {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Enters a button to the container
     * @param cont Container
     * @param title Button title
     * @param listener Button event handler
     */
    public void addButton(Container cont, String title, ActionListener listener) {
        JButton button = new JButton(title);
        cont.add(button);
        button.addActionListener(listener);
    }

    /**
     * Enters bouncing ball to the panel and makes it to bounce 1000 times
     */
    public void addBall() {
        Ball ball = new Ball();
        comp.add(ball);

        Runnable r = () -> {
            try{
                for(int i = 1; i <= STEPS; i++){
                    ball.move(comp.getBounds());
                    comp.repaint();
                    Thread.sleep(DELAY);
                }
            }catch(InterruptedException ex){}
        };
        t = new Thread(r);
        t.start();
    }
}


///////////////////////////////////////////////////////////////////////
class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    /**
     * Transfers ball to the next position, changing its
     * moving direction, when it has reached any
     * rectangle border
     */
    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    /**
     * Gets the ball shape at the current position
     */
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}


///////////////////////////////////////////////////////////////////////
/**
 * Component which draws bouncing ball
 */
class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    /**
     * Sets ball to the component
     * @param ball {@code Ball} to be set
     */
    public void add(Ball ball) {
        balls.add(ball);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for(Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    public Dimension getPrefferedSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}






