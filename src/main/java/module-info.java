module com.example.simplecalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.simplecalculator to javafx.fxml;
    exports com.example.simplecalculator;
}