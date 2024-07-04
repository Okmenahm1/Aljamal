module com.example.datastructerproject2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.datastructerproject2 to javafx.fxml;
    exports com.example.datastructerproject2;
}