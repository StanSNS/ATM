package Pages.SecondaryPages;

import Images.IMG;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class WithdrawPage {
    private final JButton cancelButton, depositButton;
    private final JTextField amountField;
    private final JLabel amountText, currentBalance, label;
    private final JProgressBar progressBar;
    private final static int FONT_SIZE_ABSOLUTE = 18;
    private final static int X_POSITION_ABSOLUTE = 540;
    private final static int Y_POSITION_ABSOLUTE = 450;
    private final static int BUTTON_BOX_DIMENSIONS = 90;
    private final static int WIDTH_DIMENSION_ABSOLUTE = 200;
    private final static int HEIGHT_DIMENSION_ABSOLUTE = 25;

    public WithdrawPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(cancelButton = createCancelButton());
        label.add(depositButton = crateOKButton());
        label.add(amountField = createAmountField());
        label.add(amountText = createAmountText());
        label.add(progressBar = creatingProgressBar());
        label.add(currentBalance = createCurrentBalanceText());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getOkButton() {
        return depositButton;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JLabel getCurrentBalance() {
        return currentBalance;
    }

    private @NotNull JButton createCancelButton() {
        JButton cancelButton = new JButton(IMG.cancelButton);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setBounds(X_POSITION_ABSOLUTE + 50, Y_POSITION_ABSOLUTE + 50, BUTTON_BOX_DIMENSIONS, BUTTON_BOX_DIMENSIONS);
        cancelButton.setBorder(null);
        cancelButton.addActionListener(e -> amountField.setText(""));
        return cancelButton;
    }

    private @NotNull JButton crateOKButton() {
        JButton okButton = new JButton(IMG.oKButton);
        okButton.setContentAreaFilled(false);
        okButton.setBounds(X_POSITION_ABSOLUTE + 150, Y_POSITION_ABSOLUTE + 50, BUTTON_BOX_DIMENSIONS, BUTTON_BOX_DIMENSIONS);
        okButton.setBorder(null);
        return okButton;
    }

    private @NotNull JProgressBar creatingProgressBar() {
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(X_POSITION_ABSOLUTE - 540, Y_POSITION_ABSOLUTE + 421, WIDTH_DIMENSION_ABSOLUTE + 1166, HEIGHT_DIMENSION_ABSOLUTE + 10);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(56, 157, 14));
        progressBar.setBackground(Color.white);
        progressBar.setFont((new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE + 2)));
        progressBar.setBorder(null);
        progressBar.setVisible(false);
        return progressBar;
    }

    private @NotNull JTextField createAmountField() {
        JTextField amountField = new JTextField();
        amountField.setBounds(X_POSITION_ABSOLUTE + 100, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        amountField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        amountField.setBorder(null);
        return amountField;
    }

    private @NotNull JLabel createAmountText() {
        JLabel amountText = new JLabel("Withdraw amount:");
        amountText.setBounds(X_POSITION_ABSOLUTE - 110, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE + 3, HEIGHT_DIMENSION_ABSOLUTE);
        amountText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE + 4));
        amountText.setForeground(Color.white);
        return amountText;
    }

    public JLabel createCurrentBalanceText() {
        JLabel currentBalanceText = new JLabel();
        currentBalanceText.setBounds(X_POSITION_ABSOLUTE - 110, Y_POSITION_ABSOLUTE - 80, WIDTH_DIMENSION_ABSOLUTE + 600, HEIGHT_DIMENSION_ABSOLUTE + 25);
        currentBalanceText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE + 22));
        currentBalanceText.setForeground(Color.white);
        return currentBalanceText;
    }

    public void hide() {
        cancelButton.setVisible(false);
        depositButton.setVisible(false);
        amountField.setVisible(false);
        amountText.setVisible(false);
        progressBar.setVisible(true);
        label.setVisible(false);
    }

    public void show() {
        cancelButton.setVisible(true);
        depositButton.setVisible(true);
        amountField.setVisible(true);
        amountText.setVisible(true);
        progressBar.setVisible(false);
        label.setVisible(true);
    }

    public boolean isValidDeposit() {
        boolean isAmountValid = amountField.getText().matches("\\d*.?\\d+") && !amountField.getText().contains("\\s+");
        if (isAmountValid) {
            progressBar.setValue(0);
            int i = 0;
            progressBar.setVisible(true);
            try {
                while (i <= 100) {
                    Thread.sleep(10);
                    progressBar.paintImmediately(0, 0, 1366, 35);
                    progressBar.setValue(i);
                    i++;
                }
            } catch (Exception e1) {
                System.out.print("Exception is =" + e1);
            }

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "The amount you tried to enter is invalid. Make sure you are writing only digits.", "Invalid amount", JOptionPane.ERROR_MESSAGE);
            amountField.setText("");
            return false;
        }

    }


}
