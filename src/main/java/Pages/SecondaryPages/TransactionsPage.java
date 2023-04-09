package Pages.SecondaryPages;

import Images.IMG;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class TransactionsPage {
    private final JLabel label;
    private final JButton backButton;
    private final JLabel historyText, transactionsBackground;
    private final int X_POSITION_ABSOLUTE = 360;
    private final int Y_POSITION_ABSOLUTE = 55;
    private final int WIDTH_DIMENSION_ABSOLUTE = 800;
    private final int HEIGHT_DIMENSION_ABSOLUTE = 800;

    public TransactionsPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(backButton = createCancelButton());
        label.add(historyText = createHistoryText());
        label.add(transactionsBackground = createTransactionsBackground());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getHistoryText() {
        return historyText;
    }

    private @NotNull JButton createCancelButton() {
        JButton backButton = new JButton(IMG.backButton);
        backButton.setContentAreaFilled(false);
        backButton.setBounds(X_POSITION_ABSOLUTE - 350, Y_POSITION_ABSOLUTE + 785, WIDTH_DIMENSION_ABSOLUTE - 743, HEIGHT_DIMENSION_ABSOLUTE - 750);
        backButton.setBorder(null);
        return backButton;
    }

    public JLabel createHistoryText() {
        JLabel historyLabel = new JLabel();
        historyLabel.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 25, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        historyLabel.setFont(new Font("Bahnschrift", Font.BOLD, 35));
        historyLabel.setForeground(Color.white);
        return historyLabel;
    }

    public JLabel createTransactionsBackground() {
        JLabel transactionBackground = new JLabel(IMG.transactionsBackground);
        transactionBackground.setIcon(IMG.transactionsBackground);
        transactionBackground.setBounds(X_POSITION_ABSOLUTE - 27, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE - 100, HEIGHT_DIMENSION_ABSOLUTE);
        return transactionBackground;
    }

    public void hide() {
        backButton.setVisible(false);
        transactionsBackground.setVisible(false);
        label.setVisible(false);
    }

    public void show() {
        backButton.setVisible(true);
        transactionsBackground.setVisible(true);
        label.setVisible(true);
    }
}
