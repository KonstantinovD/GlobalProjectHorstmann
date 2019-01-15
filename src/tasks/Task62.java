package tasks;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Task62 implements TasksMainMethod {
    @Override
    public void run() {
        JFrame f = new MainClass();
        f.setSize(400, 180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}



class MainClass extends JFrame {


    private int currentNumber = 0;

    private JLabel numberLabel = new JLabel();

    private Action upAction = new UpperBtnAction();

    private Action downAction = new DownBtnAction();

    public class UpperBtnAction extends AbstractAction {
        public UpperBtnAction() {
            putValue(NAME, "Increment");
            putValue(SMALL_ICON, new ImageIcon("images/up.gif"));
            putValue(SHORT_DESCRIPTION, "Increment the number");
            putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_A));
        }

        public void actionPerformed(ActionEvent ae) {
            currentNumber++;
            if(currentNumber > 9){
                setEnabled(false);
                downAction.setEnabled(true);
            }
            updateLabel();
        }
    }

    public class DownBtnAction extends AbstractAction {
        public DownBtnAction() {
            putValue(NAME, "Reset");
            putValue(SMALL_ICON, new ImageIcon("images/down.gif"));
            putValue(SHORT_DESCRIPTION, "Reset number to 0");
            putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_D));
        }

        public void actionPerformed(ActionEvent ae) {
            currentNumber = 0;
            setEnabled(false);
            upAction.setEnabled(true);
            updateLabel();
        }
    }


    public MainClass() {
        super();

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 16, 6));

        buttonPanel.add(numberLabel);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(6, 16, 16, 16));
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.add(new JButton(upAction));
        buttonPanel.add(new JButton(downAction));


        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Number");
        menu.add(new JMenuItem(upAction));
        menu.add(new JMenuItem(downAction));
        mb.add(menu);
        setJMenuBar(mb);

        updateLabel();
    }

    void updateLabel(){
        numberLabel.setText("Now tuned to number: " + currentNumber);
    }

}