package Pages.SecondaryPages;

import Images.IMG;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class TransferPage {
    private final JLabel label;
    private final JButton cancelButton, okButton;
    private final JTextField amountField, ibanField, bicSwiftField, institutionField, recipientField;
    private final JLabel amountText, ibanText, bicSwiftText, institutionText, recipientText;
    private final JLabel currentBalance;
    private final JProgressBar progressBar;
    private final int X_Position_ABSOLUTE = 500;
    private final int Y_Position_ABSOLUTE = 400;
    private final int WIDTH_DIMENSION_ABSOLUTE = 200;
    private final int HEIGHT_DIMENSION_ABSOLUTE = 25;
    private final int TEXT_SIZE_ABSOLUTE = 18;

    public TransferPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(cancelButton = createCancelButton());
        label.add(okButton = createOkButton());
        label.add(amountField = createAmountField());
        label.add(amountText = createAmountText());
        label.add(progressBar = creatingProgressBar());
        label.add(currentBalance = createCurrentBalanceText());
        label.add(ibanField = createIbanField());
        label.add(ibanText = createIbanText());
        label.add(bicSwiftField = createBicSwiftField());
        label.add(bicSwiftText = createBicSwiftText());
        label.add(institutionField = createInstitutionField());
        label.add(institutionText = createInstitutionText());
        label.add(recipientField = createRecipientField());
        label.add(recipientText = createRecipientText());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JLabel getCurrentBalance() {
        return currentBalance;
    }

    public JLabel createCurrentBalanceText() {
        JLabel currentBalanceText = new JLabel();
        currentBalanceText.setBounds(X_Position_ABSOLUTE - 70, Y_Position_ABSOLUTE - 100, WIDTH_DIMENSION_ABSOLUTE + 400, HEIGHT_DIMENSION_ABSOLUTE + 25);
        currentBalanceText.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE + 22));
        currentBalanceText.setForeground(Color.white);
        return currentBalanceText;
    }

    private @NotNull JLabel createRecipientText() {
        JLabel recipient = new JLabel("Recipient:");
        recipient.setBounds(X_Position_ABSOLUTE, Y_Position_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        recipient.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE));
        recipient.setForeground(Color.white);
        return recipient;
    }

    private @NotNull JTextField createRecipientField() {
        JTextField recipient = new JTextField();
        recipient.setBounds(X_Position_ABSOLUTE + 170, Y_Position_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        recipient.setBorder(null);
        recipient.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE + 2));
        return recipient;
    }

    private @NotNull JLabel createInstitutionText() {
        JLabel institution = new JLabel("Institution:");
        institution.setBounds(X_Position_ABSOLUTE, Y_Position_ABSOLUTE + 50, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        institution.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE));
        institution.setForeground(Color.white);
        return institution;
    }

    private @NotNull JTextField createInstitutionField() {
        JTextField institution = new JTextField();
        institution.setBounds(X_Position_ABSOLUTE + 170, Y_Position_ABSOLUTE + 50, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        institution.setBorder(null);
        institution.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE + 2));
        return institution;
    }

    private @NotNull JLabel createBicSwiftText() {
        JLabel bicSwift = new JLabel("BIC/SWIFT:");
        bicSwift.setBounds(X_Position_ABSOLUTE, Y_Position_ABSOLUTE + 100, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        bicSwift.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE));
        bicSwift.setForeground(Color.white);
        return bicSwift;
    }

    private @NotNull JTextField createBicSwiftField() {
        JTextField bicSwift = new JTextField();
        bicSwift.setBounds(X_Position_ABSOLUTE + 170, Y_Position_ABSOLUTE + 100, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        bicSwift.setBorder(null);
        bicSwift.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE + 2));
        return bicSwift;
    }

    private @NotNull JLabel createIbanText() {
        JLabel iban = new JLabel("IBAN:");
        iban.setBounds(X_Position_ABSOLUTE, Y_Position_ABSOLUTE + 150, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        iban.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE));
        iban.setForeground(Color.white);
        return iban;
    }

    private @NotNull JTextField createIbanField() {
        JTextField iban = new JTextField();
        iban.setBounds(X_Position_ABSOLUTE + 170, Y_Position_ABSOLUTE + 150, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        iban.setBorder(null);
        iban.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE + 2));
        return iban;
    }

    private @NotNull JLabel createAmountText() {
        JLabel amountText = new JLabel("Transfer amount:");
        amountText.setBounds(X_Position_ABSOLUTE, Y_Position_ABSOLUTE + 200, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        amountText.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE));
        amountText.setForeground(Color.white);
        return amountText;
    }

    private @NotNull JTextField createAmountField() {
        JTextField amountField = new JTextField();
        amountField.setBounds(X_Position_ABSOLUTE + 170, Y_Position_ABSOLUTE + 200, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        amountField.setBorder(null);
        amountField.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE + 2));
        return amountField;
    }

    private @NotNull JButton createCancelButton() {
        JButton cancel = new JButton(IMG.cancelButton);
        cancel.setContentAreaFilled(false);
        cancel.setBounds(X_Position_ABSOLUTE + 90, Y_Position_ABSOLUTE + 250, WIDTH_DIMENSION_ABSOLUTE - 110, HEIGHT_DIMENSION_ABSOLUTE + 65);
        cancel.setBorder(null);
        cancel.addActionListener(e -> amountField.setText(""));
        return cancel;
    }

    private @NotNull JButton createOkButton() {
        JButton ok = new JButton(IMG.oKButton);
        ok.setContentAreaFilled(false);
        ok.setBounds(X_Position_ABSOLUTE + 190, Y_Position_ABSOLUTE + 250, WIDTH_DIMENSION_ABSOLUTE - 110, HEIGHT_DIMENSION_ABSOLUTE + 65);
        ok.setBorder(null);
        return ok;
    }

    private @NotNull JProgressBar creatingProgressBar() {
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(X_Position_ABSOLUTE - 500, Y_Position_ABSOLUTE + 471, WIDTH_DIMENSION_ABSOLUTE + 1166, HEIGHT_DIMENSION_ABSOLUTE + 10);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(56, 157, 14));
        progressBar.setBackground(Color.white);
        progressBar.setFont((new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE + 2)));
        progressBar.setBorder(null);
        progressBar.setVisible(false);
        return progressBar;
    }

    public void hide() {
        cancelButton.setVisible(false);
        okButton.setVisible(false);
        amountField.setVisible(false);
        ibanField.setVisible(false);
        bicSwiftField.setVisible(false);
        institutionField.setVisible(false);
        recipientField.setVisible(false);
        amountText.setVisible(false);
        ibanText.setVisible(false);
        bicSwiftText.setVisible(false);
        institutionText.setVisible(false);
        recipientText.setVisible(false);
        progressBar.setVisible(true);
        amountField.setText("");
        ibanField.setText("");
        bicSwiftField.setText("");
        institutionField.setText("");
        recipientField.setText("");
        label.setVisible(false);
    }

    public void show() {
        cancelButton.setVisible(true);
        okButton.setVisible(true);
        amountField.setVisible(true);
        ibanField.setVisible(true);
        bicSwiftField.setVisible(true);
        institutionField.setVisible(true);
        recipientField.setVisible(true);
        amountText.setVisible(true);
        ibanText.setVisible(true);
        bicSwiftText.setVisible(true);
        institutionText.setVisible(true);
        recipientText.setVisible(true);
        progressBar.setVisible(false);
        label.setVisible(true);
    }

    public boolean isValidTransfer() {
        boolean recipientIsValid = recipientField.getText().matches("[A-Za-z]+ [A-Za-z]+");
        boolean institutionIsValid = institutionField.getText().matches("[A-Za-z]+ [A-Za-z]+");
        boolean bicSwiftIsValid = bicSwiftField.getText().matches("[A-Za-z]+");
        boolean ibanIsValid = ibanField.getText().matches("(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{15,33}");
        boolean transferAmountIsValid = amountField.getText().matches("\\d+.?\\d+");
        if (recipientIsValid && institutionIsValid && bicSwiftIsValid && ibanIsValid && transferAmountIsValid) {
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
            StringBuilder errorSB = new StringBuilder();
            if (!recipientIsValid) {
                errorSB.append("Invalid Recipient");
                errorSB.append(System.lineSeparator());
                recipientField.setText("");
            }
            if (!institutionIsValid) {
                errorSB.append("Invalid Institution");
                errorSB.append(System.lineSeparator());
                institutionField.setText("");
            }
            if (!bicSwiftIsValid) {
                errorSB.append("Invalid BIC/SWIFT CODE");
                errorSB.append(System.lineSeparator());
                bicSwiftField.setText("");
            }
            if (!ibanIsValid) {
                errorSB.append("Invalid IBAN");
                errorSB.append(System.lineSeparator());
                ibanField.setText("");
            }
            if (!transferAmountIsValid) {
                errorSB.append("Invalid Amount");
                errorSB.append(System.lineSeparator());
                amountField.setText("");
            }
            JOptionPane.showMessageDialog(null, errorSB.toString(), "Invalid inputs", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }


}
