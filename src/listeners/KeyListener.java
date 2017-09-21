package listeners;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import static mathOperations.MathOperations.*;

public class KeyListener extends KeyAdapter {

    private JTextField fieldResult;

    public KeyListener(JTextField fieldResult) {
        this.fieldResult = fieldResult;
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (fieldResult.getText().equals("0") || fieldResult.getText().equals("0.0")) {
            fieldResult.setText("");
        }

        if (event.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD) {
            if (event.getKeyCode() == KeyEvent.VK_NUMPAD0 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD1 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD2 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD3 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD4 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD5 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD6 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD7 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD8 ||
                    event.getKeyCode() == KeyEvent.VK_NUMPAD9) {
                fieldResult.replaceSelection("" + event.getKeyChar());
                resultOfOperations = Double.parseDouble(fieldResult.getText());
            } else if (event.getKeyCode() == KeyEvent.VK_ADD) {
                System.out.println("+");
                if (!isOperant) {
                    isOperant = true;
                    operant = 1;

                    bufferOfNumbers[1] = resultOfOperations;
                    bufferOfNumbers[0] = bufferOfNumbers[1];
                    finalResult = bufferOfNumbers[0];
                } else {
                    mathOperations(operant);
                    operant = 1;
                }
                //cleaering a text field if pressed a button "+"
                fieldResult.setText("");
            } else if (event.getKeyCode() == KeyEvent.VK_SUBTRACT) {
                System.out.println("-");
                if (!isOperant) {
                    isOperant = true;
                    operant = 2;

                    bufferOfNumbers[1] = resultOfOperations;
                    bufferOfNumbers[0] = bufferOfNumbers[1];
                    finalResult = bufferOfNumbers[0];
                } else {
                    mathOperations(operant);
                    operant = 2;
                }
                //cleaering a text field if pushed button "-"
                fieldResult.setText("");
            } else if (event.getKeyCode() == KeyEvent.VK_DIVIDE) {
                System.out.println("/");
                if (!isOperant) {
                    isOperant = true;
                    operant = 3;

                    bufferOfNumbers[1] = resultOfOperations;
                    bufferOfNumbers[0] = bufferOfNumbers[1];
                    finalResult = bufferOfNumbers[0];
                } else {
                    try {
                        mathOperations(operant);
                    } catch (ArithmeticException e) {
                        fieldResult.setText("can not be divided by zero!");
                    }
                    mathOperations(operant);
                    operant = 3;
                }
                //cleaering a text field if pushed button "/"
                fieldResult.setText("");
            } else if (event.getKeyCode() == KeyEvent.VK_MULTIPLY) {
                System.out.println("*");
                if (!isOperant) {
                    isOperant = true;
                    operant = 4;

                    bufferOfNumbers[1] = resultOfOperations;
                    bufferOfNumbers[0] = bufferOfNumbers[1];
                    finalResult = bufferOfNumbers[0];
                } else {
                    mathOperations(operant);
                    operant = 4;
                }
                //cleaering a text field if pushed button "*"
                fieldResult.setText("");
            } else if (event.getKeyCode() == 110) {
                System.out.println(",");
                StringBuilder sb = new StringBuilder(fieldResult.getText());
                sb.append(".");
                fieldResult.setText(sb.toString());
            } else if (event.getKeyCode() == KeyEvent.VK_ENTER){
                //button = button.getActionCommand("");
                System.out.println("=");
                mathOperations(operant);

                finalResult = bufferOfNumbers[0];
                DecimalFormat df = new DecimalFormat("0.#####");
                fieldResult.setText(df.format(finalResult));

                operant = 0;
                resultOfOperations = 0;
                bufferOfNumbers[2] = 0;
            }
        } else if (event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            StringBuilder sb = new StringBuilder(fieldResult.getText());

            if (sb.length() == 0) {
                fieldResult.setText("0");
            }

            sb.deleteCharAt(sb.length() - 1);
            fieldResult.setText(sb.toString());
        }
    }

}
