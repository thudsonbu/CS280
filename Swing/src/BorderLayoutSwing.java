import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class BorderLayoutSwing extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public BorderLayoutSwing() {
        super("BorderLayout Demonstration"); // this sets a title by accessting the JFrame title constructor
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout( ));

        JLabel label1 = new JLabel("SOUTH Label");
        add(label1, BorderLayout.SOUTH);

        JLabel label2 = new JLabel("CENTER Label");
        add(label2, BorderLayout.CENTER);

        JLabel label3 = new JLabel("NORTH Label3");
        add(label3, BorderLayout.NORTH);

        JLabel label4 = new JLabel("EAST Label");
        add(label4, BorderLayout.EAST);

        JLabel label5 = new JLabel("WEST Label");
        add(label5, BorderLayout.WEST);
    }
}