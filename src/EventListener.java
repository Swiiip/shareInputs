import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventListener extends MouseAdapter {

    private JLabel _jlabel;

    public EventListener(JLabel jlabel) {
        _jlabel = jlabel;
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        _jlabel.setText("x : " + mouseEvent.getXOnScreen()+ ", y : " + mouseEvent.getYOnScreen());
    }
}