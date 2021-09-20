package client.views;

import handlers.ErrorHandler;

public class LoginView extends View {

    public int loginMenu() {
        while (true) {
            System.out.println("[1] Login");
            System.out.println("[2] Create Account");
            System.out.println("[0] Exit");

            int input = input();
            if(input >= 0 && input <= 2) return input;
            else ErrorHandler.invalidInputError();
        }
    }
    public String askForName() {
        System.out.print("Full name: ");
        return scanner.nextLine();
    }
    public String askForPhoneNumber() {
        System.out.print("Phone number: ");
        return scanner.nextLine();
    }
    public String askForPassword() {
        System.out.print("Password: ");
        return scanner.nextLine();
    }
}
