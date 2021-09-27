package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientThread extends Thread {
    public LinkedList<String> usernames;

    private final Socket SOCKET;
    private final BufferedReader input;
    private final PrintWriter output;

    public ClientThread(Socket socket, LinkedList<String> usernames) throws IOException {
        this.SOCKET = socket;
        this.usernames = usernames;
        this.input = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));
        this.output = new PrintWriter(SOCKET.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            boolean gate = validateUsername();

            while(gate) {
                output.println("Test message");
                Thread.sleep(5000);
            }
            SOCKET.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateUsername() throws IOException {
        AtomicBoolean nameTaken = new AtomicBoolean(false);
        String username;
        while(true) {
            username = input.readLine();
            String finalUsername = username;
            usernames.forEach((e) -> {
                if(finalUsername.equals(e)) nameTaken.set(true);
            });
            if(nameTaken.get()) {
                output.println("TAKEN");
            } else {
                output.println("FREE");
                usernames.add(username);
                return true;
            }
        }
    }
}
