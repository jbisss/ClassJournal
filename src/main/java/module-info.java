module com.example.classjournal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.classjournal to javafx.fxml;
    exports com.example.classjournal;
}