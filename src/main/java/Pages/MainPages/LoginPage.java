package Pages.MainPages;

import Images.IMG;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class LoginPage {
    private final JButton backButton, loginButton;
    private final JTextField emailField, pinField;
    private final JLabel emailText, pinText;
    private final JLabel label;
    private final static int FONT_SIZE = 18;
    private final static int X_POSITION_ABSOLUTE = 500;
    private final static int Y_POSITION_ABSOLUTE = 420;
    private final static int HEIGHT_DIMENSION_ABSOLUTE = 25;
    private final static int WIDTH_DIMENSION_ABSOLUTE = 200;
    private String emailLoggedPerson;

    public LoginPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(backButton = createBackButton());
        label.add(loginButton = createLoginButton());
        label.add(emailField = createEmailLoginField());
        label.add(pinField = createPINField());
        label.add(emailText = createEmailText());
        label.add(pinText = createPINText());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public String getEmailLoggedPerson() {
        return emailLoggedPerson;
    }

    private @NotNull JButton createBackButton() {
        JButton backButton = new JButton(IMG.backButton);
        backButton.setContentAreaFilled(false);
        backButton.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 107, WIDTH_DIMENSION_ABSOLUTE - 143, HEIGHT_DIMENSION_ABSOLUTE * 2);
        backButton.setBorder(null);
        backButton.addActionListener(e -> {
            pinField.setText("");
            emailField.setText("");
        });
        return backButton;
    }

    private @NotNull JButton createLoginButton() {
        JButton loginButton = new JButton(IMG.loginButton);
        loginButton.setContentAreaFilled(false);
        loginButton.setBounds(X_POSITION_ABSOLUTE + 83, Y_POSITION_ABSOLUTE + 107, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE * 2);
        loginButton.setBorder(null);
        loginButton.addActionListener(e -> {
            pinField.setText("");
            emailField.setText("");
        });
        return loginButton;
    }

    private @NotNull JTextField createEmailLoginField() {
        JTextField emailField = new JTextField();
        emailField.setBounds(X_POSITION_ABSOLUTE + 83, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        emailField.setBorder(null);
        emailField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE - 2));
        return emailField;
    }

    private @NotNull JTextField createPINField() {
        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(X_POSITION_ABSOLUTE + 83, Y_POSITION_ABSOLUTE + 50, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        pinField.setBorder(null);
        pinField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE - 2));
        return pinField;
    }

    private @NotNull JLabel createPINText() {
        JLabel pinText = new JLabel("PIN:");
        pinText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 50, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        pinText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE));
        pinText.setForeground(Color.white);
        return pinText;
    }

    private @NotNull JLabel createEmailText() {
        JLabel emailText = new JLabel("Email:");
        emailText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        emailText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE));
        emailText.setForeground(Color.white);
        return emailText;
    }

    public void hide() {
        backButton.setVisible(false);
        loginButton.setVisible(false);
        emailField.setVisible(false);
        pinField.setVisible(false);
        emailText.setVisible(false);
        pinText.setVisible(false);
        label.setVisible(false);
    }

    public void show() {
        backButton.setVisible(true);
        loginButton.setVisible(true);
        emailField.setVisible(true);
        pinField.setVisible(true);
        emailText.setVisible(true);
        pinText.setVisible(true);
        label.setVisible(true);
    }

    public boolean loginIsValid() {
        Document document = StartPage.collection.find(Filters.eq("Email", emailField.getText())).first();
        if (document != null) {
            emailLoggedPerson = emailField.getText();
            BCrypt.Result result = BCrypt.verifyer().verify(pinField.getText().toCharArray(), document.get("PIN").toString());
            if (result.verified) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Invalid Email or PIN", "Invalid inputs", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
