import java.io.*;
import java.net.*;

public class TCPClient {

    private BufferedReader _inFromUser;
    private DataOutputStream _outToServer;
    private Socket _clientSocket;
    private BufferedReader _inFromServer;

    public TCPClient(){
        try {
            init();
        } catch (IOException e) {
            System.out.println("Error initializing client");
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        _inFromUser = new BufferedReader(new InputStreamReader(System.in));
        _clientSocket = new Socket("localhost", 6789);
        _outToServer = new DataOutputStream(_clientSocket.getOutputStream());
        _inFromServer = new BufferedReader(new InputStreamReader(_clientSocket.getInputStream()));
    }

    public DataOutputStream outToServer() {
        return _outToServer;
    }
}