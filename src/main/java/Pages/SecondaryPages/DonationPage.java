package Pages.SecondaryPages;

import Images.IMG;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class DonationPage {
    private final JLabel label, selectedDonationText;
    private final JButton backButton;
    private final JButton donateButton;
    private final JTextField amountField;
    private final JToggleButton selectSeasButton, selectTreesButton, selectUnicefButton, selectWFFButton, selectHouseButton, selectRedCrossButton;
    private final JProgressBar progressBar;
    private final int X_DIMENSION_ABSOLUTE = 560;
    private final int Y_DIMENSION_ABSOLUTE = 80;
    private final int WIDTH_DIMENSION_ABSOLUTE = 50;
    private final int HEIGHT_DIMENSION_ABSOLUTE = 50;
    private final int TEXT_SIZE_ABSOLUTE = 40;

    public DonationPage() {
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(backButton = createBackButton());
        label.add(selectedDonationText = createCurrentOrganisationChosen());
        label.add(selectSeasButton = createSeasButton());
        label.add(selectTreesButton = createTreesButton());
        label.add(selectUnicefButton = createUnicefButton());
        label.add(selectWFFButton = createWFFButton());
        label.add(selectHouseButton = createHouseButton());
        label.add(selectRedCrossButton = createRedCrossButton());
        label.add(donateButton = createDonateButton());
        label.add(amountField = createAmountField());
        label.add(progressBar = creatingProgressBar());
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getDonateButton() {
        return donateButton;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    private @NotNull JButton createBackButton() {
        JButton backButton = new JButton(IMG.backButton);
        backButton.setContentAreaFilled(false);
        backButton.setBounds(X_DIMENSION_ABSOLUTE - 550, Y_DIMENSION_ABSOLUTE + 755, WIDTH_DIMENSION_ABSOLUTE + 7, HEIGHT_DIMENSION_ABSOLUTE);
        backButton.setBorder(null);
        backButton.addActionListener(e -> {
            amountField.setText("");
            selectedDonationText.setText("");
            selectSeasButton.setSelected(false);
            selectTreesButton.setSelected(false);
            selectRedCrossButton.setSelected(false);
            selectUnicefButton.setSelected(false);
            selectWFFButton.setSelected(false);
            selectHouseButton.setSelected(false);
        });
        return backButton;
    }

    private @NotNull JToggleButton createSeasButton() {
        JToggleButton seasButton = new JToggleButton(IMG.seasButton);
        seasButton.setBounds(X_DIMENSION_ABSOLUTE - 250, Y_DIMENSION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE + 150, HEIGHT_DIMENSION_ABSOLUTE + 150);
        seasButton.setContentAreaFilled(false);
        seasButton.setBorder(null);
        seasButton.addActionListener(e -> {
            if (seasButton.isSelected()) {
                selectedDonationText.setText("To Team Seas");
                selectTreesButton.setSelected(false);
                selectRedCrossButton.setSelected(false);
                selectUnicefButton.setSelected(false);
                selectWFFButton.setSelected(false);
                selectHouseButton.setSelected(false);
            }
        });
        return seasButton;
    }

    private @NotNull JToggleButton createTreesButton() {
        JToggleButton treesButton = new JToggleButton(IMG.treesButton);
        treesButton.setBounds(X_DIMENSION_ABSOLUTE, Y_DIMENSION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE + 150, HEIGHT_DIMENSION_ABSOLUTE + 150);
        treesButton.setContentAreaFilled(false);
        treesButton.setBorder(null);
        treesButton.addActionListener(e -> {
            if (treesButton.isSelected()) {
                selectedDonationText.setText("To Team Trees");
                selectSeasButton.setSelected(false);
                selectRedCrossButton.setSelected(false);
                selectUnicefButton.setSelected(false);
                selectWFFButton.setSelected(false);
                selectHouseButton.setSelected(false);
            }
        });
        return treesButton;
    }

    private @NotNull JToggleButton createRedCrossButton() {
        JToggleButton redCrossButton = new JToggleButton(IMG.redCrossButton);
        redCrossButton.setBounds(X_DIMENSION_ABSOLUTE + 250, Y_DIMENSION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE + 150, HEIGHT_DIMENSION_ABSOLUTE + 150);
        redCrossButton.setContentAreaFilled(false);
        redCrossButton.setBorder(null);
        redCrossButton.addActionListener(e -> {
            if (redCrossButton.isSelected()) {
                selectedDonationText.setText("To Red Cross");
                selectSeasButton.setSelected(false);
                selectTreesButton.setSelected(false);
                selectUnicefButton.setSelected(false);
                selectWFFButton.setSelected(false);
                selectHouseButton.setSelected(false);
            }

        });
        return redCrossButton;
    }

    private @NotNull JToggleButton createUnicefButton() {
        JToggleButton unicefButton = new JToggleButton(IMG.unicefButton);
        unicefButton.setBounds(X_DIMENSION_ABSOLUTE - 250, Y_DIMENSION_ABSOLUTE + 300, WIDTH_DIMENSION_ABSOLUTE + 150, HEIGHT_DIMENSION_ABSOLUTE + 159);
        unicefButton.setContentAreaFilled(false);
        unicefButton.setBorder(null);
        unicefButton.addActionListener(e -> {
            if (unicefButton.isSelected()) {
                selectedDonationText.setText("To UNICEF");
                selectSeasButton.setSelected(false);
                selectTreesButton.setSelected(false);
                selectRedCrossButton.setSelected(false);
                selectWFFButton.setSelected(false);
                selectHouseButton.setSelected(false);
            }
        });
        return unicefButton;
    }

    private @NotNull JToggleButton createWFFButton() {
        JToggleButton wffButton = new JToggleButton(IMG.WFFButton);
        wffButton.setBounds(X_DIMENSION_ABSOLUTE, Y_DIMENSION_ABSOLUTE + 300, WIDTH_DIMENSION_ABSOLUTE + 150, HEIGHT_DIMENSION_ABSOLUTE + 239);
        wffButton.setContentAreaFilled(false);
        wffButton.setBorder(null);
        wffButton.addActionListener(e -> {
            if (wffButton.isSelected()) {
                selectedDonationText.setText("To World Wildlife Fund");
                selectSeasButton.setSelected(false);
                selectTreesButton.setSelected(false);
                selectRedCrossButton.setSelected(false);
                selectUnicefButton.setSelected(false);
                selectHouseButton.setSelected(false);
            }
        });
        return wffButton;
    }

    private @NotNull JToggleButton createHouseButton() {
        JToggleButton houseButton = new JToggleButton(IMG.houseButton);
        houseButton.setBounds(X_DIMENSION_ABSOLUTE + 250, Y_DIMENSION_ABSOLUTE + 300, WIDTH_DIMENSION_ABSOLUTE + 200, HEIGHT_DIMENSION_ABSOLUTE + 106);
        houseButton.setContentAreaFilled(false);
        houseButton.setBorder(null);
        houseButton.addActionListener(e -> {
            if (houseButton.isSelected()) {
                selectedDonationText.setText("To Habitat for Humanity");
                selectSeasButton.setSelected(false);
                selectTreesButton.setSelected(false);
                selectRedCrossButton.setSelected(false);
                selectUnicefButton.setSelected(false);
                selectWFFButton.setSelected(false);
            }
        });
        return houseButton;
    }

    private @NotNull JButton createDonateButton() {
        JButton donateButton = new JButton(IMG.donateButton);
        donateButton.setContentAreaFilled(false);
        donateButton.setBounds(X_DIMENSION_ABSOLUTE - 140, Y_DIMENSION_ABSOLUTE + 720, WIDTH_DIMENSION_ABSOLUTE + 154, HEIGHT_DIMENSION_ABSOLUTE + 13);
        donateButton.setBorder(null);
        return donateButton;
    }

    private @NotNull JTextField createAmountField() {
        JTextField amountField = new JTextField();
        amountField.setBounds(X_DIMENSION_ABSOLUTE, Y_DIMENSION_ABSOLUTE + 665, WIDTH_DIMENSION_ABSOLUTE + 150, HEIGHT_DIMENSION_ABSOLUTE - 25);
        amountField.setBorder(null);
        amountField.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE - 20));
        return amountField;
    }

    public JLabel createCurrentOrganisationChosen() {
        JLabel chosenDonation = new JLabel();
        chosenDonation.setBounds(X_DIMENSION_ABSOLUTE + 70, Y_DIMENSION_ABSOLUTE + 732, WIDTH_DIMENSION_ABSOLUTE + 550, HEIGHT_DIMENSION_ABSOLUTE);
        chosenDonation.setFont(new Font("Bahnschrift", Font.BOLD, TEXT_SIZE_ABSOLUTE));
        chosenDonation.setForeground(Color.white);
        return chosenDonation;
    }

    private @NotNull JProgressBar creatingProgressBar() {
        JProgressBar progressBarOriginal = new JProgressBar(0, 100);
        progressBarOriginal.setBounds(X_DIMENSION_ABSOLUTE - 560, Y_DIMENSION_ABSOLUTE - 80, WIDTH_DIMENSION_ABSOLUTE + 1316, HEIGHT_DIMENSION_ABSOLUTE - 15);
        progressBarOriginal.setStringPainted(true);
        progressBarOriginal.setForeground(new Color(56, 157, 14));
        progressBarOriginal.setBackground(Color.white);
        progressBarOriginal.setFont((new Font("Bahnschrift", Font.BOLD, 20)));
        progressBarOriginal.setBorder(null);
        progressBarOriginal.setVisible(false);
        return progressBarOriginal;
    }

    public void hide() {
        backButton.setVisible(false);
        selectSeasButton.setVisible(false);
        selectTreesButton.setVisible(false);
        selectUnicefButton.setVisible(false);
        selectWFFButton.setVisible(false);
        selectHouseButton.setVisible(false);
        selectRedCrossButton.setVisible(false);
        donateButton.setVisible(false);
        progressBar.setVisible(false);
        disableButtons();
        label.setVisible(false);
    }

    private void disableButtons() {
        selectSeasButton.setSelected(false);
        selectTreesButton.setSelected(false);
        selectRedCrossButton.setSelected(false);
        selectUnicefButton.setSelected(false);
        selectWFFButton.setSelected(false);
        selectHouseButton.setSelected(false);
        selectedDonationText.setText("");
    }

    public void show() {
        backButton.setVisible(true);
        selectSeasButton.setVisible(true);
        selectTreesButton.setVisible(true);
        selectUnicefButton.setVisible(true);
        selectWFFButton.setVisible(true);
        selectHouseButton.setVisible(true);
        selectRedCrossButton.setVisible(true);
        donateButton.setVisible(true);
        label.setVisible(true);
    }

    public boolean isValidDeposit() {
        boolean isAmountFieldValid = amountField.getText().matches("\\d*.?\\d+") && !amountField.getText().contains("\\s+");
        boolean isAnyButtonSelected = selectSeasButton.isSelected() || selectTreesButton.isSelected() || selectUnicefButton.isSelected() || selectWFFButton.isSelected() || selectHouseButton.isSelected() || selectRedCrossButton.isSelected();
        if (isAmountFieldValid) {
            if (isAnyButtonSelected) {
                progressBar.setValue(0);
                progressBar.setVisible(true);
                int i = 0;
                try {
                    while (i <= 100) {
                        Thread.sleep(25);
                        progressBar.paintImmediately(0, 0, 1366, 35);
                        progressBar.setValue(i);
                        i++;
                    }
                } catch (Exception e1) {
                    System.out.print("Exception is =" + e1);
                }
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No organisation was selected", "Invalid operation", JOptionPane.INFORMATION_MESSAGE);
                amountField.setText("");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "The amount you tried to enter is invalid. Make sure you are writing digits only.", "Invalid amount", JOptionPane.ERROR_MESSAGE);
            amountField.setText("");
            return false;
        }
    }
}
