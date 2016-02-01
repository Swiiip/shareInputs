import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventListener extends MouseAdapter {

    private JLabel _xLabel;
    private JLabel _yLabel;

    public EventListener(JLabel xLabel, JLabel yLabel) {
        _xLabel = xLabel;
        _yLabel = yLabel;
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        _xLabel.setText("X : " + mouseEvent.getXOnScreen());
        _yLabel.setText("Y : " + mouseEvent.getYOnScreen());
    }
}