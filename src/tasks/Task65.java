package tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task65 implements TasksMainMethod {


    @Override
    public void run() {
        JFrame f = new JFrame();
        f.setSize(400, 180);
        f.add(new CalculatorPanel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        //CalculatorPanel cp = new CalculatorPanel();
    }

}

class CalculatorPanel extends JPanel{
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;

    public CalculatorPanel(){
        setLayout(new BorderLayout());
        result = 0;
        lastCommand = "=";
        start = true;
        //displaying result area
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        //grid 4x4
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            if(start){
                start = false;
                display.setText("");
            }
            display.setText(display.getText() + input);
        }
    }

    private class CommandAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(start){
                if(command.equals("-"))//unary minus
                {
                    display.setText(command);
                    start = false;
                }
                else lastCommand = command;//change command
            }else{
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    /**
     * Waiting calculations
     * @param x
     */
    public void calculate(double x){
        switch(lastCommand){
            case "+": {
                result += x; break;
            }
            case "-": {
                result -= x; break;
            }
            case "*": {
                result *= x; break;
            }
            case "/": {
                result /= x; break;
            }
            case "=": {
                result = x; break;
            }
        }
        display.setText("" + result);
    }

}







