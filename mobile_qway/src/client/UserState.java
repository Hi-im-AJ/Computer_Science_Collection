package client;

import server.account.AccountHandler;

public class UserState {
    private static final String undefined = "UNDEFINED";
    private static String name = undefined, phoneNumber = undefined;

    public static void setState(String targetPhoneNumber) {
        String[] userTable = AccountHandler.getUserState(targetPhoneNumber);
        if(userTable != null) {
            phoneNumber = userTable[0];
            name = userTable[1];
        }
    }
    public static String getName() {
        return name;
    }
    public static String getPhoneNumber() {
        return phoneNumber;
    }
}
