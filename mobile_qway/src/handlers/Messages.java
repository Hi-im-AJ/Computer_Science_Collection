package handlers;

public class Messages {
    public static void transferSuccess(String amount, String target) {
        System.out.printf("%s was successfully transfered to %s\n", amount, target);
    }
}
