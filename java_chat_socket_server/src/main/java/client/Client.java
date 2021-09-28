package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final String SERVER_IP = "127.0.0.1";
    static final Integer SERVER_PORT = 5000;

    static BufferedReader input;
    static PrintWriter output;
    static Scanner scanner = new Scanner(System.in);
    static String name;

    public static void main(String[] args) {
        try(Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            provideUsername();
            chatLoop();

            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void chatLoop() {
        new Listener(input).start();
        while(true) {
            String msg = scanner.nextLine();
            if(msg.equals("!exit")) break;
            output.println(String.format("%s: %s", name, msg));
        }
    }

    private static void provideUsername() throws IOException {
        System.out.print("Please provide your username: ");
        while (true) {
            name = scanner.nextLine();
            output.println(name);
            String response = input.readLine();
            if(response.equals("FREE")) {
                break;
            } else {
                System.out.println("That name is already taken");
            }
        }

        System.out.printf("Welcome %s%n", name);
        System.out.println("You can now start chatting!\nUse !exit to close the connection");
    }
}
