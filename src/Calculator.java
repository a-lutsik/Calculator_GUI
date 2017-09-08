import com.jtattoo.plaf.aero.AeroLookAndFeel;
import listeners.ButtonListener;
import listeners.ComboBoxListener;
import sun.security.smartcardio.SunPCSC;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    //Declarate a variable of Calculator
    private JLabel typeCalc;
    private JLabel changeType;
    private JTextField fieldResult;
    private JComboBox<String> listSkin;
    private JScrollPane scroller;
    private JButton button;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private int[][] numConstrains;
    private int[][] memoryConstrains;
    private ButtonListener buttonListener;
    private double resultOfOperations;
    private JPanel panel;
    private JFrame frame;

    public static void main(String[] args) {

        //Setting skin of App
        try{
            UIManager.setLookAndFeel(new AeroLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        Calculator calculator = new Calculator();

        calculator.createPanel();
        calculator.createLabel();
        calculator.createComboBox();
        calculator.createTextField();
        calculator.createButton();
        calculator.createFrame();
    }

    private void createLabel() {
        typeCalc = new JLabel("      Standart"); //need to make a variable what will have a link with selected item of ComboBoxListener
        typeCalc.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 2);

        panel.add(typeCalc, gbc);
    }

    private void createTextField() {
        fieldResult = new JTextField("0");
        fieldResult.setFont(new Font("Result", Font.ROMAN_BASELINE, 50));
        fieldResult.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldResult.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 2);

        panel.add(fieldResult, gbc);
    }

    private void createComboBox() {
        String[] list = {
                "------- Change skin -------",
                "Default",
                "BernsteinLookAndFeel",
                "AluminiumLookAndFeel",
                "HiFiLookAndFeel",
                "TextureLookAndFeel",
                "AcrylLookAndFeel"
        };
        listSkin = new JComboBox<String>(list);
        listSkin.setMaximumRowCount(3);

        //Creating ScrollPanel for JComboBox
        scroller = new JScrollPane(listSkin);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 2);

        panel.add(scroller, gbc);
    }

    private void createPanel() {
        layout = new GridBagLayout();
        layout.columnWidths = new int[]{80, 80, 80, 80};
        layout.rowHeights = new int[]{50, 70, 50, 50, 50, 50, 50, 50, 50};

        gbc = new GridBagConstraints();

        panel = new JPanel(layout);
    }

    private void createButton() {
        resultOfOperations = 0;
        buttonListener = new ButtonListener(fieldResult, resultOfOperations);
        String[] buttonOperations = {"CE", "C", "\uF0E7","1/x", "%", "\u221A", "x2", "\u2797", "7", "8", "9", "\u26CC",
                                     "4", "5", "6", "-", "1", "2", "3", "+", "\u00B1", "0", ",", "="};
        //[0]- gridx, [1]- gridy, [2]- gridWidth, [3]- gridHeight
        numConstrains = new int[][]{
                //column 0  column 1   column 2   column 3
                {0,3,1,1}, {1,3,1,1}, {2,3,1,1}, {3,3,1,1}, //row 3 of App
                {0,4,1,1}, {1,4,1,1}, {2,4,1,1}, {3,4,1,1}, //row 4
                {0,5,1,1}, {1,5,1,1}, {2,5,1,1}, {3,5,1,1}, //row 5
                {0,6,1,1}, {1,6,1,1}, {2,6,1,1}, {3,6,1,1}, //row 6
                {0,7,1,1}, {1,7,1,1}, {2,7,1,1}, {3,7,1,1}, //row 7
                {0,8,1,1}, {1,8,1,1}, {2,8,1,1}, {3,8,1,1}, //row 8
        };

        for (int i = 0; i < buttonOperations.length; i++) {
            button = new JButton();
            button.setText(buttonOperations[i]);
            button.addActionListener(buttonListener);

            gbc.gridx = numConstrains[i][0];
            gbc.gridy = numConstrains[i][1];
            gbc.gridwidth = numConstrains[i][2];
            gbc.gridheight = numConstrains[i][3];
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(2, 2, 2, 2);

            panel.add(button, gbc);
        }

        String[] buttonMemoryOfOperations = {"MC", "MR", "M+", "M-"};

        //[0]- gridx, [1]- gridy, [2]- gridWidth, [3]- gridHeight
        memoryConstrains = new int[][]{
                //column 0  column 1   column 2   column 3
                {0,2,1,1}, {1,2,1,1}, {2,2,1,1}, {3,2,1,1} //row 2 of App
        };

        for (int i = 0; i < buttonMemoryOfOperations.length; i++) {
            button = new JButton();
            button.setText(buttonMemoryOfOperations[i]);
            button.addActionListener(buttonListener);

            gbc.gridx = memoryConstrains[i][0];
            gbc.gridy = memoryConstrains[i][1];
            gbc.gridwidth = memoryConstrains[i][2];
            gbc.gridheight = memoryConstrains[i][3];
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(4, 2, 10, 2);

            panel.add(button, gbc);
        }
    }

    private void createFrame() {
        frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());
        frame.setSize(330, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.getContentPane().add(panel);
        frame.pack();

        addComboBoxListener();

    }

    private void addComboBoxListener() {
        ComboBoxListener comboBoxListener = new ComboBoxListener(frame);
        listSkin.addActionListener(comboBoxListener);
    }

}

