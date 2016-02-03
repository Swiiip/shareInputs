import org.jnativehook.NativeInputEvent;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String args[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket = welcomeSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(connectionSocket.getInputStream());

        while(true) {
            NativeInputEvent event = (NativeInputEvent) ois.readObject();
            System.out.println(event.paramString());
        }
    }
}