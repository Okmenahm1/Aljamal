module com.example.dataprrojectphase11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dataprrojectphase11 to javafx.fxml;
    exports com.example.dataprrojectphase11;
}