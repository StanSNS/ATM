package Pages.SecondaryPages;

import Images.IMG;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class AccountDetailsPage {
    private final JLabel label, cardLayout;
    private final JLabel bothNames, firstNameText, lastNameText, emailText, dobText, cardNumberText, ibanText, cvvText;
    private final JButton backButton, deleteButton;
    private final int X_POSITION_ABSOLUTE = 380;
    private final int Y_POSITION_ABSOLUTE = 500;
    private final int WIDTH_DIMENSION_ABSOLUTE = 800;
    private final int HEIGHT_DIMENSION_ABSOLUTE = 50;
    private final int FONT_SIZE_ABSOLUTE = 40;

    public AccountDetailsPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(backButton = createBackButton());
        label.add(bothNames = createBothNames());
        label.add(cardNumberText = createCardNumber());
        label.add(cvvText = createCVVNumber());
        label.add(firstNameText = createFirstNameText());
        label.add(lastNameText = createLastNameText());
        label.add(emailText = createEmailText());
        label.add(dobText = createDOBText());
        label.add(createCompanyNameText());
        label.add(createBICSWIFTText());
        label.add(ibanText = createIBANText());
        label.add(deleteButton = createDeleteButton());
        label.add(cardLayout = cardBackground());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getBothNames() {
        return bothNames;
    }

    public JLabel getCardNumberText() {
        return cardNumberText;
    }

    public JLabel getCvvText() {
        return cvvText;
    }

    public JLabel getFirstNameText() {
        return firstNameText;
    }

    public JLabel getLastNameText() {
        return lastNameText;
    }

    public JLabel getEmailText() {
        return emailText;
    }

    public JLabel getDobText() {
        return dobText;
    }

    public JLabel getIbanText() {
        return ibanText;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    private @NotNull JButton createBackButton() {
        JButton backButton = new JButton(IMG.backButton);
        backButton.setContentAreaFilled(false);
        backButton.setBounds(X_POSITION_ABSOLUTE - 370, Y_POSITION_ABSOLUTE + 335, WIDTH_DIMENSION_ABSOLUTE - 743, HEIGHT_DIMENSION_ABSOLUTE);
        backButton.setBorder(null);
        return backButton;
    }

    private @NotNull JButton createDeleteButton() {
        JButton deleteButton = new JButton(IMG.deleteButton);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBounds(X_POSITION_ABSOLUTE + 127, Y_POSITION_ABSOLUTE + 270, WIDTH_DIMENSION_ABSOLUTE - 446, HEIGHT_DIMENSION_ABSOLUTE + 54);
        deleteButton.setBorder(null);
        return deleteButton;
    }

    public JLabel cardBackground() {
        JLabel cardBackground = new JLabel(IMG.cardBackground);
        cardBackground.setBounds(X_POSITION_ABSOLUTE - 47, Y_POSITION_ABSOLUTE - 470, WIDTH_DIMENSION_ABSOLUTE - 100, HEIGHT_DIMENSION_ABSOLUTE + 300);
        return cardBackground;
    }

    public JLabel createBothNames() {
        JLabel bothNamesText = new JLabel();
        bothNamesText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE - 190, WIDTH_DIMENSION_ABSOLUTE - 200, HEIGHT_DIMENSION_ABSOLUTE);
        bothNamesText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        bothNamesText.setForeground(Color.white);
        return bothNamesText;
    }

    public JLabel createCardNumber() {
        JLabel cardNumberText = new JLabel();
        cardNumberText.setBounds(X_POSITION_ABSOLUTE - 20, Y_POSITION_ABSOLUTE - 330, WIDTH_DIMENSION_ABSOLUTE - 100, HEIGHT_DIMENSION_ABSOLUTE + 30);
        cardNumberText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE + 25));
        cardNumberText.setForeground(Color.white);
        return cardNumberText;
    }

    public JLabel createCVVNumber() {
        JLabel cvvNumberText = new JLabel();
        cvvNumberText.setBounds(X_POSITION_ABSOLUTE + 370, Y_POSITION_ABSOLUTE - 253, WIDTH_DIMENSION_ABSOLUTE - 500, HEIGHT_DIMENSION_ABSOLUTE);
        cvvNumberText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        cvvNumberText.setForeground(Color.white);
        return cvvNumberText;
    }

    public JLabel createFirstNameText() {
        JLabel firstNameText = new JLabel();
        firstNameText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE - 110, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        firstNameText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        firstNameText.setForeground(Color.white);
        return firstNameText;
    }

    public JLabel createLastNameText() {
        JLabel lastNameText = new JLabel();
        lastNameText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE - 60, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        lastNameText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        lastNameText.setForeground(Color.white);
        return lastNameText;
    }

    public JLabel createEmailText() {
        JLabel emailText = new JLabel();
        emailText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE - 10, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        emailText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        emailText.setForeground(Color.white);
        return emailText;
    }

    public JLabel createDOBText() {
        JLabel dobText = new JLabel();
        dobText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 40, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        dobText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        dobText.setForeground(Color.white);
        return dobText;
    }

    public JLabel createCompanyNameText() {
        JLabel companyNameText = new JLabel("Payment Institution: Fake AD");
        companyNameText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 90, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        companyNameText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        companyNameText.setForeground(Color.white);
        return companyNameText;
    }

    public JLabel createBICSWIFTText() {
        JLabel bicSwiftText = new JLabel("BIC/SWIFT: FAKEUSFS");
        bicSwiftText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 140, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        bicSwiftText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        bicSwiftText.setForeground(Color.white);
        return bicSwiftText;
    }

    public JLabel createIBANText() {
        JLabel iBanText = new JLabel();
        iBanText.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE + 190, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        iBanText.setFont(new Font("Bahnschrift", Font.BOLD, FONT_SIZE_ABSOLUTE));
        iBanText.setForeground(Color.white);
        return iBanText;
    }

    public void hide() {
        backButton.setVisible(false);
        cardLayout.setVisible(false);
        bothNames.setVisible(false);
        cardNumberText.setVisible(false);
        cvvText.setVisible(false);
        firstNameText.setVisible(false);
        lastNameText.setVisible(false);
        emailText.setVisible(false);
        dobText.setVisible(false);
        ibanText.setVisible(false);
        deleteButton.setVisible(false);
        label.setVisible(false);
    }

    public void show() {
        backButton.setVisible(true);
        cardLayout.setVisible(true);
        bothNames.setVisible(true);
        cardNumberText.setVisible(true);
        cvvText.setVisible(true);
        firstNameText.setVisible(true);
        lastNameText.setVisible(true);
        emailText.setVisible(true);
        dobText.setVisible(true);
        ibanText.setVisible(true);
        deleteButton.setVisible(true);
        label.setVisible(true);
    }
}
