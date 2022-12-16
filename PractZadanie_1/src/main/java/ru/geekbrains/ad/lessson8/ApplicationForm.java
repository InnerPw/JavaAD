package ru.geekbrains.ad.lessson8;

import ru.geekbrains.ad.lessson8.components.DigitJButton;
import ru.geekbrains.ad.lessson8.components.OperatorJButton;
import ru.geekbrains.ad.lessson8.listener.ButtonListener;
import ru.geekbrains.ad.lessson8.listener.ClearFieldButtonListener;
import ru.geekbrains.ad.lessson8.listener.PlusButtonListener;
import ru.geekbrains.ad.lessson8.listener.MinusButtonListener;
import ru.geekbrains.ad.lessson8.listener.MultiplyButtonListener;
import ru.geekbrains.ad.lessson8.listener.DivideButtonListener;
import ru.geekbrains.ad.lessson8.listener.CalculateButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;

//    private Double operand1;
//    private Double operand2;
//    private String operator;


    public ApplicationForm(String title) {
        super(title);
        setBounds(700,400,250,370); //положение и размер окна
        setDefaultCloseOperation(EXIT_ON_CLOSE); //реакция на закрытие приложения
        setAlwaysOnTop(true); //окно появляется поверх остальных

        setLayout(new BorderLayout()); //компоновщик элементов в окне

        //add(new Button("Кнопка"), BorderLayout.EAST); //создается кнопка и указывается её расположение с помощью компоновщика
        //add(new Button("Кнопка"), BorderLayout.WEST);

        add(createTopPanel(), BorderLayout.NORTH);

        setJMenuBar(createMenu());

        add(createCenterPanel(), BorderLayout.CENTER);

        setVisible(true);
    }



    private JMenuBar createMenu() {         //верхнее меню
        JMenuBar menuBar = new JMenuBar();   //создается общая строка меню

        JMenu menuFile = new JMenu("File"); //создание пункта меню File
        JMenuItem clear = new JMenuItem("Clear");   //создание подпункта Clear для меню File - ДЕЙСТВУЮЩИЙ
        clear.addActionListener(new ClearFieldButtonListener(inputField)); //
        menuFile.add(clear);

        //menuFile.add(new JMenuItem("Exit")); //создание подпункта Exit для меню File
        menuBar.add(menuFile);                 //меню File добавляется в общее меню menuBar

        menuBar.add(new JMenuItem("Help")); //создание пункта меню более быстрым способом
        menuBar.add(new JMenuItem("About"));


        //menuBar.add(new JMenuItem("Exit"));
        JMenuItem exit = new JMenuItem("Exit");
//        exit.addActionListener(new ActionListener() { //ActionListener создается прямо здесь как АНОНИМНЫЙ КЛАСС
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
        // Либо как вариант одной строкой
        exit.addActionListener(e -> System.exit(0)); //создается как ЛЯМБДА-ВЫРАЖЕНИЕ
        menuBar.add(exit);  //пункт Exit добавлен в общее меню
        menuFile.add(exit); //подпункт Exit добавлен и работает из меню File



        return menuBar;
    }

    private JPanel createTopPanel() {   //верхняя панель для ввода
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);

        inputField.setFont(new Font("Arial",Font.PLAIN,25));
        inputField.setMargin(new Insets(8,0,8,0));
        inputField.setBackground(new Color(157, 199, 136));

        //inputField.setText("(1 + 2) / 3 = 1");

        return top;
    }

    private JPanel createCenterPanel() {    //центральная панель для кнопок с цифрами и операторами
        JPanel centerPanel = new JPanel();  //создается элемент класса для центральной панели
        centerPanel.setLayout(new BorderLayout()); //подключается компоновщик элементов в рамках панели

        ActionListener buttonListener = new ButtonListener(inputField);

        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);  //создается внутренняя панель для цифр
        centerPanel.add(createOperatorsPanel(buttonListener), BorderLayout.WEST); //создается внутренняя панель для операторов

        return centerPanel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1); //если i равно 9, то вместо 9 добавляется 0
            JButton btn = new DigitJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJButton("=");
        calc.addActionListener(new CalculateButtonListener(inputField));
        digitsPanel.add(calc);
        calc.setEnabled(true);

        JButton clear = new OperatorJButton("C");
        clear.addActionListener(new ClearFieldButtonListener(inputField));
        digitsPanel.add(clear);

        return digitsPanel;
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(new MinusButtonListener(inputField));
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(new PlusButtonListener(inputField));
        panel.add(plus);

        JButton multiply = new OperatorJButton("x");
        multiply.addActionListener(new MultiplyButtonListener(inputField));
        panel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(new DivideButtonListener(inputField));
        panel.add(divide);

        return panel;
    }

//    public Double addOperand(String operand) {
//        if (operand1 == null) {
//            operand1 = Double.parseDouble(operand);
//            return null;
//        }
//        operand2 = Double.parseDouble(operand);
//        Double result = getResult();
//        operand1 = result;
//        return result;
//    }
//
//    public Double getResult() {
//        Double result = calc(operand1, operand2, operator);
//        reset();
//        return result;
//    }
//
//    public Double getResult(String operand, String operator) {
//        operand2 = Double.parseDouble(operand);
//        Double result = calc(operand1, operand2, operator);
//        reset();
//        return result;
//    }
//
//    public void showResult(double result, String operator) {
//        String resultStr = (result % 1 == 0) ? String.valueOf((int) result) : String.format("%.3f", result);
//        if (operator != null) {
//            resultStr += operator;
//        }
//        inputField.setText(resultStr);
//    }
//
//    public void reset() {
//        operand1 = operand2 = null;
//        operator = null;
//    }
//
//    public void setOperator(String operator) {
//        this.operator = operator;
//    }
//
//    public double calc(double num1, double num2, String operator) {
//        return switch (operator) {
//            case "+" -> num1 + num2;
//            case "-" -> num1 - num2;
//            case "x" -> num1 * num2;
//            case "/" -> num1 / num2;
//            default -> 0;
//        };
//    }
//
//    public String getLastInputNum() {
//        var arr = inputField.getText().split("[^0-9\\.]");
//        return arr[arr.length - 1];
//    }


    public JTextField getInputField() {
        return inputField;
    }
}
