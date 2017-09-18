package listeners;

import sun.awt.SunHints;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeysListener extends KeyAdapter {

    private JTextField fieldResult;

    public KeysListener(JTextField fieldResult) {
        this.fieldResult = fieldResult;
    }

    @Override
    public void keyPressed(KeyEvent event) {
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
            }
       } else if (event.getKeyCode() == KeyEvent.VK_ADD ||
                event.getKeyCode() == KeyEvent.VK_MINUS ||
                event.getKeyCode() == KeyEvent.VK_DIVIDE ||
                event.getKeyCode() == KeyEvent.VK_MULTIPLY ||
                event.getKeyCode() == KeyEvent.VK_COMMA ||
                event.getKeyCode() == KeyEvent.VK_ENTER){

       }
    }
}
