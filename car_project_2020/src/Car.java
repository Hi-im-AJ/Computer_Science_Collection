import java.util.*;

/**
 * Car
 */
public class Car {
    private String key = "1234";
    private boolean active = false;
    private int currentSpeed = 0;
    private String gear = "N";
    private int clutch = 0;

    static Scanner sc = new Scanner(System.in);

    public Car(String key) {
        this.key = key;
    }

    public boolean startEngine(String keyCode) {
        return this.active = (keyCode.equals(this.key)) ? true : false;
    }

    public boolean stopEngine() {
        return this.active = false;
    }

    public String changeGear(String newGear) {
        if (this.clutch >= 50) {
            if (newGear.toUpperCase().equals("R") || newGear.toUpperCase().equals("N")) {
                return this.gear = newGear;
            } else {
                try {
                    int newIntGear = Integer.parseInt(newGear);
                    if (newIntGear >= 1 && newIntGear <= 5) {
                        return this.gear = Integer.toString(newIntGear);
                    }
                } catch (Exception e) {
                    return this.gear;
                }
            }
        }
        return this.gear;
    }

    public void userInterface() {
        boolean gate = true;
        while (gate) {
            System.out.println("Start engine (cmd: start)");
            System.out.println("Change gear (cmd: gear)");
            System.out.println("Check current speed (cmd: speed)");
            System.out.println("Exit (cmd: exit)\n");
            String input = sc.next().toLowerCase();

            if (input.equals("exit")) {
                gate = false;
            } else if (input.equals("start")) {
                System.out.println("Please enter password:");
                String password = sc.next();
                this.startEngine(password);
                String msg = (this.active) ? "> The engine is on" : "> Incorrect password!";
                System.out.println(msg + "\n");

            } else if (input.equals("gear")) {
                System.out.println("Please enter desired gear:");
                String newGear = sc.next();
                this.changeGear(newGear);
                String msg = (this.gear.equals(newGear)) ? String.format("The gear is now set to: %s", this.gear)
                        : "Please change to an existing gear [R N 1-5] or press the clutch!";
                System.out.println(msg + "\n");
            } else if (input.equals("speed")) {
                System.out.println(String.format("The cars current speed: %s km/t\n", this.currentSpeed));
            } else {
                System.out.println("Input error - try again..");
            }
        }
    }
}