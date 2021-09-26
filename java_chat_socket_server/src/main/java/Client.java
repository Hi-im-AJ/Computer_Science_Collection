import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    static String SERVER_IP = "127.0.0.1";
    static Integer SERVER_PORT = 5000;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        socket.close();
    }
}
