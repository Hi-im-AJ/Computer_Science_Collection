package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final String SERVER_IP = "127.0.0.1";
    static final Integer SERVER_PORT = 5000;
    static Scanner scanner = new Scanner(System.in);
    static String name;

    public static void main(String[] args) {
            try(Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Please provide your username: ");
            while (true) {
                name = scanner.nextLine();
                output.write(name);
                if(input.readLine().equals("FREE")) {
                    break;
                } else {
                    System.out.println("That name is already taken");
                }
            }

            System.out.printf("Welcome %s%n", name);
            System.out.println("You can now start chatting!");
            while(true) {
                System.out.printf("%s: ", name);
                String msg = scanner.nextLine();
                output.println(msg);
                if(msg.equals("exit")) break;
                System.out.println(input.readLine());
            }
            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
