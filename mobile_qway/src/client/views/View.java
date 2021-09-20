package client.views;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    int input() {
        System.out.print("Input: ");
        String input = scanner.nextLine();
        return handlers.ValidationHandler.validateNumber99(input) ? Integer.parseInt(input) : -1;
    }
}
