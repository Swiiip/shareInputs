import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import javax.swing.*;
import java.awt.*;

public class GlobalMouseListenerExample implements NativeMouseInputListener {
    private JLabel _label;

    public GlobalMouseListenerExample(JLabel label) {
        _label = label;
    }


    @Override
    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {

    }

    public static void temp(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setSize(new Dimension(300, 300));
        label.setText("No keys typed yet");
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.getContentPane().setSize(300, 300);
        frame.pack();
        frame.setVisible(true);

        GlobalMouseListenerExample listener = new GlobalMouseListenerExample(label);
        GlobalScreen.addNativeMouseMotionListener(listener);
        GlobalScreen.addNativeMouseListener(listener);
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        _label.setText("Mouse clicked");
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        _label.setText("Mouse Pressed");
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        _label.setText("Mouse Released");
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent event) {
        _label.setText("Mouse location : ( " + event.getX() + " , " + event.getY() + " )");
    }
}

