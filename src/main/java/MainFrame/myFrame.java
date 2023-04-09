package MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class myFrame {
    private final JFrame frame;
    private final JPanel panel;
    private static final int COLOR_CODE = 54;
    private static final int SCREEN_WIDTH = 1366;
    private static final int SCREEN_HEIGHT = 911;
    private static final int ROUNDED_EDGE_VALUE = 40;
    private static final int X_POSITION = 0;
    private static final int Y_POSITION = 0;

    public myFrame() {
        frame = new JFrame();
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setShape(new RoundRectangle2D.Double(X_POSITION, Y_POSITION, SCREEN_WIDTH, SCREEN_HEIGHT, ROUNDED_EDGE_VALUE, ROUNDED_EDGE_VALUE));
        panel = new JPanel();
        panel.setBounds(X_POSITION, Y_POSITION, SCREEN_WIDTH, 10);
        panel.setBackground(new Color(COLOR_CODE, COLOR_CODE, COLOR_CODE));
        panel.setVisible(false);
        frame.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void topLineRefresh() {
        panel.setVisible(false);
        panel.setVisible(true);
        panel.setVisible(false);
        panel.setVisible(true);
    }
}


