package Pages.SecondaryPages;

import Images.IMG;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class ChangePinPage {
    private final JLabel label;
    private final JButton cancelButton, submitButton;
    private final JTextField oldPINField, newPinField, confirmNewPinField;
    private final JLabel oldPINText, newPINText, confirmNewPINText;
    private String oldPIN, newPIN;
    private final static int BUTTON_BOX_DIMENSIONS = 90;
    private final static int HEIGHT_DIMENSION_ABSOLUTE = 25;
    private final static int WIDTH_DIMENSION_ABSOLUTE = 200;
    private final static int X_POSITION_ABSOLUTE = 500;
    private final static int Y_POSITION_ABSOLUTE = 380;
    private final static int FONT_SIZE_ABSOLUTE = 18;

    public ChangePinPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(cancelButton = createCancelButton());
        label.add(submitButton = createOkButton());
        label.add(oldPINField = createOldPINField());
        label.add(newPinField = createNewPINField());
        label.add(confirmNewPinField = createConfirmNewPINField());
        label.add(oldPINText = createOldPINText());
        label.add(newPINText = createNewPINText());
        label.add(confirmNewPINText = createConfirmNewPINText());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public String getOldPIN() {
        return oldPIN;
    }

    public String getNewPIN() {
        return newPIN;
    }

    private @NotNull JButton createCancelButton() {
        JButton cancelButton = new JButton(IMG.cancelButton);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setBounds(X_POSITION_ABSOLUTE + 100, Y_POSITION_ABSOLUTE + 150, BUTTON_BOX_DIMENSIONS, BUTTON_BOX_DIMENSIONS);
        cancelButton.setBorder(null);
        cancelButton.addActionListener(e -> {
            oldPINField.setText("");
            newPinField.setText("");
            confirmNewPinField.setText("");
        });
        return cancelButton;
    }

    private @NotNull JButton createOkButton() {
        JButton okButton = new JButton(IMG.oKButton);
        okButton.setContentAreaFilled(false);
        okButton.setBounds(X_POSITION_ABSOLUTE + 200, Y_POSITION_ABSOLUTE + 150, BUTTON_BOX_DIMENSIONS, BUTTON_BOX_DIMENSIONS);
        okButton.setBorder(null);
        okButton.addActionListener(e -> {
            oldPINField.setText("");
            newPinField.setText("");
            confirmNewPinField.setText("");
        });
        return okButton;
    }

    private @NotNull JTextField createOldPINField() {
        JPasswordField oldPINField = new JPasswordField();
        oldPINField.setBounds(X_POSITION_ABSOLUTE + 170, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        oldPINField.setBorder(null);
        oldPINField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE + 4));
        return oldPINField;
    }

    private @NotNull JTextField createNewPINField() {
        JPasswordField newPinField = new JPasswordField();
        newPinField.setBounds(X_POSITION_ABSOLUTE + 170, Y_POSITION_ABSOLUTE + 50, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        newPinField.setBorder(null);
        newPinField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE + 4));
        return newPinField;
    }

    private @NotNull JTextField createConfirmNewPINField() {
        JPasswordField confirmNewPinField = new JPasswordField();
        confirmNewPinField.setBounds(X_POSITION_ABSOLUTE + 170, Y_POSITION_ABSOLUTE + 100, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        confirmNewPinField.setBorder(null);
        confirmNewPinField.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE + 4));
        return confirmNewPinField;
    }

    private @NotNull JLabel createOldPINText() {
        JLabel oldPINText = new JLabel("Old PIN:");
        oldPINText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        oldPINText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        oldPINText.setForeground(Color.white);
        return oldPINText;
    }

    private @NotNull JLabel createNewPINText() {
        JLabel newPINText = new JLabel("New PIN:");
        newPINText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 50, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        newPINText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        newPINText.setForeground(Color.white);
        return newPINText;
    }

    private @NotNull JLabel createConfirmNewPINText() {
        JLabel confirmNewPINText = new JLabel("Confirm new PIN:");
        confirmNewPINText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 100, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        confirmNewPINText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        confirmNewPINText.setForeground(Color.white);
        return confirmNewPINText;
    }

    public void hide() {
        cancelButton.setVisible(false);
        submitButton.setVisible(false);
        oldPINField.setVisible(false);
        newPinField.setVisible(false);
        confirmNewPinField.setVisible(false);
        oldPINText.setVisible(false);
        newPINText.setVisible(false);
        confirmNewPINText.setVisible(false);
        label.setVisible(false);
    }

    public void show() {
        cancelButton.setVisible(true);
        submitButton.setVisible(true);
        oldPINField.setVisible(true);
        newPinField.setVisible(true);
        confirmNewPinField.setVisible(true);
        oldPINText.setVisible(true);
        newPINText.setVisible(true);
        confirmNewPINText.setVisible(true);
        label.setVisible(true);
    }

    public boolean isPINValid() {
        boolean isOldPinValid = oldPINField.getText().matches("\\d*");
        boolean isNewPinValid = newPinField.getText().matches("\\d*");
        boolean isConfirmNewPinValid = confirmNewPinField.getText().matches("\\d*");
        if (isOldPinValid && isNewPinValid && isConfirmNewPinValid && newPinField.getText().equals(confirmNewPinField.getText())) {
            oldPIN = oldPINField.getText();
            newPIN = newPinField.getText();
            return true;
        }
        JOptionPane.showMessageDialog(null, "Invalid fields", "Invalid inputs", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
