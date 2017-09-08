package listeners;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxListener implements ActionListener {

    private JFrame frame;

    public ComboBoxListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!(event.getSource() instanceof JComboBox)) {
            return;
        }

        JComboBox comboBox = (JComboBox) event.getSource();
        String skinSelected = (String) comboBox.getSelectedItem();
        if (skinSelected.equals("BernsteinLookAndFeel")) {
            try {
                UIManager.setLookAndFeel(new BernsteinLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(frame);
            frame.pack();
        } else if (skinSelected.equals("AluminiumLookAndFeel")) {
            try {
                UIManager.setLookAndFeel(new AluminiumLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(frame);
            frame.pack();
        } else if (skinSelected.equals("HiFiLookAndFeel")) {
            try {
                UIManager.setLookAndFeel(new HiFiLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(frame);
            frame.pack();
        } else if (skinSelected.equals("TextureLookAndFeel")) {
            try {
                UIManager.setLookAndFeel(new TextureLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(frame);
            frame.pack();
        } else if (skinSelected.equals("AcrylLookAndFeel")) {
            try {
                UIManager.setLookAndFeel(new AcrylLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(frame);
            frame.pack();
        } else if (skinSelected.equals("Default")) {
            try {
                UIManager.setLookAndFeel(new AeroLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(frame);
            frame.pack();
        } else {
            try {
                UIManager.setLookAndFeel(new AeroLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(frame);
            frame.pack();
        }
    }
}
