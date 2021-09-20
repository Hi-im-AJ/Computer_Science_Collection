package vz.server1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 9000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.printf("Server running on port %s", port);
        try {
            Socket socket = serverSocket.accept();
            System.out.printf("\nConnection established %s", socket.getRemoteSocketAddress().toString());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while(true) {
                String message = dataInputStream.readUTF();
                if(message.equals("exit")) break;
                dataOutputStream.writeUTF(String.format("This is your message: %s", message));
                dataOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
