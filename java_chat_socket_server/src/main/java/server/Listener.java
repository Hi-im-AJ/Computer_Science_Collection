package server;

import java.util.LinkedList;

public class Listener extends Thread {
    LinkedList<ClientThread> clients;
    LinkedList<String> messageQueue;

    public Listener(LinkedList<ClientThread> clients, LinkedList<String> messageQueue) {
        this.clients = clients;
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while(true) {
            if(messageQueue.size() >= 1) {
                String message = messageQueue.get(0);
                for (int i = 0; i < messageQueue.size() + 1; i++) {
                    ClientThread client = clients.get(i);
                    if(client.getUsername() == null) continue;
                    if(!message.startsWith(client.getUsername())) client.push(message);
                }
                messageQueue.remove(0);
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
