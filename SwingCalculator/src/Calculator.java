import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
    // CREATE A SWING GUI
    // Set width and height of calculator gui
    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;
    // Panels
    private JPanel top;
    private JPanel buttons;
    private JTextField input;
    private JTextField output;

    // Variables for input equation
    String number1 = " ";
    String operand = " ";
    String number2 = " ";
    double outputNumber = 0.0;
    boolean number1Used = false;
    boolean number2Used = false;
    boolean operandUsed = false;

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public double getOutputNumber() {
        return outputNumber;
    }

    public void setOutputNumber(double outputNumber) {
        this.outputNumber = outputNumber;
    }

    public boolean isNumber1Used() {
        return number1Used;
    }

    public void setNumber1Used(boolean number1Used) {
        this.number1Used = number1Used;
    }

    public boolean isNumber2Used() {
        return number2Used;
    }

    public void setNumber2Used(boolean number2Used) {
        this.number2Used = number2Used;
    }

    public boolean isOperandUsed() {
        return operandUsed;
    }

    public void setOperandUsed(boolean operandUsed) {
        this.operandUsed = operandUsed;
    }

    // Build the gui
    public Calculator(String num1, String oper, String num2, double outNum, boolean num1Used, boolean num2Used, boolean operUsed) {
        super("Tom's Java Calculator");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        number1 = num1;
        number2 = num2;
        operand = oper;
        outputNumber = outNum;
        number1Used = num1Used;
        number2Used = num2Used;
        operandUsed = operUsed;

        /*String number1 = num1;
        String number2 = num2;
        String operand = oper;
        double outputNumber = outNum;
        boolean number1Used = num1Used;
        boolean number2Used = num2Used;
        boolean operandUsed = operUsed;*/

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

        JButton enter = new JButton("=");
        enter.addActionListener(new enterListener());
        buttons.add(enter);


        JButton divide = new JButton("/");
        divide.addActionListener(new operandListener());
        buttons.add(divide);

        JButton reset = new JButton("C/INPUT");
        reset.addActionListener(new resetListener());
        buttons.add(reset);

        JButton clear = new JButton("C/ALL");
        clear.addActionListener(new clearListener());
        buttons.add(clear);

        JButton newCalc = new JButton("New");
        newCalc.addActionListener(new newListener());
        buttons.add(newCalc);

        JButton dupCalc = new JButton("Dup");
        dupCalc.addActionListener(this);
        buttons.add(dupCalc);

        add(buttons, BorderLayout.CENTER);
    }


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
            // If the equation starts with an operand the first number is replaced by current output
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

    /*public class duplicateListener implements ActionListener {
        String n1;
        String n2;
        String op;
        double ouNumber;
        boolean n1Used;
        boolean n2Used;
        boolean opUsed;

        public duplicateListener(String num1,String oper,String num2,double outputNum,boolean num1Used,
                                 boolean num2Used,boolean operUsed){
            n1 = num1;
            op = oper;
            n2 = num2;
            ouNumber = outputNum;
            n1Used = num1Used;
            n2Used = num2Used;
            opUsed = operUsed;
        }


        public void actionPerformed(ActionEvent e) {
            Calculator potatoCalculator = new Calculator(n1, op, n2, ouNumber, n1Used,
                    n2Used, opUsed);
            potatoCalculator.setVisible(true);
        }
    }*/

    public class newListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Calculator newCalculator = new Calculator(" "," "," ", 0, false,
                    false, false);
            newCalculator.setVisible(true);
        }
    }


    // Something is broken if this is executed
    public void actionPerformed(ActionEvent e) {
        Calculator dupCalculator = new Calculator(" "," "," ", 0, false,
                false, false);
        dupCalculator.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator myCalculator = new Calculator(" "," "," ", 0, false,
                false, false);
        myCalculator.setVisible(true);
    }
}