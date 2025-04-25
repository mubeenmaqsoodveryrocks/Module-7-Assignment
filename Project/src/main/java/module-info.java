module com.example.module7assignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.prefs;


    opens com.example.module7assignment to javafx.fxml;
    exports com.example.module7assignment;
}