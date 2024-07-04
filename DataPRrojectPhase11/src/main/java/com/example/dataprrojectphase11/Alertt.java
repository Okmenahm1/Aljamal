package com.example.dataprrojectphase11;

import javafx.scene.control.Alert;

public class Alertt{


    // alert calss to handle all of the error or the successful //
    public void addDiscticrAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Duplicated District");
        alert.showAndWait();
    }

    public void addDiscticrsuccsefull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("District added successfully!");
        alert.showAndWait();

    }

    public void districtNotFound(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("District didn't Found");
        alert.showAndWait();

    }

    public void locationNotFound(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Location didn't Found");
        alert.showAndWait();

    }

    public void updateDiscticrAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("District didn't updated");
        alert.showAndWait();
    }

    public void updateDiscticrAlertsuccfell() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("District updated");
        alert.showAndWait();
    }

    public void deleteDiscticrsuccsefull(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("District deleted");
        alert.showAndWait();
    }

    public void deleteDisctict(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("District didn't deleted");
        alert.showAndWait();
    }

    public void addLoactions() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Location didn't Added successfully!");
        alert.showAndWait();

    }

    public void addLoactionsuccsefull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Location added successfully!");
        alert.showAndWait();

    }
    public void updateLoactionsuccsefull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Location Updated successfully!");
        alert.showAndWait();

    }
    public void updateLoaction() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Location didn't updated successfully!");
        alert.showAndWait();

    }


    public void deleteLocationSuccessful() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Location Deleted successfully!");
        alert.showAndWait();

    }

    public void deleteLocation(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Location didn't Deleted successfully!");
        alert.showAndWait();

    }

    public void nolactionfound(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Location didn't Found!");
        alert.showAndWait();
    }

    public void loactionfileds(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Check All Feilds");
        alert.showAndWait();
    }

    public void martyradded(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Martyr Added successfully!");
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

    public void filedEmpty(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Fileds Are Empty !!");
        alert.showAndWait();
    }

    public void invalidage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Invalid Age !!");
        alert.showAndWait();

    }

    public void Martryraddedsucc(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Martyr Added");
        alert.setHeaderText(null);
        alert.setContentText("The martyr has been successfully added.");
        alert.showAndWait();
    }

    public void martyrEditsuccsefull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Martyr Edit successfully!");
        alert.showAndWait();

    }

    public void martyrNotFound(String name){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("No Martyrs Contains " + name + " Not Found !!");
        alert.showAndWait();
    }



    public void fileAdd(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Operation Canceled!!");
        alert.showAndWait();
    }

    public void invalidGender(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erorr");
        alert.setHeaderText(null);
        alert.setContentText("Wrong Gender Format!!");
        alert.showAndWait();
    }
}
