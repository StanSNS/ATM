package Pages.MainPages;

import Images.IMG;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPage {
    private final JButton withdrawButton, balanceButton, changePinButton, accountDetailsButton, depositButton, transferButton, transactionsButton, donationButton, logOutButton;
    private final JLabel label;
    private final JLabel personNamesTitles;
    private final JToggleButton darkLightButton;
    private static final int WIDTH_DIMENSION = 350;
    private static final int HEIGHT_DIMENSION = 90;
    private static final int X_ABSOLUTE_POSITION = 0;
    private static final int Y_ABSOLUTE_POSITION = 190;
    private static final int TEXT_SIZE_ABSOLUTE = 40;

    public MenuPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(withdrawButton = createWithdrawButton());
        label.add(balanceButton = createBalanceButton());
        label.add(changePinButton = createChangePinButton());
        label.add(accountDetailsButton = createDetailsButton());
        label.add(depositButton = createDepositButton());
        label.add(transferButton = createTransferButton());
        label.add(transactionsButton = createTransactionButton());
        label.add(donationButton = createDonationButton());
        label.add(logOutButton = createLogOutButton());
        label.add(darkLightButton = createDarkModeButton());
        label.add(personNamesTitles = createTextPersonalNames());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }

    public JButton getWithdrawButton() {
        return withdrawButton;
    }

    public JButton getBalanceButton() {
        return balanceButton;
    }

    public JButton getChangePinButton() {
        return changePinButton;
    }

    public JButton getAccountDetailsButton() {
        return accountDetailsButton;
    }

    public JButton getDepositButton() {
        return depositButton;
    }

    public JButton getTransferButton() {
        return transferButton;
    }

    public JButton getTransactionsButton() {
        return transactionsButton;
    }

    public JButton getDonationButton() {
        return donationButton;
    }

    public JToggleButton getDarkModeButton() {
        return darkLightButton;
    }

    public JLabel getPersonNamesTitles() {
        return personNamesTitles;
    }

    private @NotNull JButton createWithdrawButton() {
        JButton withdrawButton = new JButton(IMG.withdrawButton);
        withdrawButton.setContentAreaFilled(false);
        withdrawButton.setBounds(X_ABSOLUTE_POSITION, Y_ABSOLUTE_POSITION, WIDTH_DIMENSION, HEIGHT_DIMENSION);
        withdrawButton.setBorder(null);
        return withdrawButton;
    }

    private @NotNull JButton createDepositButton() {
        JButton depositButton = new JButton(IMG.depositButton);
        depositButton.setContentAreaFilled(false);
        depositButton.setBounds(X_ABSOLUTE_POSITION + 1016, Y_ABSOLUTE_POSITION, WIDTH_DIMENSION, HEIGHT_DIMENSION);
        depositButton.setBorder(null);
        return depositButton;
    }

    private @NotNull JButton createBalanceButton() {
        JButton balanceButton = new JButton(IMG.balanceButton);
        balanceButton.setContentAreaFilled(false);
        balanceButton.setBounds(X_ABSOLUTE_POSITION, Y_ABSOLUTE_POSITION + 150, WIDTH_DIMENSION, HEIGHT_DIMENSION);
        balanceButton.setBorder(null);
        return balanceButton;
    }

    private @NotNull JButton createTransferButton() {
        JButton transferButton = new JButton(IMG.transferButton);
        transferButton.setContentAreaFilled(false);
        transferButton.setBounds(X_ABSOLUTE_POSITION + 1016, Y_ABSOLUTE_POSITION + 150, WIDTH_DIMENSION, HEIGHT_DIMENSION);
        transferButton.setBorder(null);
        return transferButton;
    }

    private @NotNull JButton createChangePinButton() {
        JButton changePinButton = new JButton(IMG.changePinButton);
        changePinButton.setContentAreaFilled(false);
        changePinButton.setBounds(X_ABSOLUTE_POSITION, Y_ABSOLUTE_POSITION + 300, WIDTH_DIMENSION, HEIGHT_DIMENSION);
        changePinButton.setBorder(null);
        return changePinButton;
    }

    private @NotNull JButton createTransactionButton() {
        JButton transactionsButton = new JButton(IMG.transactionsButton);
        transactionsButton.setContentAreaFilled(false);
        transactionsButton.setBounds(X_ABSOLUTE_POSITION + 1016, Y_ABSOLUTE_POSITION + 300, WIDTH_DIMENSION, HEIGHT_DIMENSION);
        transactionsButton.setBorder(null);
        return transactionsButton;
    }

    private @NotNull JButton createDetailsButton() {
        JButton accountDetailsButton = new JButton(IMG.accountDetailsButton);
        accountDetailsButton.setContentAreaFilled(false);
        accountDetailsButton.setBounds(X_ABSOLUTE_POSITION, Y_ABSOLUTE_POSITION + 450, WIDTH_DIMENSION, HEIGHT_DIMENSION);
        accountDetailsButton.setBorder(null);
        return accountDetailsButton;
    }

    private @NotNull JButton createDonationButton() {
        JButton donationButton = new JButton(IMG.donationButton);
        donationButton.setContentAreaFilled(false);
        donationButton.setBounds(X_ABSOLUTE_POSITION + 1016, Y_ABSOLUTE_POSITION + 450, WIDTH_DIMENSION, HEIGHT_DIMENSION);
        donationButton.setBorder(null);
        return donationButton;
    }

    private @NotNull JToggleButton createDarkModeButton() {
        JToggleButton darkModeButton = new JToggleButton(IMG.darkModeButton);
        darkModeButton.setBounds(X_ABSOLUTE_POSITION + 1300, Y_ABSOLUTE_POSITION - 180, WIDTH_DIMENSION - 290, HEIGHT_DIMENSION - 30);
        darkModeButton.setContentAreaFilled(false);
        darkModeButton.setBorder(null);
        return darkModeButton;
    }

    private @NotNull JButton createLogOutButton() {
        JButton logOutButton = new JButton(IMG.logoutButton);
        logOutButton.setContentAreaFilled(false);
        logOutButton.setBounds(X_ABSOLUTE_POSITION + 10, Y_ABSOLUTE_POSITION + 625, WIDTH_DIMENSION - 268, HEIGHT_DIMENSION - 8);
        logOutButton.setBorder(null);
        return logOutButton;
    }

    public JLabel createTextPersonalNames() {
        JLabel personBothNames = new JLabel();
        personBothNames.setBounds(X_ABSOLUTE_POSITION + 50, Y_ABSOLUTE_POSITION - 120, WIDTH_DIMENSION + 250, HEIGHT_DIMENSION - 40);
        personBothNames.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE));
        personBothNames.setForeground(Color.white);
        return personBothNames;
    }

    public void show() {
        withdrawButton.setVisible(true);
        balanceButton.setVisible(true);
        changePinButton.setVisible(true);
        accountDetailsButton.setVisible(true);
        accountDetailsButton.setVisible(true);
        depositButton.setVisible(true);
        transferButton.setVisible(true);
        transactionsButton.setVisible(true);
        donationButton.setVisible(true);
        logOutButton.setVisible(true);
        darkLightButton.setVisible(true);
        label.setVisible(true);
    }

    public void hide() {
        withdrawButton.setVisible(false);
        balanceButton.setVisible(false);
        changePinButton.setVisible(false);
        accountDetailsButton.setVisible(false);
        accountDetailsButton.setVisible(false);
        depositButton.setVisible(false);
        transferButton.setVisible(false);
        transactionsButton.setVisible(false);
        donationButton.setVisible(false);
        logOutButton.setVisible(false);
        darkLightButton.setVisible(false);
        label.setVisible(false);
    }
}
