package server.transfer;

import handlers.ErrorHandler;
import server.DatabaseHandler;
import server.account.AccountReporter;

import java.sql.Connection;
import java.sql.SQLException;

public class TransferHandler {
    public static boolean transferFunds(Double amount, String target) {
        Connection conn = DatabaseHandler.connect();

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ignored) {}
            if(AccountReporter.userExists(target)) {
                return TransferReporter.storeNewTransfer(amount, target);
            } else ErrorHandler.userDoesNotExistError();
        } else ErrorHandler.noConnectionError();
        return false;
    }
}
