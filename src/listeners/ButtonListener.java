package listeners;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ButtonListener implements ActionListener {

    private JTextField fieldResult;
    private String resultSetNumbers;
    private double memoryOfCalc;
    private double resultOfOperations;
    private boolean isOperant = false;
    private int operant;
    private double[] bufferOfNumbers = {0.0, 0.0, 0.0};
    private double finalResult;

    public ButtonListener(JTextField fieldResult) {
        this.fieldResult = fieldResult;
        this.resultSetNumbers = "";
        this.resultOfOperations = 0.0;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!(event.getSource() instanceof JButton)) {
            return;
        }

        if (fieldResult.getText().equals("0") || fieldResult.getText().equals("0.0")) {
            fieldResult.setText("");
        }

        JButton button = (JButton) event.getSource();

        if (button.getText().equals("+")) {

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
        } else if (button.getText().equals("-")) {

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
        } else if (button.getText().equals("\u2797")) { //  division

            if (!isOperant) {
                isOperant = true;
                operant = 3;

                bufferOfNumbers[1] = resultOfOperations;
                bufferOfNumbers[0] = bufferOfNumbers[1];
                finalResult = bufferOfNumbers[0];
            } else {
                mathOperations(operant);
                operant = 3;
            }
            //cleaering a text field if pushed button "/"
            fieldResult.setText("");
        } else if (button.getText().equals("\u26CC")) { // increase

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
        } else if (button.getText().equals("=")) {
            mathOperations(operant);

            finalResult = bufferOfNumbers[0];
            DecimalFormat df = new DecimalFormat("0.#####");
            fieldResult.setText(df.format(finalResult));

            operant = 0;
            resultOfOperations = 0;
            bufferOfNumbers[2] = 0;
        } else if (button.getText().equals(",")) {
            StringBuilder sb = new StringBuilder(fieldResult.getText());
            sb.append(".");
            fieldResult.setText(sb.toString());
        } else if (button.getText().equals("\u00B1")) { // +/-
            resultOfOperations = resultOfOperations * (-1);
            fieldResult.setText(String.valueOf(resultOfOperations));
        } else if (button.getText().equals("x2")) {
            resultOfOperations = Math.pow(Double.parseDouble(fieldResult.getText()), 2);
            fieldResult.setText(String.valueOf(resultOfOperations));
        } else if (button.getText().equals("1/x")) {
            try {
                resultOfOperations = 1 / resultOfOperations;
            } catch (ArithmeticException e) {
                fieldResult.setText("can not be divided by zero!");
            }
            fieldResult.setText(String.valueOf(resultOfOperations));
        } else if (button.getText().equals("%")) {
            try {
                resultOfOperations = (finalResult * resultOfOperations) / 100;
            } catch (ArithmeticException e) {
                fieldResult.setText("can not be divided by zero!");
            }
            fieldResult.setText(String.valueOf(resultOfOperations));
        } else if (button.getText().equals("CE")) {
            fieldResult.setText("");
        } else if (button.getText().equals("C")) {
            fieldResult.setText("0");

            finalResult = 0;
            resultOfOperations = 0;
            isOperant = false;

            bufferOfNumbers[0] = 0;
            bufferOfNumbers[1] = 0;
            bufferOfNumbers[2] = 0;
        } else if (button.getText().equals("\uF0E7")) { // backspace
            StringBuilder sb = new StringBuilder(fieldResult.getText());

            if (sb.length() == 0) {
                fieldResult.setText("0");
            }

            sb.deleteCharAt(sb.length() - 1);
            fieldResult.setText(sb.toString());
        } else if (button.getText().equals("\u221A")) { // square
            resultOfOperations = Math.sqrt(Double.parseDouble(fieldResult.getText()));
            fieldResult.setText(String.valueOf(resultOfOperations));
        } else if (button.getText().equals("MC")) { //clear the memory
            memoryOfCalc = 0;
        } else if (button.getText().equals("MR")) { // memory call
            resultOfOperations = memoryOfCalc;
            fieldResult.setText(String.valueOf(memoryOfCalc));
        } else if (button.getText().equals("M+")) { // add to memory
            memoryOfCalc += Double.parseDouble(fieldResult.getText());
        } else if (button.getText().equals("M-")) { // subtract from memory
            memoryOfCalc -= Double.parseDouble(fieldResult.getText());
        } else {
            //Handler of number buttons (0, 1, 2, 3.....9)
            fieldResult.replaceSelection(resultSetNumbers + button.getActionCommand());
            resultOfOperations = Double.parseDouble(fieldResult.getText());
        }
    }

    private void mathOperations(int numberOfOperation) {

        if (numberOfOperation == 1) { // addition
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] + bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
        } else if (numberOfOperation == 2) { // subtraction
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] - bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
        } else if (numberOfOperation == 3) { // division
            bufferOfNumbers[2] = resultOfOperations;

            try {
                bufferOfNumbers[0] = bufferOfNumbers[1] / bufferOfNumbers[2];
            } catch (ArithmeticException e) {
                fieldResult.setText("can not be divided by zero!");
            }

            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
        } else if (numberOfOperation == 4) { // increase
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] * bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
        }
    }
}