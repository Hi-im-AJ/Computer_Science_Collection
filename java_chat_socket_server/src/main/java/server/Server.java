package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.Executors;

public class Server {
    static final int PORT = 5000;
    static LinkedList<ClientThread> clients = new LinkedList<>();
    static LinkedList<String> messageQueue = new LinkedList<>();

    public static void main(String[] args) {
        var pool = Executors.newFixedThreadPool(500);
        new Listener(clients, messageQueue).start();
        try(ServerSocket server = new ServerSocket(PORT)) {
            System.out.printf("server.Server is running on port %s%n", PORT);
            while(true) {
                Socket socket = server.accept();
                System.out.printf("Connection from %s:%s...%n", socket.getInetAddress(), socket.getPort());
                ClientThread client = new ClientThread(socket, clients, messageQueue);
                clients.add(client);
                pool.execute(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

