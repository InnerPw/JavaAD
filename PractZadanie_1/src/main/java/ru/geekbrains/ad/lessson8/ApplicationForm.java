package ru.geekbrains.ad.lessson8;

import ru.geekbrains.ad.lessson8.components.DigitJButton;
import ru.geekbrains.ad.lessson8.components.OperatorJButton;

import javax.swing.*;
import java.awt.*;

public class ApplicationForm extends JFrame {

    public ApplicationForm(String title) {
        super(title);
        setBounds(700,400,250,370); //положение и размер окна
        setDefaultCloseOperation(EXIT_ON_CLOSE); //реакция на закрытие приложения
        setAlwaysOnTop(true); //окно появляется поверх остальных

        setJMenuBar(createMenu());

        setLayout(new BorderLayout()); //компоновщик элементов в окне

        //add(new Button("Кнопка"), BorderLayout.EAST); //создается кнопка и указывается её расположение с помощью компоновщика
        // add(new Button("Кнопка"), BorderLayout.WEST);

        add(createTopPanel(), BorderLayout.NORTH);

        add(createCenterPanel(), BorderLayout.CENTER);

        setVisible(true);
    }



    private JMenuBar createMenu() {         //верхнее меню
        JMenuBar menuBar = new JMenuBar();   //создается общая строка меню

        JMenu menuFile = new JMenu("File"); //создание пункта меню File
        menuBar.add(menuFile);                 //меню File добавляется в общее меню menuBar
        menuFile.add(new JMenuItem("Clear")); //создание подпункта Clear для меню File
        menuFile.add(new JMenuItem("Exit"));

        menuBar.add(new JMenuItem("Help")); //создание пункта меню более быстрым способом
        menuBar.add(new JMenuItem("About"));
        menuBar.add(new JMenuItem("Exit"));

        return menuBar;
    }

    private JPanel createTopPanel() {   //верхняя панель для ввода
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);

        inputField.setFont(new Font("Arial",Font.PLAIN,25));
        inputField.setMargin(new Insets(8,0,8,0));
        inputField.setBackground(new Color(157, 199, 136));

        inputField.setText("(1 + 2) / 3 = 1");

        return top;
    }

    private JPanel createCenterPanel() {    //центральная панель для кнопок с цифрами и операторами
        JPanel centerPanel = new JPanel();  //создается элемент класса для центральной панели
        centerPanel.setLayout(new BorderLayout()); //подключается компоновщик элементов в рамках панели

        centerPanel.add(createDigitsPanel(), BorderLayout.CENTER);  //создается внутренняя панель для цифр
        centerPanel.add(createOperatorsPanel(), BorderLayout.WEST); //создается внутренняя панель для операторов

        return centerPanel;
    }

    private JPanel createDigitsPanel() {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1); //если i равно 9, то вместо 9 добавляется 0
            JButton btn = new DigitJButton(buttonTitle);
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJButton("=");
        digitsPanel.add(calc);
        calc.setEnabled(false);

        JButton clear = new OperatorJButton("C");
        digitsPanel.add(clear);

        return digitsPanel;
    }

    private JPanel createOperatorsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        JButton minus = new OperatorJButton("-");
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        panel.add(plus);

        JButton multiply = new OperatorJButton("x");
        panel.add(multiply);

        JButton divide = new OperatorJButton("/");
        panel.add(divide);

        return panel;
    }
}
