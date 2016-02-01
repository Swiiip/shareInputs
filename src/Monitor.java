import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelListener;

/**
 * Created by h.duthil on 01/02/2016.
 */
public class Monitor implements NativeMouseInputListener, NativeMouseWheelListener, NativeKeyListener {

    int _width;
    int _height;
    GlobalScreen _globalScreen;

    public Monitor(int _width, int _height, GlobalScreen _globalScreen) {
        this._width = _width;
        this._height = _height;
        this._globalScreen = _globalScreen;
    }
}
