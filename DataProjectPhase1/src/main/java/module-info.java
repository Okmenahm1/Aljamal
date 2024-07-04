module com.example.dataprojectphase1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dataprojectphase1 to javafx.fxml;
    exports com.example.dataprojectphase1;
}