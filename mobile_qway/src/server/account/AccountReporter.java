package server.account;

import server.DatabaseHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountReporter {
    private static final String codeSplitter = "&#&";

    public static boolean userExists(String phoneNumber) {
        Connection conn = DatabaseHandler.connect();
        String sql = "SELECT * FROM users WHERE phone_number=?";
        try {
            assert conn != null;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            ResultSet resultSet = stmt.executeQuery();
            conn.close();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }
    protected static byte[][] getCredentials(String phoneNumber) {
        Connection conn = DatabaseHandler.connect();
        String sql = "SELECT * FROM credentials WHERE phone_number=?";
        try {
            assert conn != null;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                byte[] salt = translateEncoding(resultSet.getString(2));
                byte[] hash = translateEncoding(resultSet.getString(3));
                conn.close();
                return new byte[][]{salt, hash};
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected static String[] getUserStateFromUsers(String phoneNumber) {
        Connection conn = DatabaseHandler.connect();
        String sql = "SELECT * FROM users WHERE phone_number=?";
        try {
            assert conn != null;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                String[] result = new String[]{resultSet.getString("phone_number"),
                    resultSet.getString("name"), resultSet.getString("registration_date")};
                conn.close();
                return result;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected static void storeNewAccount(String phoneNumber, byte[] salt, byte[] hash, String name, String date) {
        DatabaseHandler.insertIntoTable("users", phoneNumber, name, date);
        DatabaseHandler.insertIntoTable("credentials", phoneNumber, translateEncoding(salt), translateEncoding(hash));
    }

    protected static String translateEncoding(byte[] code) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : code) {
            stringBuilder.append(b).append(codeSplitter);
        }
        return stringBuilder.toString();
    }
    protected static byte[] translateEncoding(String code) {
        String[] byteString = code.split(codeSplitter);
        byte[] byteArray = new byte[byteString.length];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = Byte.parseByte(byteString[i]);
        }
        return byteArray;
    }
}
