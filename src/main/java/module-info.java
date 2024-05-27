module com.collegeplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.mail;

    opens com.collegeplanner to javafx.fxml;
    exports com.collegeplanner;
}