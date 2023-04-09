package Controller;

import Images.IMG;
import Pages.MainPages.LoginPage;
import Pages.MainPages.MenuPage;
import Pages.MainPages.RegisterPage;
import Pages.MainPages.StartPage;
import MainFrame.myFrame;
import Pages.SecondaryPages.*;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class controller {
    private final StartPage startPage;
    private final LoginPage loginPage;
    private final RegisterPage registerPage;
    private final MenuPage menuPage;
    private final ChangePinPage changePinPage;
    private final DepositPage depositPage;
    private final WithdrawPage withdrawPage;
    private final BalancePage balancePage;
    private final AccountDetailsPage accountDetailsPage;
    private final DonationPage donationPage;
    private final TransferPage transferPage;
    private final TransactionsPage transactionsPage;
    private JToggleButton darkModeButton;
    private final myFrame myFrame;

    public controller() throws IOException {
        new IMG();
        myFrame = new myFrame();
        startPage = new StartPage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        menuPage = new MenuPage();
        changePinPage = new ChangePinPage();
        depositPage = new DepositPage();
        withdrawPage = new WithdrawPage();
        balancePage = new BalancePage();
        accountDetailsPage = new AccountDetailsPage();
        donationPage = new DonationPage();
        transferPage = new TransferPage();
        transactionsPage = new TransactionsPage();

        JPanel panel = new JPanel();
        myFrame.getFrame().add(panel);

        panel.add(startPage.getLabel());
        panel.add(loginPage.getLabel());
        panel.add(registerPage.getLabel());
        panel.add(menuPage.getLabel());
        panel.add(changePinPage.getLabel());
        panel.add(depositPage.getLabel());
        panel.add(withdrawPage.getLabel());
        panel.add(balancePage.getLabel());
        panel.add(accountDetailsPage.getLabel());
        panel.add(donationPage.getLabel());
        panel.add(transferPage.getLabel());
        panel.add(transactionsPage.getLabel());
        myFrame.topLineRefresh();
        hideAllSmallPages();

        startPageButtonsControls();
        loginPageButtonsControls();
        registerPageButtonsControls();
        menuPageButtonsControls();
        withdrawPageButtonsControls();
        depositPageButtonsControls();
        balancePageButtonsControls();
        transferPageButtonsControls();
        changePINPageButtonsControls();
        transactionsPageButtonsControls();
        accountDetailsButtonsControls();
        donationPageButtonsControls();
        darkModeButtonControls();
    }

    private void startPageButtonsControls() {
        JButton loginButton = startPage.getLoginButton();
        loginButton.addActionListener(e -> {
            myFrame.topLineRefresh();
            registerPage.hide();
            startPage.hide();
            loginPage.show();
        });

        JButton registerButton = startPage.getRegisterButton();
        registerButton.addActionListener(e -> {
            myFrame.topLineRefresh();
            loginPage.hide();
            startPage.hide();
            registerPage.show();
        });
    }

    private void loginPageButtonsControls() {
        JButton loginButton = loginPage.getLoginButton();
        loginButton.addActionListener(e -> {
            if (loginPage.loginIsValid()) {
                Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
                myFrame.topLineRefresh();
                loginPage.hide();
                assert document != null;
                menuPage.getPersonNamesTitles().setText(document.get("First Name") + " " + document.get("Last Name"));
                menuPage.show();
            }
        });

        JButton backButton = loginPage.getBackButton();
        backButton.addActionListener(e -> startPage.show());
    }

    private void registerPageButtonsControls() {
        JButton registerButton = registerPage.getRegisterButton();
        registerButton.addActionListener(e -> {
            if (registerPage.registerSuccessful()) {
                myFrame.topLineRefresh();
                registerPage.hide();
                loginPage.show();
            }
        });

        JButton backButton = registerPage.getBackButton();
        backButton.addActionListener(e -> {
            myFrame.topLineRefresh();
            startPage.show();
        });
    }

    private void menuPageButtonsControls() {
        JButton logoutButton = menuPage.getLogOutButton();
        logoutButton.addActionListener(e -> {
            myFrame.topLineRefresh();
            menuPage.hide();
            registerPage.hide();
            loginPage.hide();
            if (darkModeButton.isSelected()) {
                loginPage.getLabel().setIcon(IMG.darkBackground);
                registerPage.getLabel().setIcon(IMG.darkBackground);
                startPage.getLabel().setIcon(IMG.darkBackground);
            } else {
                loginPage.getLabel().setIcon(IMG.defaultBackground);
                registerPage.getLabel().setIcon(IMG.defaultBackground);
                startPage.getLabel().setIcon(IMG.defaultBackground);
            }
            startPage.show();
        });

        JButton withdrawButton = menuPage.getWithdrawButton();
        withdrawButton.addActionListener(a -> {
            myFrame.topLineRefresh();
            menuPage.hide();
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            assert document != null;
            withdrawPage.getCurrentBalance().setText(String.format("Current balance $%.2f", Double.parseDouble(document.get("Wallet").toString())));
            withdrawPage.show();
        });

        JButton depositButton = menuPage.getDepositButton();
        depositButton.addActionListener(a -> {
            myFrame.topLineRefresh();
            menuPage.hide();
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            assert document != null;
            depositPage.getCurrentBalance().setText(String.format("Current balance $%.2f", Double.parseDouble(document.get("Wallet").toString())));
            depositPage.show();
        });

        JButton balanceButton = menuPage.getBalanceButton();
        balanceButton.addActionListener(a -> {
            myFrame.topLineRefresh();
            menuPage.hide();
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            assert document != null;
            balancePage.getCurrentBalance().setText(String.format("Current balance $%.2f", Double.parseDouble(document.get("Wallet").toString())));
            balancePage.show();
        });

        JButton transferButton = menuPage.getTransferButton();
        transferButton.addActionListener(a -> {
            myFrame.topLineRefresh();
            menuPage.hide();
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            assert document != null;
            transferPage.getCurrentBalance().setText(String.format("Current balance $%.2f", Double.parseDouble(document.get("Wallet").toString())));
            transferPage.show();
        });

        JButton transactionsButton = menuPage.getTransactionsButton();
        transactionsButton.addActionListener(a -> {
            myFrame.topLineRefresh();
            menuPage.hide();
            List<String> transactionList;
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            assert document != null;
            transactionList = document.getList("Transactions", String.class);
            Collections.reverse(transactionList);
            StringBuilder transactionsSB = new StringBuilder("<html>");
            int amountToDisplay = Math.min(15, transactionList.size());
            for (int i = 0; i < amountToDisplay; i++) {
                transactionsSB.append(transactionList.get(i)).append("<br>");
            }
            transactionsSB.append("</html>");
            transactionsPage.getHistoryText().setText(transactionsSB.toString());
            transactionsPage.show();
        });

        JButton accountDetailsButton = menuPage.getAccountDetailsButton();
        accountDetailsButton.addActionListener(a -> {
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            myFrame.topLineRefresh();
            menuPage.hide();
            assert document != null;
            accountDetailsPage.getBothNames().setText(String.format("%S %S", document.get("First Name"), document.get("Last Name")));
            accountDetailsPage.getCardNumberText().setText(document.get("Card Number").toString());
            accountDetailsPage.getCvvText().setText(String.format("CVV: %s", document.get("CVV").toString()));
            accountDetailsPage.getFirstNameText().setText(String.format("Name: %s", document.get("First Name")));
            accountDetailsPage.getLastNameText().setText(String.format("Surname: %s", document.get("Last Name")));
            accountDetailsPage.getEmailText().setText(String.format("Email: %s", document.get("Email")));
            accountDetailsPage.getDobText().setText(String.format("Birth date: %s", document.get("DOB")));
            accountDetailsPage.getIbanText().setText(String.format("IBAN: %s", document.get("IBAN")));
            accountDetailsPage.show();
        });

        JButton donationButton = menuPage.getDonationButton();
        donationButton.addActionListener(a -> {
            myFrame.topLineRefresh();
            menuPage.hide();
            donationPage.show();
        });

        JButton changePinButton = menuPage.getChangePinButton();
        changePinButton.addActionListener(a -> {
            myFrame.topLineRefresh();
            menuPage.hide();
            changePinPage.show();
        });
    }

    private void withdrawPageButtonsControls() {
        JButton okButton = withdrawPage.getOkButton();
        okButton.addActionListener(e -> {
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            if (e.getSource() == okButton) {
                if (withdrawPage.isValidDeposit()) {
                    assert document != null;
                    double walletAmount = Double.parseDouble(document.get("Wallet").toString());
                    double amountToWithdraw = Double.parseDouble(withdrawPage.getAmountField().getText());
                    double total = walletAmount - amountToWithdraw;
                    if (total < 0) {
                        JOptionPane.showMessageDialog(null, "Not enough funds", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        LocalDateTime localDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        Document addToHistory = new Document("$push", new Document("Transactions", String.format("Withdraw: -%.2f$ %s", amountToWithdraw, localDateTime.format(formatter))));
                        StartPage.collection.updateOne(document, addToHistory);
                        Document document2 = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
                        assert document2 != null;
                        StartPage.collection.updateOne(document2, (new Document("$set", new Document("Wallet", String.valueOf(total)))));
                        JOptionPane.showMessageDialog(null, "The operation was successful.", "Operation successful !", JOptionPane.PLAIN_MESSAGE);
                    }
                    withdrawPage.getAmountField().setText("");
                    myFrame.topLineRefresh();
                    withdrawPage.hide();
                    menuPage.show();
                }
            }
        });

        JButton cancelButtonWithdrawPage = withdrawPage.getCancelButton();
        cancelButtonWithdrawPage.addActionListener(a -> {
            myFrame.topLineRefresh();
            withdrawPage.hide();
            menuPage.show();
        });
    }

    private void depositPageButtonsControls() {
        JButton okButton = depositPage.getOkButton();
        okButton.addActionListener(e -> {
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            if (e.getSource() == okButton) {
                if (depositPage.isValidDeposit()) {
                    assert document != null;
                    double walletAmount = Double.parseDouble(document.get("Wallet").toString());
                    double amountToDeposit = Double.parseDouble(depositPage.getAmountField().getText());
                    double total = walletAmount + amountToDeposit;
                    StartPage.collection.updateOne(document, (new Document("$set", new Document("Wallet", String.valueOf(total)))));
                    JOptionPane.showMessageDialog(null, "Thank you for your deposit. The operation was successful.", "Operation successful !", JOptionPane.PLAIN_MESSAGE);
                    LocalDateTime localDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    Document document2 = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
                    Document addToHistory = new Document("$push", new Document("Transactions", String.format("Deposit: +%.2f$ %s", amountToDeposit, localDateTime.format(formatter))));
                    assert document2 != null;
                    StartPage.collection.updateOne(document2, addToHistory);
                    depositPage.getAmountField().setText("");
                    myFrame.topLineRefresh();
                    depositPage.hide();
                    menuPage.show();
                }
            }

        });

        JButton cancelButtonDepositPage = depositPage.getCancelButton();
        cancelButtonDepositPage.addActionListener(a -> {
            myFrame.topLineRefresh();
            depositPage.hide();
            menuPage.show();
        });
    }

    private void balancePageButtonsControls() {
        JButton backButton3 = balancePage.getBackButton();
        backButton3.addActionListener(e -> {
            myFrame.topLineRefresh();
            balancePage.hide();
            menuPage.show();
        });
    }

    private void transferPageButtonsControls() {
        JButton backButton1 = transferPage.getCancelButton();
        backButton1.addActionListener(e -> {
            myFrame.topLineRefresh();
            transferPage.hide();
            menuPage.show();
        });

        JButton okButton = transferPage.getOkButton();
        okButton.addActionListener(e -> {
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            if (e.getSource() == okButton) {
                if (transferPage.isValidTransfer()) {
                    assert document != null;
                    double walletAmount = Double.parseDouble(document.get("Wallet").toString());
                    double amountToTransfer = Double.parseDouble(transferPage.getAmountField().getText());
                    double total = walletAmount - amountToTransfer;
                    if (total < 0) {
                        JOptionPane.showMessageDialog(null, "Not enough funds", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        LocalDateTime localDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        Document addToHistory = new Document("$push", new Document("Transactions", String.format("Transfer: -%.2f$ %s", amountToTransfer, localDateTime.format(formatter))));
                        StartPage.collection.updateOne(document, addToHistory);
                        Document document2 = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
                        assert document2 != null;
                        StartPage.collection.updateOne(document2, (new Document("$set", new Document("Wallet", String.valueOf(total)))));
                        JOptionPane.showMessageDialog(null, "The operation was successful.", "Operation successful !", JOptionPane.PLAIN_MESSAGE);
                    }
                    transferPage.getAmountField().setText("");
                    myFrame.topLineRefresh();
                    transferPage.hide();
                    menuPage.show();
                }
            }
        });
    }

    private void changePINPageButtonsControls() {
        JButton cancelButtonPinPage = changePinPage.getCancelButton();
        cancelButtonPinPage.addActionListener(a -> {
            myFrame.topLineRefresh();
            changePinPage.hide();
            menuPage.show();
        });

        JButton submitButtonPinPage = changePinPage.getSubmitButton();
        submitButtonPinPage.addActionListener(a -> {
            if (changePinPage.isPINValid()) {
                Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
                assert document != null;
                BCrypt.Result result = BCrypt.verifyer().verify(changePinPage.getOldPIN().toCharArray(), document.get("PIN").toString());
                if (result.verified) {
                    String bcryptHashString = BCrypt.withDefaults().hashToString(12, changePinPage.getNewPIN().toCharArray());
                    StartPage.collection.updateOne(document, (new Document("$set", new Document("PIN", bcryptHashString))));
                    JOptionPane.showMessageDialog(null, "The PIN has been changed successfully", "Successful Operation", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid fields", "Invalid inputs", JOptionPane.PLAIN_MESSAGE);
                }
            }
            myFrame.topLineRefresh();
            changePinPage.hide();
            menuPage.show();
        });
    }

    private void transactionsPageButtonsControls() {
        JButton backButtonTransactionPage = transactionsPage.getBackButton();
        backButtonTransactionPage.addActionListener(e -> {
            myFrame.topLineRefresh();
            transactionsPage.hide();
            menuPage.show();
        });
    }

    private void accountDetailsButtonsControls() {
        JButton backButtonAccountDetailsPage = accountDetailsPage.getBackButton();
        backButtonAccountDetailsPage.addActionListener(a -> {
            myFrame.topLineRefresh();
            accountDetailsPage.hide();
            menuPage.show();
        });

        JButton deleteAccountButton = accountDetailsPage.getDeleteButton();
        deleteAccountButton.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(null, "Do you really want to delete your account ?", "Delete Account", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
                assert document != null;
                StartPage.collection.deleteOne(document);
                myFrame.topLineRefresh();
                accountDetailsPage.hide();
                startPage.show();
            }

        });
    }

    private void donationPageButtonsControls() {
        JButton backButton = donationPage.getBackButton();
        backButton.addActionListener(e -> {
            myFrame.topLineRefresh();
            donationPage.hide();
            menuPage.show();
        });
        JButton donateButton = donationPage.getDonateButton();
        donateButton.addActionListener(e -> {
            Document document = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
            if (e.getSource() == donateButton) {
                if (donationPage.isValidDeposit()) {
                    assert document != null;
                    double walletAmount = Double.parseDouble(document.get("Wallet").toString());
                    double amountToWithdraw = Double.parseDouble(donationPage.getAmountField().getText());
                    double total = walletAmount - amountToWithdraw;
                    if (total < 0) {
                        JOptionPane.showMessageDialog(null, "Not enough funds", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        StartPage.collection.updateOne(document, (new Document("$set", new Document("Wallet", String.valueOf(total)))));
                        JOptionPane.showMessageDialog(null, "The operation was successful.", "Operation successful!", JOptionPane.PLAIN_MESSAGE);
                        LocalDateTime localDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        Document addToHistory = new Document("$push", new Document("Transactions", String.format("Donation: -%.2f$ %s", amountToWithdraw, localDateTime.format(formatter))));
                        Document updateTheDocument = StartPage.collection.find(Filters.eq("Email", loginPage.getEmailLoggedPerson())).first();
                        assert updateTheDocument != null;
                        StartPage.collection.updateOne(updateTheDocument, addToHistory);
                    }
                    donationPage.getAmountField().setText("");
                    myFrame.topLineRefresh();
                    donationPage.hide();
                    menuPage.show();
                }
            }
        });
    }

    private void darkModeButtonControls() {
        darkModeButton = menuPage.getDarkModeButton();
        darkModeButton.addActionListener(a -> {
            myFrame.topLineRefresh();
            if (darkModeButton.isSelected()) {
                changePinPage.getLabel().setIcon(IMG.darkBackground);
                depositPage.getLabel().setIcon(IMG.darkBackground);
                withdrawPage.getLabel().setIcon(IMG.darkBackground);
                balancePage.getLabel().setIcon(IMG.darkBackground);
                accountDetailsPage.getLabel().setIcon(IMG.darkBackground);
                donationPage.getLabel().setIcon(IMG.darkBackground);
                transferPage.getLabel().setIcon(IMG.darkBackground);
                transactionsPage.getLabel().setIcon(IMG.darkBackground);
                menuPage.getLabel().setIcon(IMG.darkBackground);
            } else {
                changePinPage.getLabel().setIcon(IMG.defaultBackground);
                depositPage.getLabel().setIcon(IMG.defaultBackground);
                withdrawPage.getLabel().setIcon(IMG.defaultBackground);
                balancePage.getLabel().setIcon(IMG.defaultBackground);
                accountDetailsPage.getLabel().setIcon(IMG.defaultBackground);
                donationPage.getLabel().setIcon(IMG.defaultBackground);
                transferPage.getLabel().setIcon(IMG.defaultBackground);
                transactionsPage.getLabel().setIcon(IMG.defaultBackground);
                menuPage.getLabel().setIcon(IMG.defaultBackground);
            }
        });
    }

    private void hideAllSmallPages() {
        changePinPage.hide();
        depositPage.hide();
        withdrawPage.hide();
        balancePage.hide();
        accountDetailsPage.hide();
        donationPage.hide();
        transferPage.hide();
        transactionsPage.hide();
    }
}

