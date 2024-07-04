package com.example.dataproject;

import javafx.scene.control.Alert;

public class Alertsclass {
// alerts classes //
    public void showAddMartyrAlert(boolean success) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Martyr");
        alert.setHeaderText(null);

        if (success) {
            alert.setContentText("Martyr added successfully!");
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Failed to add martyr. Please check your fields.");
        }

        alert.showAndWait();
    }

    public void showSearchMartyrAlert(boolean success, boolean fields) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Display Martyr");
        alert.setHeaderText(null);

        if (!success && fields) {
            alert.setContentText("No matching martyr found. Please check the entered name.");
        } else if (!success && !fields) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please Check The fields !!!!");
        }

        alert.showAndWait();
    }

    public void showAgeAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Age");
        alert.setHeaderText(null);
        alert.setContentText("Age must be between 0 and 130.");
        alert.showAndWait();
    }


    public void showDelMartyrAlert(boolean success) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete Martyr");
        alert.setHeaderText(null);

        if (success) {
            alert.setContentText("Martyr deleted successfully!");
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("No matching martyr found with the entered name.");
        }

        alert.showAndWait();
    }

    public void showInvalidGenderAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Gender");
        alert.setHeaderText(null);
        alert.setContentText("Gender must be 'M' or 'F'.");
        alert.showAndWait();
    }

    public void showdisplayedmartrys(int number,String selceted) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
          alert.setContentText("The Number Of Martyr Depend On "+selceted +" is: "+number);
        alert.showAndWait();
    }

    public void ifthechoiceisDate() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText("Please If You Want To Check The Date Then Enter The Following Format yyyy-mm-dd");
        alert.showAndWait();
    }

    public void ifthechoiceisemptyfileds() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText("Please Check The Fields!!");
        alert.showAndWait();
    }

    public void ifdatafileload(boolean isload) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        if(isload){
        alert.setContentText("File Data Loaded Successfully");
        }else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("File Data Not Loaded!!");
        }
        alert.showAndWait();
    }
}


