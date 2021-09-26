import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    static final int PORT = 5000;
    static LinkedList<Client> clients = new LinkedList<>();

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(PORT)) {
            System.out.printf("Server is running on port %s", PORT);
            while(true) {
                Socket socket = server.accept();
                System.out.printf("Connection from %s:%s...%n", socket.getInetAddress(), socket.getPort());
                clients.add(new Client(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Client extends Thread {
        private final Socket SOCKET;

        public Client(Socket socket) {
            this.SOCKET = socket;
        }

        public void run() {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));
                PrintWriter output = new PrintWriter(SOCKET.getOutputStream());
                while(true) {
                    String msg = input.readLine();
                    if(msg.equals("exit")) break;
                    output.printf("Server: %s", msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

