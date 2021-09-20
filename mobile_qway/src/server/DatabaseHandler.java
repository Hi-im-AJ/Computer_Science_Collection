package server;

import handlers.ErrorHandler;

import java.sql.*;

public class DatabaseHandler {
    public static Connection connect() {
        String url = "jdbc:sqlite:database.db";
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            ErrorHandler.noConnectionError();
            return null;
        }
    }
    public static void insertIntoTable(String table, String string1, String string2, String string3) {
        Connection conn = connect();
        String sql = String.format("INSERT INTO %s VALUES (?, ?, ?)", table);
        try {
            assert conn != null;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, string1);
            stmt.setString(2, string2);
            stmt.setString(3, string3);
            stmt.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean insertIntoTable(String table, String string1, String string2, String string3, Double double1) {
        Connection conn = connect();
        String sql = String.format("INSERT INTO %s VALUES (?, ?, ?, ?)", table);
        try {
            assert conn != null;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, string1);
            stmt.setString(2, string2);
            stmt.setString(3, string3);
            stmt.setDouble(4, double1);
            stmt.execute();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
