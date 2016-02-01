import org.jnativehook.GlobalScreen;
import org.jnativehook.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class Monitor {

    int _width;
    int _height;

    public Monitor(int width, int height) {

        _width = width;
        _height = height;
    }

    public void test(){
        GlobalScreen.setEventDispatcher(new SwingDispatchService());
    }
}
