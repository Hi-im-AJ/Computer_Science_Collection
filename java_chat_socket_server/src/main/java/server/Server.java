package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.Executors;

public class Server {
    static final int PORT = 5000;
    static LinkedList<String> usernames = new LinkedList<>();

    public static void main(String[] args) {
        var pool = Executors.newFixedThreadPool(500);
        try(ServerSocket server = new ServerSocket(PORT)) {
            System.out.printf("server.Server is running on port %s%n", PORT);
            while(true) {
                Socket socket = server.accept();
                System.out.printf("Connection from %s:%s...%n", socket.getInetAddress(), socket.getPort());
                pool.execute(new ClientThread(socket, usernames));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

