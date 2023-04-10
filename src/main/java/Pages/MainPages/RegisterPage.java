package Pages.MainPages;

import Images.IMG;
import at.favre.lib.crypto.bcrypt.BCrypt;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Random;

public class RegisterPage {
    private final JButton backButton, registerButton;
    private final JTextField firstNameField, lastNameField, emailField, dobField, pinField, confirmPINField;
    private final JLabel firstNameText, lastNameText, emailText, dobText, pinText, confirmPINText, label;
    private static final int X_POSITION_ABSOLUTE = 520;
    private static final int Y_POSITION_ABSOLUTE = 300;
    private static final int WIDTH_DIMENSION_ABSOLUTE = 200;
    private static final int HEIGHT_DIMENSION_ABSOLUTE = 25;
    private static final int FONT_TEXT_SIZE = 18;

    public RegisterPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(firstNameField = createFirstNameField());
        label.add(firstNameText = createFirstNameText());
        label.add(lastNameField = createLastNameField());
        label.add(lastNameText = createLastNameText());
        label.add(emailField = createEmailField());
        label.add(emailText = createEmailText());
        label.add(dobField = createDOBField());
        label.add(dobText = createDOBText());
        label.add(pinField = createPINField());
        label.add(pinText = createPINText());
        label.add(confirmPINField = createPINConfirmField());
        label.add(confirmPINText = createConfirmPINText());
        label.add(backButton = createBackButton());
        label.add(registerButton = createRegisterButton());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    private @NotNull JLabel createFirstNameText() {
        JLabel firstNameText = new JLabel("First Name:");
        firstNameText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        firstNameText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        firstNameText.setForeground(Color.white);
        return firstNameText;
    }

    private @NotNull JLabel createLastNameText() {
        JLabel lastNameText = new JLabel("Last Name:");
        lastNameText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 50, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        lastNameText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        lastNameText.setForeground(Color.white);
        return lastNameText;
    }

    private @NotNull JLabel createEmailText() {
        JLabel emailText = new JLabel("Email:");
        emailText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 100, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        emailText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        emailText.setForeground(Color.white);
        return emailText;
    }

    private @NotNull JLabel createDOBText() {
        JLabel dobText = new JLabel("Date of Birth:");
        dobText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 150, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        dobText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        dobText.setForeground(Color.white);
        return dobText;
    }

    private @NotNull JLabel createPINText() {
        JLabel pinText = new JLabel("PIN:");
        pinText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 200, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        pinText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        pinText.setForeground(Color.white);
        return pinText;
    }

    private @NotNull JLabel createConfirmPINText() {
        JLabel confirmPINText = new JLabel("Confirm PIN:");
        confirmPINText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 250, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        confirmPINText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        confirmPINText.setForeground(Color.white);
        return confirmPINText;
    }

    private @NotNull JTextField createFirstNameField() {
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(X_POSITION_ABSOLUTE + 143, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        firstNameField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        firstNameField.setBorder(null);
        return firstNameField;
    }

    private @NotNull JTextField createLastNameField() {
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(X_POSITION_ABSOLUTE + 143, Y_POSITION_ABSOLUTE + 50, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        lastNameField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        lastNameField.setBorder(null);
        return lastNameField;
    }

    private @NotNull JTextField createEmailField() {
        JTextField emailField = new JTextField("example@email.com");
        emailField.setBounds(X_POSITION_ABSOLUTE + 143, Y_POSITION_ABSOLUTE + 100, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        emailField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        emailField.setBorder(null);
        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (emailField.getText().contains("example@email.com")) {
                    emailField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (emailField.getText().trim().isEmpty()) {
                    emailField.setText("example@email.com");
                }
            }
        });
        return emailField;
    }

    private @NotNull JTextField createDOBField() {
        JTextField dobField = new JTextField("DD/MM/YYYY");
        dobField.setBounds(X_POSITION_ABSOLUTE + 143, Y_POSITION_ABSOLUTE + 150, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        dobField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        dobField.setBorder(null);
        dobField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (dobField.getText().contains("DD/MM/YYYY")) {
                    dobField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (dobField.getText().trim().isEmpty()) {
                    dobField.setText("DD/MM/YYYY");
                }
            }
        });
        return dobField;
    }

    private @NotNull JTextField createPINField() {
        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(X_POSITION_ABSOLUTE + 143, Y_POSITION_ABSOLUTE + 200, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        pinField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        pinField.setBorder(null);
        return pinField;
    }

    private @NotNull JTextField createPINConfirmField() {
        JPasswordField confirmPINField = new JPasswordField();
        confirmPINField.setBounds(X_POSITION_ABSOLUTE + 143, Y_POSITION_ABSOLUTE + 250, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        confirmPINField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_TEXT_SIZE));
        confirmPINField.setBorder(null);
        return confirmPINField;
    }

    private @NotNull JButton createRegisterButton() {
        JButton registerButton = new JButton(IMG.registerButton);
        registerButton.setContentAreaFilled(false);
        registerButton.setBounds(X_POSITION_ABSOLUTE + 120, Y_POSITION_ABSOLUTE * 2, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE * 2);
        registerButton.setBorder(null);
        registerButton.addActionListener(e -> {
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("example@email.com");
            dobField.setText("DD/MM/YYYY");
            pinField.setText("");
            confirmPINField.setText("");
        });
        return registerButton;
    }

    private @NotNull JButton createBackButton() {
        JButton backButton = new JButton(IMG.backButton);
        backButton.setContentAreaFilled(false);
        backButton.setBounds(X_POSITION_ABSOLUTE + 40, Y_POSITION_ABSOLUTE * 2, WIDTH_DIMENSION_ABSOLUTE - 143, HEIGHT_DIMENSION_ABSOLUTE * 2);
        backButton.setBorder(null);
        backButton.addActionListener(e -> {
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("example@email.com");
            dobField.setText("DD/MM/YYYY");
            pinField.setText("");
            confirmPINField.setText("");
        });
        return backButton;
    }

    public void hide() {
        backButton.setVisible(false);
        registerButton.setVisible(false);
        firstNameField.setVisible(false);
        lastNameField.setVisible(false);
        emailField.setVisible(false);
        dobField.setVisible(false);
        pinField.setVisible(false);
        confirmPINField.setVisible(false);
        firstNameText.setVisible(false);
        lastNameText.setVisible(false);
        emailText.setVisible(false);
        dobText.setVisible(false);
        pinText.setVisible(false);
        confirmPINText.setVisible(false);
        label.setVisible(false);
    }

    public void show() {
        backButton.setVisible(true);
        registerButton.setVisible(true);
        firstNameField.setVisible(true);
        lastNameField.setVisible(true);
        emailField.setVisible(true);
        dobField.setVisible(true);
        pinField.setVisible(true);
        confirmPINField.setVisible(true);
        firstNameText.setVisible(true);
        lastNameText.setVisible(true);
        emailText.setVisible(true);
        dobText.setVisible(true);
        pinText.setVisible(true);
        confirmPINText.setVisible(true);
        label.setVisible(true);
    }

    public boolean registerSuccessful() {
        boolean firstNameFieldIsValid = !firstNameField.getText().trim().isEmpty() && firstNameField.getText().matches("[A-z]*");
        boolean lastNameFieldIsValid = !lastNameField.getText().trim().isEmpty() && lastNameField.getText().matches("[A-z]*");
        boolean emailFieldIsValid = !emailField.getText().trim().isEmpty() && emailField.getText().matches("[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}") && !emailField.getText().equals("example@email.com");
        boolean dobFieldIsValid = !dobField.getText().trim().isEmpty() && dobField.getText().matches("(3[01]|[1-2]\\d|0?[1-9])/(1[0-2]|0?[1-9])/((\\d{2})?\\d{2})");
        boolean pinFieldIsValid = !pinField.getText().trim().isEmpty() && pinField.getText().matches("\\d*");
        boolean confirmPINFieldIsValid = !confirmPINField.getText().trim().isEmpty() && confirmPINField.getText().equals(pinField.getText());
        boolean checkIfEmailExists = StartPage.collection.countDocuments(new Document("Email", emailField.getText())) > 0;

        if (firstNameFieldIsValid && lastNameFieldIsValid && emailFieldIsValid && dobFieldIsValid && pinFieldIsValid && confirmPINFieldIsValid && !checkIfEmailExists) {
            Document registeredClient = new Document();
            registeredClient.append("First Name", firstNameField.getText());
            registeredClient.append("Last Name", lastNameField.getText());
            registeredClient.append("Email", emailField.getText());
            registeredClient.append("DOB", dobField.getText());
            registeredClient.append("Wallet", "0.00");
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, pinField.getText().toCharArray());
            registeredClient.append("PIN", bcryptHashString);
            Random random = new Random();
            long randomCardNumber = (long) (random.nextDouble() * 9_000_000_000_000_000L) + 1_000_000_000_000_000L;
            String[] splitRandomCardNumber = String.valueOf(randomCardNumber).split("");
            StringBuilder cardNumberAsTextSB = new StringBuilder();
            for (int i = 0; i < splitRandomCardNumber.length; i++) {
                if (i % 4 == 0) {
                    cardNumberAsTextSB.append(" ");
                }
                cardNumberAsTextSB.append(splitRandomCardNumber[i]);
            }
            registeredClient.append("Card Number", cardNumberAsTextSB.toString());
            long ibanRandomIbanNumber = (long) (random.nextDouble() * 9_000_000_000_000_0L) + 1_000_000_000_000_0L;
            String ibanAsString = "US23FAKE" + ibanRandomIbanNumber;
            registeredClient.append("IBAN", ibanAsString);
            int randomCVVNumber = random.nextInt(900) + 100;
            registeredClient.append("CVV", randomCVVNumber);
            registeredClient.append("Transactions", new ArrayList<>());
            StartPage.collection.insertOne(registeredClient);
            return true;
        } else {
            StringBuilder errorSB = new StringBuilder();
            if (!firstNameFieldIsValid) {
                errorSB.append("Invalid First Name, only letters are allowed.");
                errorSB.append(System.lineSeparator());
            }
            if (!lastNameFieldIsValid) {
                errorSB.append("Invalid Last name, only letters are allowed.");
                errorSB.append(System.lineSeparator());
            }
            if (!emailFieldIsValid) {
                errorSB.append("Invalid Email, please look the example.");
                errorSB.append(System.lineSeparator());
            }
            if (StartPage.collection.countDocuments(new Document("Email", emailField.getText())) > 0) {
                errorSB.append("This Email already exist.");
                errorSB.append(System.lineSeparator());
            }
            if (!dobFieldIsValid) {
                errorSB.append("Invalid Date of birth, please look the example.");
                errorSB.append(System.lineSeparator());
            }
            if (!pinFieldIsValid) {
                errorSB.append("Invalid PIN, only digits are allowed.");
                errorSB.append(System.lineSeparator());
            } else {
                if (!confirmPINFieldIsValid) {
                    errorSB.append("PIN don't match");
                    errorSB.append(System.lineSeparator());
                }
            }
            JOptionPane.showMessageDialog(null, errorSB.toString().trim(), "Invalid inputs", JOptionPane.ERROR_MESSAGE);
            return false;
        }


    }
}
