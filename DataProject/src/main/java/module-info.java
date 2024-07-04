module com.example.dataproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dataproject to javafx.fxml;
    exports com.example.dataproject;
}