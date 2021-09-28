package client;

import java.io.BufferedReader;
import java.io.IOException;

public class Listener extends Thread {
    BufferedReader input;
    public Listener(BufferedReader input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println(input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
