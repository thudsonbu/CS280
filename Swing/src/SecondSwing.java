import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondSwing  extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public SecondSwing() {
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("First Window Class");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JButton endButton = new JButton("Click to end program.");
        endButton.addActionListener(new EndingListener());
        add(endButton);
    }

    public static class EndingListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
