package ru.geekbrains.ad.lessson8.listener;

import ru.geekbrains.ad.lessson8.ApplicationForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinusButtonListener implements ActionListener {

    private JTextField inputField;

    public MinusButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        inputField.setText(inputField.getText() + " " + btn.getText());
    }
}
