package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientThread extends Thread {
    public LinkedList<ClientThread> clients;
    public LinkedList<String> messageQueue;

    private final Socket SOCKET;
    private final BufferedReader input;
    private final PrintWriter output;

    private String username;

    public ClientThread(Socket socket, LinkedList<ClientThread> clients, LinkedList<String> messageQueue) throws IOException {
        this.SOCKET = socket;
        this.clients = clients;
        this.messageQueue = messageQueue;
        this.input = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));
        this.output = new PrintWriter(SOCKET.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            boolean gate = validateUsername();

            while(gate) {
                String msg = input.readLine();
                messageQueue.add(msg);
            }
            SOCKET.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateUsername() throws IOException {
        while(true) {
            AtomicBoolean nameTaken = new AtomicBoolean(false);
            String name = input.readLine();
            clients.forEach((e) -> {
                if(name.equals(e.getUsername())) nameTaken.set(true);
            });
            if(nameTaken.get()) {
                output.println("TAKEN");
            } else {
                output.println("FREE");
                this.username = name;
                return true;
            }
        }
    }

    public void push(String msg) {
        output.println(msg);
    }
    public String getUsername() {
        return this.username;
    }
}
