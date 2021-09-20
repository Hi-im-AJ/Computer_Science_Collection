package server.account;

import handlers.ErrorHandler;
import handlers.ValidationHandler;
import server.DatabaseHandler;
import server.ToolHandler;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountHandler {
    public static String[] getUserState(String phoneNumber) {
        Connection conn = DatabaseHandler.connect();
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ignored) {}
            String[] userTable = AccountReporter.getUserStateFromUsers(phoneNumber);
            if(userTable != null) return userTable;
            else ErrorHandler.stateRetrievalError();
        } else ErrorHandler.noConnectionError();
        return null;
    }
    public static boolean loginAccount(String phoneNumber, String password) {
        Connection conn = DatabaseHandler.connect();

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ignored) {}
            if(AccountReporter.userExists(phoneNumber)) {
                byte[][] credentials = AccountReporter.getCredentials(phoneNumber);

                if(credentials != null) {
                    try {
                        byte[] hash = PBKDF2Hash(credentials[0], password);

                        if(ValidationHandler.validateHash(credentials[1], hash)) {
                            return true;

                        } else ErrorHandler.passwordMatchError();
                    } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                } else ErrorHandler.credentialsRetrievalError();
            } else ErrorHandler.userDoesNotExistError();
        } else ErrorHandler.noConnectionError();
        return false;
    }
    public static boolean createAccount(String phoneNumber, String password, String name) {
        Connection conn = DatabaseHandler.connect();

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ignored) {}
            if(!AccountReporter.userExists(phoneNumber)) {
                byte[] salt = generateSalt();
                try {
                    byte[] hash = PBKDF2Hash(salt, password);
                    AccountReporter.storeNewAccount(phoneNumber, salt, hash, name, ToolHandler.getCurrentDate());
                    conn.close();
                    return true;

                } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
                    e.printStackTrace();
                }
            } else ErrorHandler.userExistsError();
        } else ErrorHandler.noConnectionError();
        return false;
    }
    private static byte[] generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;

    }
    private static byte[] PBKDF2Hash(byte[] salt, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 64536, 128);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return secretKeyFactory.generateSecret(keySpec).getEncoded();
    }
}
