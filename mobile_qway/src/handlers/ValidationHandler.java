package handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationHandler {
    public static boolean validateName(String name) {
        Pattern pattern = Pattern.compile("[a-zA-Z ]+");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean validateNumber99(String input) {
        Pattern pattern = Pattern.compile("^\\d{1,2}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static boolean validateNumber(String input) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static boolean validatePositiveNumber(String input) {
        return Double.parseDouble(input) >= 1d;
    }
    public static boolean validateHash(byte[] hash1, byte[] hash2) {
        if(hash1.length != hash2.length) return false;
        for (int i = 0; i < hash1.length; i++) {
            if(hash1[i] != hash2[i]) return false;
        }
        return true;
    }
}