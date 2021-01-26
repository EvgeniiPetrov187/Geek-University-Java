package Lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    private final JTextField text;
    private char operation;
    private double tempNumber = 0;
    private boolean firstDigit = true;

    public MyWindow(){
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 170, 300);

        JPanel jPanel = new JPanel();

        text = new JTextField(13);
        text.setEditable(false);
        jPanel.add(text);

        JButton[] digits = new JButton[10]; // кнопки цифр
        for (int i = 1; i < digits.length; i++){
            digits[i] = new JButton("" + i);
            digits[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Action(e);
                }
            });
            jPanel.add(digits[i]);
        }

        JButton zero = new JButton("0"); // кнопка ноль
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Action(e);
            }
        });
        jPanel.add(zero);

        JButton[] otherButtons = new JButton[6]; // математические действия
        otherButtons[0] = new JButton("+");
        otherButtons[1] = new JButton("-");
        otherButtons[2] = new JButton("*");
        otherButtons[3] = new JButton("/");
        otherButtons[4] = new JButton("."); // 2) Добавить написание точки
        otherButtons[5] = new JButton("^2"); // *4) Добавить возведение в квадрат
        for (int i = 0; i < otherButtons.length; i++) {
            otherButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ActionMath(e);
                }
            });
            jPanel.add(otherButtons[i]);
        }

        JButton equals = new JButton("="); // кнопка равно
        jPanel.add(equals);
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(e);
            }
        });

        JButton cancel = new JButton("C"); // кнопка сброса калькулятора
        jPanel.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
            }
        });

        add(jPanel);

        setVisible(true);
    }

    public void Action(ActionEvent event){
        text.setText(text.getText() + event.getActionCommand());
    }

    public void ActionMath(ActionEvent event) { // математические действия
        if (text.getText().length() > 0) {
            if ((text.getText().charAt(text.getText().length() - 1) == '+') ||
                    (text.getText().charAt(text.getText().length() - 1) == '-') ||
                    (text.getText().charAt(text.getText().length() - 1) == '*') ||
                    (text.getText().charAt(text.getText().length() - 1) == '/') ||
                    (text.getText().charAt(text.getText().length() - 1) == '.'))
                text.setText("Только один знак!");
                // 3) Добавить проверку что знаки не должны идти друг за другом
                // (либо не позволить это делать вовсе),
                // например 23++1 - недопустимо, 23 +1 - допустимо
            else
                text.setText(text.getText() + event.getActionCommand());
        }
    }

    public void calculate(ActionEvent e){ // действия кнопки равно
        String numbers = text.getText();
        String number = "";
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '+' || numbers.charAt(i) == '-' || numbers.charAt(i) == '*' || numbers.charAt(i) == '/' || numbers.charAt(i) == '^') {
                double digit = Double.parseDouble(number);
                if (numbers.charAt(i) == numbers.charAt(i-1)){
                    continue; // Альтернатива для задания 3: при двух знаках подряд выполняет действие последнего
                }
                if (numbers.charAt(numbers.length()-1) == numbers.charAt(i)){
                    break;  // Если после знака не написать цифру
                }
                if (firstDigit) {
                    tempNumber += digit;
                    firstDigit = false;
                } else {
                    if (operation == '+') {
                        tempNumber += digit;
                    } else if (operation == '-') {
                        tempNumber -= digit;
                    } else if (operation == '*') {
                        tempNumber *= digit; // 1) Добавить операции умножить/разделить
                    } else if (operation == '/') {
                        tempNumber /= digit; // 1) Добавить операции умножить/разделить
                    } else if (operation == '^') {
                        tempNumber = tempNumber * tempNumber;
                    }
                }
                operation = numbers.charAt(i);
                number = "";
                continue;
            }
            number += numbers.charAt(i);
        }

        double digit = Double.parseDouble(number);
        if (operation == '+') {
            tempNumber += digit;
        } else if (operation == '-') {
            tempNumber -= digit;
        } else if (operation == '*') {
            tempNumber *= digit;
        } else if (operation == '/') {
            tempNumber /= digit;
        } else if (operation == '^') {
            tempNumber = tempNumber * tempNumber;
        }

        firstDigit = true;
        text.setText(String.valueOf(tempNumber));
        tempNumber = 0;
    }
}
