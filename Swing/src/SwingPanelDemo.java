import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingPanelDemo extends JFrame implements ActionListener {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    private JPanel bluePanel;
    private JPanel whitePanel;
    private JPanel grayPanel;

    public SwingPanelDemo() {
        super ("Swing Panels Example");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel biggerPanel = new JPanel();
        biggerPanel.setLayout(new GridLayout(1,3)); // inside bigger panel, a grid layout is places

        // add the little panels to the grid layout inside of the bigger panel
        bluePanel = new JPanel();
        bluePanel.setBackground(Color.LIGHT_GRAY);
        biggerPanel.add(bluePanel); // Add the first panel to the inside of the above grid layout

        whitePanel = new JPanel();
        whitePanel.setBackground(Color.LIGHT_GRAY);
        biggerPanel.add(whitePanel);

        grayPanel = new JPanel();
        grayPanel.setBackground(Color.LIGHT_GRAY);
        biggerPanel.add(grayPanel);

        add(biggerPanel, BorderLayout.CENTER);

        JPanel buttonPane1 = new JPanel();
        buttonPane1.setBackground(Color.LIGHT_GRAY);
        buttonPane1.setLayout(new FlowLayout());

        JButton blueButton = new JButton("Blue");
        blueButton.setBackground(Color.BLUE);
        blueButton.addActionListener(this);
        buttonPane1.add(blueButton);

        JButton whiteButton = new JButton("White");
        whiteButton.setBackground(Color.WHITE);
        whiteButton.addActionListener(this);
        buttonPane1.add(whiteButton);

        JButton grayButton = new JButton("Gray");
        grayButton.setBackground(Color.GRAY);
        grayButton.addActionListener(this);
        buttonPane1.add(grayButton);

        add(buttonPane1, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonString = e.getActionCommand();

        if (buttonString.equals("Blue")){
            bluePanel.setBackground(Color.BLUE);
        } else if (buttonString.equals("White")){
            whitePanel.setBackground(Color.WHITE);
        } else if (buttonString.equals("Gray")){
            grayPanel.setBackground(Color.GRAY);
        } else {
            System.out.println("Error");
        }
    }
}
