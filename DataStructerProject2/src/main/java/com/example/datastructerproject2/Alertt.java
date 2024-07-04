package com.example.datastructerproject2;

import javafx.scene.control.Alert;

public class Alertt {


    public void filedEmpty() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Fileds Are Empty !!");
        alert.showAndWait();
    }

    public void DiscticrNotFound() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("District Didnt Found !!");
        alert.showAndWait();
    }

    public void addDiscticrsuccsefull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("District added successfully!");
        alert.showAndWait();

    }

    public void duplicated() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Duplicated Found !!");
        alert.showAndWait();
    }

    public void updateDiscticrAlertsuccfell() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("District updated");
        alert.showAndWait();
    }

    public void deleteDistrictSuccessfull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("District Deleted");
        alert.showAndWait();
    }

    public void notfound(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Not Found !!");
        alert.showAndWait();
    }

    public void addLocationSuccessfull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Location Added successfully!");
        alert.showAndWait();
    }
    public void updateLoactionsuccsefull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Location Updated successfully!");
        alert.showAndWait();

    }
    public void locationDeletedSuccessfull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Location Deleted successfully!");
        alert.showAndWait();
    }

    public void addFile() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Didn't Load Data !!");
        alert.showAndWait();
    }

    public void addFilesucc() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("File loaded successfully!");
        alert.showAndWait();
    }

    public void invalidage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Invalid Age !!");
        alert.showAndWait();

    }
    public void invalidGender(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Wrong Gender Format!!");
        alert.showAndWait();
    }

    public void addMartyrSuccessfully() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Martyr Added Successfully!");
        alert.showAndWait();

    }

}
