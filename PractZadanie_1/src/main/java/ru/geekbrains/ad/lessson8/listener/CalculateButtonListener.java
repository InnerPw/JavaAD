package ru.geekbrains.ad.lessson8.listener;

import ru.geekbrains.ad.lessson8.ApplicationForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateButtonListener implements ActionListener {

    private JTextField inputField;

    private Double operand1;
    private Double operand2;
    private String operator;

    public CalculateButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Double result = addOperand(getLastInputNum());
        showResult(result);
        reset();
    }

    private void buttonOperatorCaltulate(String operator) {
        String inputStr = inputField.getText();
        if (String.valueOf(inputStr.charAt(inputStr.length() - 1)).matches("\\D")) {
            inputField.setText(inputStr.substring(0, inputStr.length() - 1) + operator);
            setOperator(operator);  //15:17
            return;
        }
        Double result = addOperand(getLastInputNum());
        if (result != null) {
            showResult(result, operator);
        } else {
            inputField.setText(inputStr + operator);
        }
        setOperator(operator);
    }

    public Double addOperand(String operand) {
        if (operand1 == null) {
            operand1 = Double.parseDouble(operand);
            return null;
        }
        operand2 = Double.parseDouble(operand);
        Double result = getResult();
        operand1 = result;
        return result;
    }

    public Double getResult() {
        Double result = calc(operand1, operand2, operator);
        reset();
        return result;
    }

    public Double getResult(String operand, String operator) {
        operand2 = Double.parseDouble(operand);
        Double result = calc(operand1, operand2, operator);
        reset();
        return result;
    }

    public void showResult(double result, String operator) {
        String resultStr = (result % 1 == 0) ? String.valueOf((int) result) : String.format("%.3f", result);
        if (operator != null) {
            resultStr += operator;
        }
        inputField.setText(resultStr);
    }

    public void showResult(double result) {
        showResult(result, null);
    }

    public void reset() {
        operand1 = operand2 = null;
        operator = null;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calc(double num1, double num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "x" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }

    public String getLastInputNum() {
        var arr = inputField.getText().split("[^0-9\\.]");
        return arr[arr.length - 1];
    }

}
