module com.example.dataproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.dataproject3 to javafx.fxml;
    exports com.example.dataproject3;
}