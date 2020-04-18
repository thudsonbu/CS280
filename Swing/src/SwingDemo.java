
public class SwingDemo {
    public static void main(String[] args){
        BasicSwing basic = new BasicSwing();
        basic.setVisible(true);

        BorderLayoutSwing b = new BorderLayoutSwing();
        b.setVisible(true);

        FlowLayoutSwing f = new FlowLayoutSwing();
        f.setVisible(true);

        GridLayoutSwing g = new GridLayoutSwing(2,2);
        g.setVisible(true);

        SwingPanelDemo p = new SwingPanelDemo();
        p.setVisible(true);

        SwingMenu m = new SwingMenu();
        m.setVisible(true);
    }
}
