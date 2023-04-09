package Pages.SecondaryPages;

import Images.IMG;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class BalancePage {
    private final JLabel label;
    private final JButton backButton;
    private final JLabel currentBalance;
    private final int X_POSITION_ABSOLUTE = 10;
    private final int Y_POSITION_ABSOLUTE = 430;
    private final int WIDTH_DIMENSION_ABSOLUTE = 57;
    private final int HEIGHT_DIMENSION_ABSOLUTE = 50;

    public BalancePage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(backButton = createBackButton());
        label.add(currentBalance = createCurrentBalanceText());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getCurrentBalance() {
        return currentBalance;
    }

    private @NotNull JButton createBackButton() {
        JButton backButton = new JButton(IMG.backButton);
        backButton.setContentAreaFilled(false);
        backButton.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 405, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        backButton.setBorder(null);
        return backButton;
    }

    public JLabel createCurrentBalanceText() {
        JLabel currentBalanceText = new JLabel();
        currentBalanceText.setBounds(X_POSITION_ABSOLUTE + 420, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE + 743, HEIGHT_DIMENSION_ABSOLUTE);
        int TEXT_SIZE_ABSOLUTE = 40;
        currentBalanceText.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE));
        currentBalanceText.setForeground(Color.white);
        return currentBalanceText;
    }

    public void hide() {
        backButton.setVisible(false);
        label.setVisible(false);
    }

    public void show() {
        backButton.setVisible(true);
        label.setVisible(true);
    }

}
