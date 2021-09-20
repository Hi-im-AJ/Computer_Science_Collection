package vz.server1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write something: ");
        while(true) {
            String input = scanner.nextLine();
            dataOutputStream.writeUTF(input);
            dataOutputStream.flush();
            String msg = dataInputStream.readUTF();
            if(input.equals("exit")) break;
            System.out.println(msg);
        }
        socket.close();
    }
}
