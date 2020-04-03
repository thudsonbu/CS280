import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class FlowLayoutSwing extends JFrame{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public FlowLayoutSwing() {
        super("Flow Layout Swing Example");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JLabel label1 = new JLabel("First Label");
        add(label1);

        JLabel label2 = new JLabel("Second Label");
        add(label2);

        JLabel label3 = new JLabel("Third Label");
        add(label3);
    }
}
