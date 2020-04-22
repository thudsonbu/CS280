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
        input = new JTextField("Input: ",1);
        input.setEditable(false);
        top.add(input);
        output = new JTextField("Output: ", 1);
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

        JButton reset = new JButton("RESET");
        reset.addActionListener(new resetListener());
        buttons.add(reset);

        JButton clear = new JButton("CLEAR");
        clear.addActionListener(this);
        buttons.add(clear);

        JButton divide = new JButton("/");
        divide.addActionListener(new operandListener());
        buttons.add(divide);

        JButton enter = new JButton("ENTER");
        enter.setSize(400,100);
        enter.addActionListener(new enterListener());
        buttons.add(enter);

        add(buttons, BorderLayout.CENTER);
    }

    // Variables for input equation
    double number1 = 0.0;
    String operand = " ";
    double number2 = 0.0;
    double outputNumber = 0.0;
    boolean number1Used = false;
    boolean number2Used = false;
    boolean operandUsed = false;

    // Methods for what happens when a number is entered
    public class numberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // If number 1 is not used we full this space
            if (number1Used == false) {
                number1 = Integer.parseInt(e.getActionCommand());
                number1Used = true;
                input.setText("Input: " + number1 + " " + operand);
            }
            // If number 2 is not used we add that number
            else if (number2Used == false) {
                number2 = Integer.parseInt(e.getActionCommand());
                number2Used = true;
                input.setText("Input: " + number1 + " " + operand + " " + number2);
            }
            // Otherwise the equation if full
            else {
                System.out.println("Hey the equation is full");
            }
        }
    }

    // Set the equations operand
    public class operandListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operand = e.getActionCommand();
            operandUsed = true;
            // If number2 is not used and number 1 is not used only the operand will be displayed
            if (number2Used == false && number1Used == false) {
                input.setText("Input: " + "  " + operand);
            }
            // If number1 is used but not number 2 only number1 and operand will be displayed
            else if (number1Used == true && number2Used == false) {
                input.setText("Input: " + number1 + " " + operand);
            }
            // Display all elements otherwise
            else {
                input.setText("Input: " + number1 + " " + operand + " " + number2);
            }
        }
    }

    // This clears everything in the input box
    public class resetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            input.setText("Input: ");
            operand = " ";
            // When these are set to false the other methods will not display them
            operandUsed = false;
            number1Used = false;
            number2Used = false;
        }
    }

    // This performs the math
    public class enterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Determine the type of operation
            // Full equation
            if (operandUsed && number1Used && number2Used) {
                // Addition with full equation
                if (operand.equals("+")) {
                    outputNumber = number1 + number2;
                    output.setText("Output: " + outputNumber);
                // Subtraction with full equation
                } else if (operand.equals("-")){
                    outputNumber = number1 - number2;
                    output.setText("Output: " + outputNumber);
                // Multiplication with full equation
                } else if (operand.equals("x")){
                    outputNumber = number1 * number2;
                    output.setText("Output: " + outputNumber);
                // Division with full equation
                } else if (operand.equals("/")) {
                    outputNumber = number1/number2;
                    output.setText("Output: " + outputNumber);
                }
            }
            // Part of equation
            else if (operandUsed && number1Used) {
                // Addition with part
                if (operand.equals("+")) {
                    outputNumber = number1 + outputNumber;
                    output.setText("Output: " + outputNumber);
                    // Subtraction with part
                } else if (operand.equals("-")){
                    outputNumber = outputNumber - number1;
                    output.setText("Output: " + outputNumber);
                    // Multiplication with part
                } else if (operand.equals("x")){
                    outputNumber = number1 * outputNumber;
                    output.setText("Output: " + outputNumber);
                    // Division with with part
                } else if (operand.equals("/")) {
                    outputNumber = outputNumber / number1;
                    output.setText("Output: " + outputNumber);
                }
            }
            // There is not sufficient information to complete a operation
            else {
                System.out.println("Not enough information to complete operation.");
            }
        }
    }


    //
    public void actionPerformed(ActionEvent e) {
        System.out.println("Potato");
    }

    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        myCalculator.setVisible(true);
    }
}