import handlers.ValidationHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidationHandlerTest {
    @Test
    public void validNameMatch() {
        String[] validNameArray = new String[] {"Anders Anderson", "Ib", "Bob Jaeger", "Michael"};
        for (String s : validNameArray) {
            Assertions.assertTrue(ValidationHandler.validateName(s));
        }
    }
    @Test
    public void invalidNameMatch() {
        String[] invalidNameArray = new String[] {"1236", "(/&¤#)", "Ib1234 S(/&¤#)", "Bob_Jaeger"};
        for (String s : invalidNameArray) {
            Assertions.assertFalse(ValidationHandler.validateName(s));
        }
    }
    @Test
    public void validPhoneNumbersMatch() {
        String[] validNumbersArray = new String[] {"11001100", "99999999", "00000000"};
        for (String s : validNumbersArray) {
            Assertions.assertTrue(ValidationHandler.validatePhoneNumber(s));
        }
    }
    @Test
    public void validPasswordMatch() {
        String[] validPasswordsArray = new String[] {"Password1234", "passWord1234", "4321wordPass", "Ab345678"};
        for (String s : validPasswordsArray) {
            Assertions.assertTrue(ValidationHandler.validatePassword(s));
        }
    }
    @Test
    public void invalidPasswordMatch() {
        String[] validPasswordsArray = new String[] {"12345678", "abcdefgh", "ABCDEFGH", "password1234", "PASSWORD1234",
        "1Pa4567"};
        for (String s : validPasswordsArray) {
            Assertions.assertFalse(ValidationHandler.validatePassword(s));
        }
    }
    @Test
    public void validNumberMatch() {
        String[] validNumbersArray = new String[] {"99", "0"};
        for (String s : validNumbersArray) {
            Assertions.assertTrue(ValidationHandler.validateNumber99(s));
        }
    }
    @Test
    public void invalidNumberMatch() {
        String[] invalidNumbersArray = new String[] {"-1", "100", "qwe", "=!)=/(&", "1qwe1"};
        for (String s : invalidNumbersArray) {
            Assertions.assertFalse(ValidationHandler.validateNumber99(s));
        }
    }
    @Test
    public void validHashMatch() {
        byte[] hash = new byte[]{72,85,87,24,86,-73,-107};
        Assertions.assertTrue(ValidationHandler.validateHash(hash, hash));
    }
    @Test
    public void invalidHashMatch() {
        byte[] hash1 = new byte[]{72,85,87,24,86,-73,-107};
        byte[] hash2 = new byte[]{-107,85,87};
        byte[] hash3 = new byte[]{-107,85,-73,86,24,87,72};
        Assertions.assertFalse(ValidationHandler.validateHash(hash1, hash2));
        Assertions.assertFalse(ValidationHandler.validateHash(hash1, hash3));
    }
}
