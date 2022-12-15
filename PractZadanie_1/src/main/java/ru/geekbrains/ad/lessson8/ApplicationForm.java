package ru.geekbrains.ad.lessson8;

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

        return null;
    }

    private JPanel createCenterPanel() {    //центральная панель для кнопок с цифрами и операторами
        JPanel centerPanel = new JPanel();  //создается элемент класса для центральной панели
        centerPanel.setLayout(new BorderLayout()); //подключается компоновщик элементов в рамках панели

        centerPanel.add(createDigitsPanel(), BorderLayout.CENTER);  //создается внутренняя панель для цифр
        centerPanel.add(createOperatorsPanel(), BorderLayout.WEST); //создается внутренняя панель для операторов

        return centerPanel;
    }

    private JPanel createDigitsPanel() {
        return null;
    }

    private JPanel createOperatorsPanel() {
        return null;
    }
}
