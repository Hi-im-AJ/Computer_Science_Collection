package server.transfer;

import client.UserState;
import server.DatabaseHandler;
import server.ToolHandler;

public class TransferReporter {
    protected static boolean storeNewTransfer(Double amount, String target) {
        return DatabaseHandler.insertIntoTable("transfers", ToolHandler.getCurrentDate(), UserState.getPhoneNumber(), target, amount);
    }

}
