module com.collegeplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.collegeplanner to javafx.fxml;
    exports com.collegeplanner;
}