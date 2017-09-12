package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField fieldResult;
    private String resultSetNumbers;
    private double memoryOfCalc;
    private double resultOfOperations;
    private boolean isOperant = false;
    private int operant;
    private double[] bufferOfNumbers = {0.0, 0.0, 0,0}; // {finalResult, Number_1, resultOfOperations}
    private double finalResult;

    public ButtonListener(JTextField fieldResult, double resultOfOperations) {
        this.fieldResult = fieldResult;
        this.resultSetNumbers = "";
        this.resultOfOperations = resultOfOperations;
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
                bufferOfNumbers[0] = bufferOfNumbers[1]; // finalResult
                finalResult = bufferOfNumbers[0];
                System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);

            } else {
                mathOperations(operant);
                operant = 1;
            }

            fieldResult.setText(""); //cleaering a text field if pressed a button "+"

        } else if (button.getText().equals("-")) {

            if (!isOperant) {

                isOperant = true;
                operant = 2;

                bufferOfNumbers[1] = resultOfOperations;
                bufferOfNumbers[0] = bufferOfNumbers[1]; // finalResult
                finalResult = bufferOfNumbers[0];
                System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);

            } else {
                mathOperations(operant);
                operant = 2;
            }

            fieldResult.setText("");  //cleaering a text field if pushed button "-"

        } else if (button.getText().equals("\u2797")) {   //  division

            if (!isOperant) {

                isOperant = true;
                operant = 3;

                bufferOfNumbers[1] = resultOfOperations;
                bufferOfNumbers[0] = bufferOfNumbers[1]; // finalResult
                finalResult = bufferOfNumbers[0];
                System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);

            } else {
                mathOperations(operant);
                operant = 3;
            }

            fieldResult.setText("");  //cleaering a text field if pushed button "-"

        } else if (button.getText().equals("\u26CC")) {   // increase

            if (!isOperant) {

                isOperant = true;
                operant = 4;

                bufferOfNumbers[1] = resultOfOperations;
                bufferOfNumbers[0] = bufferOfNumbers[1]; // finalResult
                finalResult = bufferOfNumbers[0];
                System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);

            } else {
                mathOperations(operant);
                operant = 4;
            }

            fieldResult.setText("");

        } else if (button.getText().equals("=")) {

            mathOperations(operant);
            System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);

            finalResult = bufferOfNumbers[0];// доделать, чтобы после равно было (12+3=15 +5=20)
            fieldResult.setText(String.valueOf(finalResult));

            operant = 0;
            resultOfOperations = 0;
            bufferOfNumbers[1] = 0;
            bufferOfNumbers[2] = 0;

        } else if (button.getText().equals(",")) {
            fieldResult.setText("");

        } else if (button.getText().equals("\u00B1")) {    // +/-

            resultOfOperations = resultOfOperations * (-1);
            fieldResult.setText(String.valueOf(resultOfOperations));

        } else if (button.getText().equals("x2")) {

            resultOfOperations = Math.pow(Double.parseDouble(fieldResult.getText()), 2);
            fieldResult.setText(String.valueOf(resultOfOperations));

        } else if (button.getText().equals("1/x")) {

            try{
                resultOfOperations = 1 / resultOfOperations;
            } catch (ArithmeticException e) {
                fieldResult.setText("can not be divided by zero!");
            }

            fieldResult.setText(String.valueOf(resultOfOperations));

        } else if (button.getText().equals("%")) {

            try {
                resultOfOperations = ( finalResult * resultOfOperations) /100;
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
//----------------------------------------------------------------------------------------Done
        } else if (button.getText().equals("\uF0E7")) {   // backspace

            fieldResult.setText("");

        } else if (button.getText().equals("\u221A")) {   // square

            resultOfOperations = Math.sqrt(Double.parseDouble(fieldResult.getText()));
            fieldResult.setText(String.valueOf(resultOfOperations));

        } else if (button.getText().equals("MC")) {

            fieldResult.setText("");

        } else if (button.getText().equals("MR")) {

            fieldResult.setText("");

        } else if (button.getText().equals("M+")) {

            fieldResult.setText("");

        } else if (button.getText().equals("M-")) {

            fieldResult.setText("");

        } else {
            //Handler of number buttons (0, 1, 2, 3.....9)
            fieldResult.replaceSelection(resultSetNumbers + button.getActionCommand());
            resultOfOperations = Double.parseDouble(fieldResult.getText());
        }
    }


    private void mathOperations(int numberOfOperation) {

        if (numberOfOperation == 1) {               // addition
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] + bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
            System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);

        } else if (numberOfOperation == 2) {        // subtraction
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] - bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
            System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);

        } else if (numberOfOperation == 3) {        // division
            bufferOfNumbers[2] = resultOfOperations;

            try{
                bufferOfNumbers[0] = bufferOfNumbers[1] / bufferOfNumbers[2];
            } catch (ArithmeticException e) {
                fieldResult.setText("can not be divided by zero!");
            }

            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
            System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);

        } else if (numberOfOperation == 4) {        // increase
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] * bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
            System.out.println(bufferOfNumbers[0]+" "+bufferOfNumbers[1]+ " "+bufferOfNumbers[2]+"   "+finalResult);
        }
    }
}