package client.controllers;

import client.Redirect;
import client.UserState;
import client.views.LoginView;
import handlers.ErrorHandler;
import handlers.ValidationHandler;
import server.account.AccountHandler;

public class LoginController extends Controller {
    LoginView loginView = new LoginView();

    public void loginMenu() {
        switch (loginView.loginMenu()) {
            case 0 -> exit();
            case 1 -> login();
            case 2 -> createAccount();
            default -> ErrorHandler.invalidInputError();
        }
    }
    private void login() {
        String phoneNumber = loginView.askForPhoneNumber();
        if(ValidationHandler.validatePhoneNumber(phoneNumber)) {
            String password = loginView.askForPassword();

            if(ValidationHandler.validatePassword(password)) {
                boolean success = AccountHandler.loginAccount(phoneNumber, password);
                if(success) {
                    UserState.setState(phoneNumber);
                    System.out.printf("Welcome the dashboard %s!\n\n", UserState.getName());
                    Redirect.dashboard();
                }

            } else ErrorHandler.invalidPasswordError();
        } else ErrorHandler.invalidPhoneNumberError("loginMenu");
    }
    private void createAccount() {
        String name = loginView.askForName();
        if(ValidationHandler.validateName(name)) {
            String phoneNumber = loginView.askForPhoneNumber().replace(" ", "").replace("-", "").replace(".", "").replace("_", "");

            if(ValidationHandler.validatePhoneNumber(phoneNumber)) {
                String password = loginView.askForPassword();

                if(ValidationHandler.validatePassword(password)) {
                    boolean success = AccountHandler.createAccount(phoneNumber, password, name);
                    if(success) {
                        UserState.setState(phoneNumber);
                        Redirect.dashboard();
                    }

                } else ErrorHandler.invalidPasswordError();
            } else ErrorHandler.invalidPhoneNumberError("loginMenu");
        } else ErrorHandler.invalidNameError();
    }
}
