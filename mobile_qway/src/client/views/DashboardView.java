package client.views;

import handlers.ErrorHandler;

public class DashboardView extends View {
    public int dashboard() {
        while (true) {
            System.out.println("[1] Transfer funds");
            System.out.println("[2] Add card");
            System.out.println("[3] Update card");
            System.out.println("[4] Update address");
            System.out.println("[0] Exit");

            int input = input();
            if(input >= 0 && input <= 4) return input;
            else ErrorHandler.invalidInputError();
        }
    }
    public String askForAmount() {
        System.out.print("Amount: ");
        return scanner.nextLine();
    }
    public String askForTarget() {
        System.out.print("To (phone number): ");
        return scanner.nextLine();
    }
}
