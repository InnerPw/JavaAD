package ru.geekbrains.ad.lessson8.listener;

import ru.geekbrains.ad.lessson8.ApplicationForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField inputField;
    private int operator; // (1 -> +), (2 -> -), (3 -> x), (4 -> /)
    private int firstNumber;
    private int secondNumber;


    private String text = new String();

    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        text = inputField.getText();
        if (text.equals("+") || text.equals(" -") || text.equals(" x") || text.equals(" /")) {
            inputField.setText(btn.getText());
        } else {
            inputField.setText(inputField.getText() + btn.getText());
        }

    }
}
