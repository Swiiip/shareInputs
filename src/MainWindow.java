import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class MainWindow extends JDialog implements NativeMouseInputListener, NativeKeyListener {
    private JPanel contentPane;
    private JLabel _mouseXTitle;
    private JLabel _mouseYTitle;
    private JLabel _mouseEventTitle;
    private JLabel _keyboardKey;
    private JLabel _mouseXLabel;
    private JLabel _mouseYLabel;
    private JLabel _mouseEventLabel;
    private Set<Integer> _nonUnicodeKeys;

    public MainWindow() {
        _nonUnicodeKeys = new HashSet<Integer>();
        _nonUnicodeKeys.add(NativeKeyEvent.VC_BACKSPACE);
        GlobalScreen.setEventDispatcher(new SwingDispatchService());
        GlobalScreen.addNativeMouseListener(this);
        GlobalScreen.addNativeMouseMotionListener(this);
        GlobalScreen.addNativeKeyListener(this);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

    }

    private void initUI() {

        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        pack();
        setVisible(true);
        System.exit(0);
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        int buttonClicked = nativeMouseEvent.getButton();
        if(buttonClicked == 1){
            _mouseEventLabel.setText("Left button");
        }else{
            _mouseEventLabel.setText("Right button");
        }
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        _mouseEventLabel.setText("Mouse pressed");
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        _mouseEventLabel.setText("Mouse released");
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {
        _mouseXLabel.setText(""+nativeMouseEvent.getX());
        _mouseYLabel.setText(""+nativeMouseEvent.getY());
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {
        _mouseEventLabel.setText("Mouse dragged");
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if(_nonUnicodeKeys.contains(nativeKeyEvent.getKeyCode())) {
            _keyboardKey.setText(String.valueOf(nativeKeyEvent.getKeyCode()));
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        _keyboardKey.setText(String.valueOf(nativeKeyEvent.getKeyChar()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.initUI();
            }
        });
    }
}
