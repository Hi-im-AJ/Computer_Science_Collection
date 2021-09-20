module vz.server1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens vz.server1 to javafx.fxml;
    exports vz.server1;
}