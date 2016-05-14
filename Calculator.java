
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

    public static void main(String[] args) {
        //create an calculator object and setup properties
        Calc c = new Calc();
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setResizable(false);
        c.setSize(300, 200);
        c.setVisible(true);
    }

}

class Calc extends JFrame {

    public double num1; //the first operand
    public int opr; //the mathmetical operation code [0 == Addition, 1 == Subtraction, 2 == multiplication, 3 == division]

    public Calc() {
        super("Calculator"); //call constructor of super class (JFrame)
        setLayout(new FlowLayout()); 

        //create a text field and add it to the frame
        final JTextField num = new JTextField(20);
        getContentPane().add(num);

        //create panel to contain the numbers and mathmetical operation
        JPanel p = new JPanel(new GridLayout(4, 4));

        //Buttons for numbers 
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton zero = new JButton("0");

        //Buttons for mathmetical operation
        JButton add = new JButton("+");
        JButton equal = new JButton("=");
        JButton sub = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");
        JButton dot = new JButton(".");

        //add all buttons to the panel and add the panel to the frame
        p.add(seven);
        p.add(eight);
        p.add(nine);
        p.add(add);

        p.add(four);
        p.add(five);
        p.add(six);
        p.add(sub);

        p.add(one);
        p.add(two);
        p.add(three);
        p.add(mul);

        p.add(zero);
        p.add(dot);
        p.add(equal);
        p.add(div);
        getContentPane().add(p);

        num1 = 0;

        //set on click action listener for all buttons
        one.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "1");
            }
        });
        zero.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "0");
            }
        });
        two.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "2");
            }
        });
        three.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "3");
            }
        });
        four.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "4");
            }
        });
        five.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "5");
            }
        });
        six.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "6");
            }
        });
        seven.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "7");
            }
        });
        eight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "8");
            }
        });
        nine.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + "9");
            }
        });
        dot.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                num.setText(num.getText() + ".");
            }
        });

        try { // to handel arithmetic error

            add.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    num1 = Double.parseDouble(num.getText());
                    opr = 0;
                    num.setText("");
                }
            });
            sub.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    num1 = Double.parseDouble(num.getText());
                    opr = 1;
                    num.setText("");
                }
            });
            mul.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    num1 = Double.parseDouble(num.getText());
                    opr = 2;
                    num.setText("");
                }
            });
            div.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    num1 = Double.parseDouble(num.getText());
                    opr = 3;
                    num.setText("");
                }
            });

            equal.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    double num2 = Double.parseDouble(num.getText());

                    if (opr == 0) {
                        num.setText("" + (num1 + num2));
                    } else if (opr == 1) {
                        num.setText("" + (num1 - num2));
                    } else if (opr == 2) {
                        num.setText("" + (num1 * num2));
                    } else if (opr == 3 && num2 != 0) {
                        num.setText("" + (num1 / num2));
                    } else {
                        num.setText("Math Error");
                    }
                }
            });

        } catch (Exception e) {
            num.setText("Syntax Error!");
        }
    }
}
