module sio.helplerebours {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sio.helplerebours to javafx.fxml;
    exports sio.helplerebours;
}