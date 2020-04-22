import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
    // CREATE A SWING GUI
    // Set width and height of calculator gui
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;
    // Panels
    private JPanel top;
    private JPanel buttons;
    private JTextField input;
    private JTextField output;

    // Build the gui
    public Calculator() {
        super("Tom's Java Calculator");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add input and output text boxes to the top of the calculator
        top = new JPanel();
        top.setLayout(new GridLayout(1,2));
        input = new JTextField("Input: 0",1);
        input.setEditable(false);
        top.add(input);
        output = new JTextField("Output: 0", 1);
        output.setEditable(false);
        top.add(output);

        add(top, BorderLayout.NORTH);

        // Add buttons to the center of the calculator
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(5,4));

        JButton one = new JButton("1");
        one.addActionListener(new numberListener());
        buttons.add(one);

        JButton two = new JButton("2");
        two.addActionListener(new numberListener());
        buttons.add(two);

        JButton three = new JButton("3");
        three.addActionListener(new numberListener());
        buttons.add(three);

        JButton plus = new JButton("+");
        plus.addActionListener(new operandListener());
        buttons.add(plus);

        JButton four = new JButton("4");
        four.addActionListener(new numberListener());
        buttons.add(four);

        JButton five = new JButton("5");
        five.addActionListener(new numberListener());
        buttons.add(five);

        JButton six = new JButton("6");
        six.addActionListener(new numberListener());
        buttons.add(six);

        JButton minus = new JButton("-");
        minus.addActionListener(new operandListener());
        buttons.add(minus);

        JButton seven = new JButton("7");
        seven.addActionListener(new numberListener());
        buttons.add(seven);

        JButton eight = new JButton("8");
        eight.addActionListener(new numberListener());
        buttons.add(eight);

        JButton nine = new JButton("9");
        nine.addActionListener(new numberListener());
        buttons.add(nine);

        JButton multiply = new JButton("x");
        multiply.addActionListener(new operandListener());
        buttons.add(multiply);

        JButton zero = new JButton("0");
        zero.addActionListener(new numberListener());
        buttons.add(zero);

        JButton dot = new JButton(".");
        dot.addActionListener(new numberListener());
        buttons.add(dot);

        JButton potato = new JButton("Potato");
        potato.addActionListener(new potatoListener());
        buttons.add(potato);

        JButton divide = new JButton("/");
        divide.addActionListener(new operandListener());
        buttons.add(divide);

        JButton reset = new JButton("C/INPUT");
        reset.addActionListener(new resetListener());
        buttons.add(reset);

        JButton clear = new JButton("C/ALL");
        clear.addActionListener(new clearListener());
        buttons.add(clear);

        JButton enter = new JButton("ENTER");
        enter.setSize(400,100);
        enter.addActionListener(new enterListener());
        buttons.add(enter);

        add(buttons, BorderLayout.CENTER);
    }

    // Variables for input equation
    String number1 = " ";
    String operand = " ";
    String number2 = " ";
    double outputNumber = 0.0;
    boolean number1Used = false;
    boolean number2Used = false;
    boolean operandUsed = false;

    // Methods for what happens when a number is entered
    public class numberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // If number 1 is not used we full this space
            if (!number1Used) {
                number1 =  number1 + e.getActionCommand();
            }
            // If number 2 is not used we add that number
            else if (!number2Used) {
                number2 = number2 + e.getActionCommand();
            }
            // Otherwise the equation if full
            else {
                System.out.println("Hey the equation is full");
            }
            input.setText("Input: " + number1 + " " + operand + " " + number2);
        }
    }

    // Set the equations operand
    public class operandListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operand = e.getActionCommand();
            operandUsed = true;
            number1Used = true;
            input.setText("Input: " + number1 + " " + operand + " " + number2);
        }
    }

    // This clears everything in the input box
    public class resetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            input.setText("Input: 0");
            operand = " ";
            number1 = " ";
            number2 = " ";
            // When these are set to false the other methods will not display them
            operandUsed = false;
            number1Used = false;
            number2Used = false;
        }
    }

    // This clears all items
    public class clearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            input.setText("Input: 0");
            operand = " ";
            number1 = " ";
            number2 = " ";
            // When these are set to false the other methods will not display them
            operandUsed = false;
            number1Used = false;
            number2Used = false;
            output.setText("Output: 0");
            outputNumber = 0;
        }
    }

    // This performs the math
    public class enterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Determine the type of operation
            // Full equation
            if (!number2.equals(" ")){
                number2Used = true;
            }
            number1Used = !number1.equals(" ");
            // If there is a full equation this executes
            if (operandUsed && number1Used && number2Used) {
                // Addition with full equation
                switch (operand) {
                    case "+":
                        outputNumber = Double.parseDouble(number1) + Double.parseDouble(number2);
                        output.setText("Output: " + outputNumber);
                        // Subtraction with full equation
                        break;
                    case "-":
                        outputNumber = Double.parseDouble(number1) - Double.parseDouble(number2);
                        output.setText("Output: " + outputNumber);
                        // Multiplication with full equation
                        break;
                    case "x":
                        outputNumber = Double.parseDouble(number1) * Double.parseDouble(number2);
                        output.setText("Output: " + outputNumber);
                        // Division with full equation
                        break;
                    case "/":
                        outputNumber = Double.parseDouble(number1) / Double.parseDouble(number2);
                        output.setText("Output: " + outputNumber);
                        break;
                }
            }
            // If the equation starts with an opperand the first number is replaced by current output
            else if (operandUsed && number2Used) {
                // Addition with full equation
                switch (operand) {
                    case "+":
                        outputNumber = outputNumber + Double.parseDouble(number2);
                        output.setText("Output: " + outputNumber);
                        // Subtraction with full equation
                        break;
                    case "-":
                        outputNumber = outputNumber - Double.parseDouble(number2);
                        output.setText("Output: " + outputNumber);
                        // Multiplication with full equation
                        break;
                    case "x":
                        outputNumber = outputNumber * Double.parseDouble(number2);
                        output.setText("Output: " + outputNumber);
                        // Division with full equation
                        break;
                    case "/":
                        outputNumber = outputNumber / Double.parseDouble(number2);
                        output.setText("Output: " + outputNumber);
                        break;
                }
            }
            // There is not sufficient information to complete a operation
            else {
                System.out.println("Not enough information to complete operation.");
            }
        }
    }

    public class potatoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Calculator potatoCalculator = new Calculator();
            potatoCalculator.setVisible(true);
        }
    }

    // Something is broken if this is executed
    public void actionPerformed(ActionEvent e) {
        System.out.println("Potato");
    }

    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        myCalculator.setVisible(true);
    }
}