package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientThread extends Thread {
    public LinkedList<String> usernames;

    private final Socket SOCKET;

    public ClientThread(Socket socket, LinkedList<String> usernames) {
        this.SOCKET = socket;
        this.usernames = usernames;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));
            PrintWriter output = new PrintWriter(SOCKET.getOutputStream());
            
            AtomicBoolean nameTaken = new AtomicBoolean(false);
            while(true) {
                String username = input.readLine();
                usernames.forEach((e) -> {
                    if(username.equals(e)) nameTaken.set(true);
                });
                if(nameTaken.get()) {
                    output.println("TAKEN");
                    break;
                }
            }
            output.println("FREE");

            while(true) {
                output.println("Test message");
                Thread.sleep(5000);
            }
            
        } catch (Exception ignored) {}
    }
}
