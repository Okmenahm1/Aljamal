package com.example.dataprojectphase1;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker; // Importing DatePicker
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;

public class District {

    private BorderPane borderPane;

    public District() {
        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Label headerLabel = new Label("District Screen");
        headerLabel.setFont(Font.font(25));
        borderPane.setTop(headerLabel);

        Button insertButton = new Button("Insert New District");
        TextField textFieldInsert = new TextField();
        HBox insertBox = new HBox(10);
        insertBox.getChildren().addAll(insertButton, textFieldInsert);
        vbox.getChildren().add(insertBox);

        Button updateButton = new Button("Update District");
        DatePicker datePickerUpdate = new DatePicker(); // Using DatePicker for update
        HBox updateBox = new HBox(10);
        updateBox.getChildren().addAll(updateButton, datePickerUpdate);
        vbox.getChildren().add(updateBox);

        updateButton.setOnAction(e -> {
            // Implement the functionality to update district here
            LocalDate selectedDate = datePickerUpdate.getValue();
            if (selectedDate != null) {
                // Perform the update operation with the selectedDate
                // Example: districtController.updateDistrict(selectedDate);
                System.out.println("District updated with date: " + selectedDate);
            } else {
                System.out.println("Please select a date.");
            }
        });

        Button deleteButton = new Button("Delete District");
        TextField textFieldDelete = new TextField();
        HBox deleteBox = new HBox(10);
        deleteBox.getChildren().addAll(deleteButton, textFieldDelete);
        vbox.getChildren().add(deleteBox);

        Button nextButton = new Button("Next District");
        HBox nextBox = new HBox(10);
        nextBox.getChildren().add(nextButton);
        vbox.getChildren().add(nextBox);

        Button prevButton = new Button("Previous District");
        HBox prevBox = new HBox(10);
        prevBox.getChildren().add(prevButton);
        vbox.getChildren().add(prevBox);

        borderPane.setLeft(vbox);

        VBox statisticsBox = new VBox(5);
        Label statisticsLabel = new Label("(Statistics)");
        Label totalMartyrsLabel = new Label("Total Martyrs: ");
        Label maleFemaleLabel = new Label("Male Martyrs:  Female Martyrs: ");
        Label averageAgeLabel = new Label("Average Martyr Age: ");
        Label maxMartyrsDateLabel = new Label("Date with Max Martyrs: ");
        statisticsBox.getChildren().addAll(statisticsLabel, totalMartyrsLabel, maleFemaleLabel, averageAgeLabel, maxMartyrsDateLabel);
        borderPane.setCenter(statisticsBox);

        Button getDateMartyrsButton = new Button("Get Martyrs for Date");
        Button loadLocationButton = new Button("Load Location");
        VBox buttonBox = new VBox(5);
        buttonBox.getChildren().addAll(getDateMartyrsButton, loadLocationButton);
        borderPane.setRight(buttonBox);
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
}
