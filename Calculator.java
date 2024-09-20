import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberbuttons = new JButton[10];
    JButton[] functionbuttons = new JButton[9];
    JButton add, sub, mul, div, dec, equ, del, clr, neg;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, res = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        equ = new JButton("=");
        del = new JButton("Del");
        clr = new JButton("Clr");
        neg = new JButton("(-)");

        functionbuttons[0] = add;
        functionbuttons[1] = sub;
        functionbuttons[2] = mul;
        functionbuttons[3] = div;
        functionbuttons[4] = dec;
        functionbuttons[5] = equ;
        functionbuttons[6] = del;
        functionbuttons[7] = clr;
        functionbuttons[8] = neg;

        for (int i = 0; i < 9; i++) {
            functionbuttons[i].addActionListener(this);
            functionbuttons[i].setFont(myFont);
            functionbuttons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberbuttons[i] = new JButton(String.valueOf(i));
            numberbuttons[i].addActionListener(this);
            numberbuttons[i].setFont(myFont);
            numberbuttons[i].setFocusable(false);
        }

        neg.setBounds(50, 430, 100, 50);
        del.setBounds(150, 430, 100, 50);
        clr.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberbuttons[1]);
        panel.add(numberbuttons[2]);
        panel.add(numberbuttons[3]);
        panel.add(add);
        panel.add(numberbuttons[4]);
        panel.add(numberbuttons[5]);
        panel.add(numberbuttons[6]);
        panel.add(sub);
        panel.add(numberbuttons[7]);
        panel.add(numberbuttons[8]);
        panel.add(numberbuttons[9]);
        panel.add(mul);
        panel.add(div);
        panel.add(dec);
        panel.add(numberbuttons[0]);
        panel.add(equ);

        frame.add(panel);
        frame.add(neg);
        frame.add(del);
        frame.add(clr);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberbuttons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dec) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == add) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText(num1 + " + ");
        }
        if (e.getSource() == sub) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText(num1 + " - ");
        }
        if (e.getSource() == mul) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText(num1 + " * ");
        }
        if (e.getSource() == div) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText(num1 + " / ");
        }
        if (e.getSource() == equ) {
            num2 = Double.parseDouble(textfield.getText().split(" ")[2]);
            switch (operator) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(res));
            num1 = res;
        }
        if (e.getSource() == clr) {
            textfield.setText("");
        }
        if (e.getSource() == del) {
            String str = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textfield.setText(textfield.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == neg) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
