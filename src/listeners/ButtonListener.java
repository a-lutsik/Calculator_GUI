package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField fieldResult;
    private String resultSetNumbers;
    private double memoryOfCalc;
    private double resultOfOperations;
    private boolean isAddition = false;
    private boolean isSubscrub = false;
    private boolean isIncrease = false;
    private boolean isDivision = false;
    private double finalResult;

    public ButtonListener(JTextField fieldResult, double resultOfOperations) {
        this.fieldResult = fieldResult;
        this.resultSetNumbers = "";
        this.resultOfOperations = resultOfOperations;
        System.out.println("constructor "+resultOfOperations);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!(event.getSource() instanceof JButton)) {
            return;
        }

        //Clear text field when button is pushed
        if (fieldResult.getText().equals("0")) {
            fieldResult.setText("");
        }
                //Проверку сделать на isEmpty поле fieldResult
        JButton button = (JButton) event.getSource();

        System.out.println("FINALRESULT in start method "+ finalResult +"   resultOperations in start method "+resultOfOperations);


        if (button.getText().equals("+")) {

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("before addition resultOper "+resultOfOperations);

            if (!isAddition) {

                isAddition = true;
                isSubscrub = false;
                isIncrease = false;
                isDivision = false;
                System.out.println("-1- isADD = " + isAddition + "  isSUB = " + isSubscrub + "  isINCR = " + isIncrease);

                if (finalResult == 0) {
                    finalResult = resultOfOperations;
                }
                resultOfOperations = 0;
                System.out.println("if sum " + finalResult +" "+ "resultOp "+resultOfOperations);
            } else {

                mathOperations();
                System.out.println("-2- isADD = " + isAddition + "  isSUB = " + isSubscrub + "  isINCR = " + isIncrease);
            }

            System.out.println("after adition resultOper "+resultOfOperations);
            System.out.println(" ");
            System.out.println(" ");
            fieldResult.setText("");                //cleaering a text field if pushed button "+"

        } else if (button.getText().equals("-")) {

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("before subscrub resultOperation "+resultOfOperations);

            if (!isSubscrub) {

                isSubscrub = true;
                isAddition = false;
                isIncrease = false;
                isDivision = false;
                System.out.println("-3- isADD = " + isAddition + "  isSUB = " + isSubscrub + "  isINCR = " + isIncrease);

                if (finalResult == 0) {
                    finalResult = resultOfOperations;
                }

                resultOfOperations = 0;
                System.out.println("if subscrub " + finalResult +" "+ "resultOp "+resultOfOperations);
            } else {
                mathOperations();
                System.out.println("-4- isADD = " + isAddition + "  isSUB = " + isSubscrub + "  isINCR = " + isIncrease);
            }

            System.out.println("after subscrub resultOperation "+resultOfOperations);
            System.out.println(" ");
            System.out.println(" ");

            fieldResult.setText("");                //cleaering a text field if pushed button "-"

        } else if (button.getText().equals("=")) {

            mathOperations();

            System.out.println("equal in start IF = " + finalResult);
            fieldResult.setText(String.valueOf(finalResult));
            resultOfOperations = 0;
            System.out.println("equal in stop IF = " + finalResult + "    resultOperation in stop IF = " + resultOfOperations);
            System.out.println(" ");
            System.out.println(" ");

        } else if (button.getText().equals(",")) {
            fieldResult.setText("");

        } else if (button.getText().equals("\u00B1")) {    // +/-
            double a = Double.parseDouble(fieldResult.getText()) * (-1);
            fieldResult.setText(String.valueOf(a));

        } else if (button.getText().equals("x2")) {
            resultOfOperations = Math.pow(Double.parseDouble(fieldResult.getText()), 2);
            fieldResult.setText(String.valueOf(resultOfOperations));

        } else if (button.getText().equals("1/x")) {
            fieldResult.setText("1");

        } else if (button.getText().equals("%")) {
            fieldResult.setText("");

        } else if (button.getText().equals("CE")) {
            fieldResult.setText("");

        } else if (button.getText().equals("C")) {
            fieldResult.setText("0");

            finalResult = 0;
            resultOfOperations = 0;

            isAddition = false;
            isSubscrub = false;
            isIncrease = false;
            isDivision = false;

        } else if (button.getText().equals("\uF0E7")) {   // backspace
            fieldResult.setText("");

        } else if (button.getText().equals("\u221A")) {   // square
            resultOfOperations = Math.sqrt(Double.parseDouble(fieldResult.getText()));
            fieldResult.setText(String.valueOf(resultOfOperations));

        } else if (button.getText().equals("\u2797")) {   //  division
            try{
                resultOfOperations = resultOfOperations / Double.parseDouble(fieldResult.getText());
            } catch (ArithmeticException e) {
                fieldResult.setText("can not be divided by zero!");
            }
            fieldResult.setText("");

        } else if (button.getText().equals("\u26CC")) {   // increase

            if (!isIncrease) {

                isIncrease = true;
                isAddition = false;
                isSubscrub = false;
                isDivision = false;
                System.out.println("-5- isADD = " + isAddition + "  isSUB = " + isSubscrub + "  isINCR = " + isIncrease);

                if (finalResult == 0) {
                    finalResult = (finalResult + 1) * resultOfOperations;
                }
                resultOfOperations = 0;
                System.out.println("if INCREASE " + finalResult +" "+ "resultOperations "+resultOfOperations);
            } else {

                mathOperations();
                System.out.println("-6- isADD = " + isAddition + "  isSUB = " + isSubscrub + "  isINCR = " + isIncrease);
            }
            fieldResult.setText("");

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

    private void mathOperations() {
        if (isAddition) {
            System.out.println("working isAddition");
            finalResult = finalResult + resultOfOperations;
            System.out.println("FINALRESULT in stop of isAddition " + finalResult);
        } else if (isSubscrub) {
            System.out.println("working isSubscrub");
            finalResult = finalResult - resultOfOperations;
            System.out.println("FINALRESULT in stop of isSubscrub " + finalResult);
        } else if (isIncrease) {
            System.out.println("working isIncrease");
            finalResult = finalResult * resultOfOperations;
            System.out.println("FINALRESULT in stop of isIncrease " + finalResult);
        }
    }
}
