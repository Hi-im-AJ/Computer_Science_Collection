package client;

import client.controllers.DashboardController;
import client.controllers.LoginController;

public class Redirect {
    private static final LoginController LOGIN_CONTROLLER = new LoginController();
    private static final DashboardController DASHBOARD_CONTROLLER = new DashboardController();

    public static void loginMenu() {
        System.out.print("\n");
        LOGIN_CONTROLLER.loginMenu();
    }
    public static void dashboard() {
        System.out.print("\n");
        DASHBOARD_CONTROLLER.dashboard();
    }
}
