package client.controllers;

import client.Redirect;
import client.views.DashboardView;
import handlers.ErrorHandler;
import handlers.Messages;
import handlers.ValidationHandler;
import server.account.AccountHandler;
import server.transfer.TransferHandler;

public class DashboardController extends Controller {
    DashboardView dashboardView = new DashboardView();

    public void dashboard() {
        // TODO
        switch (dashboardView.dashboard()) {
            case 0 -> exit();
            case 1 -> transferFunds();
            case 2, 3, 4 -> System.out.println("Comming soon...");
            default -> ErrorHandler.invalidInputError();
        }
    }
    private void transferFunds() {
        String target = dashboardView.askForTarget();

        if(ValidationHandler.validatePhoneNumber(target)) {
            String amount = dashboardView.askForAmount();

            if(ValidationHandler.validateNumber(amount)) {
                if(ValidationHandler.validatePositiveNumber(amount)) {
                    boolean success = TransferHandler.transferFunds(Double.parseDouble(amount), target);
                    if(success) {
                        Messages.transferSuccess(amount, target);
                        Redirect.dashboard();
                    }
                } else ErrorHandler.negativeNumberError();
            } else ErrorHandler.invalidInputError();
        } else ErrorHandler.invalidPhoneNumberError("dashboard");
    }
}
