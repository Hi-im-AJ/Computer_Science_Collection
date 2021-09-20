/**
 * CarTest
 */
public class CarTest {
    public static void main(String[] args) {
        Car car = new Car("1234");

        booleanAssertEquals("Test startEngine: wrong key", false, car.startEngine("qwe"));
        booleanAssertEquals("Test startEngine: correct key", true, car.startEngine("1234"));
        booleanAssertEquals("Test stopEngine", false, car.stopEngine());

        stringAssertEquals("Test changeGear", "R", car.changeGear("R"));
        stringAssertEquals("Test changeGear", "4", car.changeGear("e9wrnhg"));
        stringAssertEquals("Test changeGear", "5", car.changeGear("6"));
        stringAssertEquals("Test changeGear", "1", car.changeGear("0"));
    }

    public static void booleanAssertEquals(String name, boolean expected, boolean actual) {
        String result = (expected == actual) ? "PASS" : "FAIL";
        System.out.println(String.format("%s - %s", name, result));
    }

    public static void stringAssertEquals(String name, String expected, String actual) {
        String result = (expected.equals(actual)) ? "PASS" : "FAIL";
        System.out.println(String.format("%s - %s", name, result));
    }
}
