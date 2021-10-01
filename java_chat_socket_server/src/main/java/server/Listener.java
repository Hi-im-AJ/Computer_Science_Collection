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
                LinkedList<Integer> remove = new LinkedList<>();
                for (int i = 0; i < clients.size(); i++) {
                    if (clients.get(i).exit) remove.add(i);
                }
                for (int e: remove) {
                    clients.remove(e);
                }

                String message = messageQueue.get(0);
                for (ClientThread client : clients) {
                    if (client.getUsername() == null || client.isAlive()) continue;
                    if (!message.startsWith(client.getUsername())) client.push(message);
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
