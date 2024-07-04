package com.example.dataproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.Arrays;

public class HelloApplication extends Application {

    int intalsize = 16;  // intial size //
    int size = 0;
    Martyrs[] array = new Martyrs [intalsize];
    Alertsclass alert = new Alertsclass(); // making aAlert class //

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox(10);
                                                // making the panes //
        vBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox);


        Button addButt = new Button("Click To Add Mrtyr");
        Button DelButt = new Button("Click To Delete Martyr"); // buttons //
        Button SearchButt = new Button("Click To Search Mrtyr");
        Button DisplayButt = new Button("Click To Display Mrtyr");

        Button FileChooserButt = new Button("Load File");







        FileChooserButt.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();

            // Set an extension filter for CSV files //
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {
                // Check if the selected file has a ".csv" extension //
                if (file.getName().toLowerCase().endsWith(".csv")) {
                    Filereader(file);
                }
            } else {
                // Display a message if the user canceled the file selection //
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setContentText("Canceled Successfully");
                alert1.showAndWait();
            }
        });



        vBox.getChildren().addAll(addButt,DelButt,SearchButt,DisplayButt,FileChooserButt);


        addButt.setOnAction(e -> addMartyr(stage));

        DelButt.setOnAction(e -> delMartyr(stage));     // handle action for the buttons //

        SearchButt.setOnAction(e -> searchMartyr(stage));

        DisplayButt.setOnAction(e -> displayMartyr(stage));

        System.out.println(array.length);
        System.out.println(size);

        Scene scene = new Scene(borderPane, 320, 240);
        stage.setTitle("Main Stage!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void addMartyr(Stage addStage) { // addmartyr method //
        VBox vbox = new VBox(10);

        TextField nameTextField = new TextField();
        TextField ageTextField = new TextField();
        TextField locationTextField = new TextField();
        DatePicker dateOfDeathPicker = new DatePicker();  // using datepicker to avoid mistakes from users and easy to use //
        TextField genderTextField = new TextField();

        Label nameLabel = new Label("Name:");
        Label ageLabel = new Label("Age:");
        Label locationLabel = new Label("Event location:");
        Label dateOfDeathLabel = new Label("Date of death:");
        Label genderLabel = new Label("Gender:");

        Button backButton = new Button("Back");
        Button submitbutt = new Button("Submit");



        backButton.setOnAction(e -> {
            try {
                start(addStage);  // baking to the main pane //
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });



        submitbutt.setOnAction(e -> {
            checksize();
            Martyrs martyr = new Martyrs(); // making new martyr object //

            if (nameTextField.getText().isEmpty() || locationTextField.getText().isEmpty() || dateOfDeathPicker.getValue() == null || genderTextField.getText().isEmpty()) {
                alert.showAddMartyrAlert(false);  // will check if the fields are empty //
                return;
            }


                int age = Integer.parseInt(ageTextField.getText());

                if (age <= 0 || age > 130) {  // will check the age if valid or not //
                    alert.showAgeAlert();
                    return;
                }

                else {
                    martyr.setAge(age);
                }

            martyr.setNames(nameTextField.getText());
            martyr.setLocation(locationTextField.getText());
            martyr.setDate(dateOfDeathPicker.getValue().toString());
            String gender = genderTextField.getText().toUpperCase();

            if (gender.equals("M") || gender.equals("F")) {
                martyr.setGender(gender.charAt(0));  // the gender should be f or m only //
            } else {
                alert.showInvalidGenderAlert(); // will show alert //
                return;
            }

            array[size] = martyr; // adding the martyr to the array //
            size++; // incremnt the size by one //

            alert.showAddMartyrAlert(true); // showing alert thats the opration gose correct //
        });


        vbox.getChildren().addAll(nameLabel, nameTextField, ageLabel, ageTextField, locationLabel, locationTextField, dateOfDeathLabel,dateOfDeathPicker, genderLabel, genderTextField,submitbutt,backButton);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 450);
        addStage.setTitle("Add Martyr");
        addStage.setScene(scene);
        addStage.show();
    }

    public void delMartyr(Stage delStage) {
        HBox hBox = new HBox(10);

        TextField textField = new TextField();
        Label label = new Label("Enter The Name You Want To Remove");

        Button backButton = new Button("Back");
        Button submitbutt = new Button("Submit");




        backButton.setOnAction(e -> {
            try {
                start(delStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });




        submitbutt.setOnAction(e -> {

            String nameToRemove = textField.getText();
            int removeIndex = -1;


            for (int i = 0; i < array.length; i++) {
                if (array[i] != null && nameToRemove.equals(array[i].getNames())) { // get the index of the traget name //
                    removeIndex = i;
                    break;
                }
            }


            if (removeIndex != -1) {

                for (int i = removeIndex; i < array.length - 1; i++) {
                    array[i] = array[i + 1];  // will transfer the elements to the left //
                }

                    size--; // will delete  the last index of the array //
                alert.showDelMartyrAlert(true);
            }
            else if (textField.getText().isEmpty()) {
                alert.ifthechoiceisemptyfileds();
            }

            else {  // showing alerts //
                alert.showDelMartyrAlert(false);
            }
        });


        hBox.getChildren().addAll(label, textField, submitbutt,backButton);
        hBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(hBox, 500, 150);
        delStage.setTitle("Delete Stage");
        delStage.setScene(scene);
        delStage.show();
    }

    public void searchMartyr(Stage searchStage) {
        HBox hBox = new HBox(10);
        VBox vBox1 = new VBox(10);

        TextField textField = new TextField();
        Label label = new Label("Enter The Name You Want To Search");

        Label showlabel = new Label();

        Button backButton = new Button("Back");
        Button submitbutt = new Button("Submit");


        backButton.setOnAction(e -> {
            try {
                start(searchStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });



        submitbutt.setOnAction(e -> {
            if(textField.getText().isEmpty()){
                alert.showSearchMartyrAlert(false,false);
                return;
            }

            String nametodisplay = textField.getText();

            boolean found = false;

            StringBuilder displayText = new StringBuilder();

            for (Martyrs martyrs : array) {
                if (martyrs != null && nametodisplay.equals(martyrs.getNames())) {
                    displayText.append("Name: ").append(martyrs.getNames()).append("\n");
                    displayText.append("Age: ").append(martyrs.getAge()).append("\n");
                    displayText.append("Event Location: ").append(martyrs.getLocation()).append("\n");
                    displayText.append("Date of Death: ").append(martyrs.getDate()).append("\n");
                    displayText.append("Gender: ").append(martyrs.getGender()).append("\n");

                    showlabel.setText(displayText.toString());
                    found = true;
                    break;
                }
            }

            if (!found) {
                alert.showSearchMartyrAlert(false, true);
            }

        });


        hBox.getChildren().addAll(label, textField, submitbutt,backButton);
        hBox.setAlignment(Pos.CENTER);


        vBox1.getChildren().addAll(hBox,showlabel);



        Scene scene = new Scene(vBox1, 500, 150);
        searchStage.setTitle("Search Stage");
        searchStage.setScene(scene);
        searchStage.show();
    }

    public void displayMartyr(Stage displayStage) {
        HBox hBox = new HBox(10);
        VBox vBox = new VBox(10);
        VBox vBox1 = new VBox(10);



        TextField textField = new TextField();
        Label label = new Label("Display The Number Of Martyrs By Age/gender/date ");

        Label resultLabel = new Label();

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Age","Gender","Date");




        Button backButton = new Button("Back");
        Button submitbutt = new Button("Submit");

        alert.ifthechoiceisDate();  // will show alert to let the user know how to use the date //

        backButton.setOnAction(e -> {
            try {
                start(displayStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });



        submitbutt.setOnAction(e -> {
            int count = 0;
            String choice = "Nothing Selected!!";


            if(textField.getText().isEmpty()){
                alert.ifthechoiceisemptyfileds();
                return;
            }
            
            else {

                if (choiceBox.getValue().equals("Age")) {
                    int agein = Integer.parseInt(textField.getText());
                    choice = "Age";
                    for (int i = 0; i < size; i++) {        // if the choice was age will go here //
                        if (array[i].getAge() == agein) {
                            count++;
                        }
                    }
                }

                if (choiceBox.getValue().equals("Gender")) {
                    String gendertofind = textField.getText();
                    choice = "Gender";

                    for (int i = 0; i < size; i++) {
                        if (String.valueOf(array[i].getGender()).equalsIgnoreCase(gendertofind)) {  // and if gender ill go here //
                            count++;
                        }
                    }
                }

                 if (choiceBox.getValue().equals("Date") ) {
                    String datetofind = textField.getText();
                    choice = "Date";

                    for (int i = 0; i < size; i++) {        // if its date will go here //
                        if (array[i].getDate().equals(datetofind)) {
                            count++;
                        }
                    }
                }

            }

            resultLabel.setText("Number of Martyrs with " + choice + ": " + count);


        });

        hBox.getChildren().addAll(label, textField, submitbutt, backButton);
        hBox.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(hBox);

        vBox.getChildren().addAll(hBox, choiceBox, resultLabel);

        Scene scene = new Scene(vBox, 600, 150);
        displayStage.setTitle("Display Martyrs");
        displayStage.setScene(scene);
        displayStage.show();
    }


    private void checksize() {
        if (size == array.length) { // will check the size of the array if its full wil duoble the size //
            array = Arrays.copyOf(array, array.length * 2);

        }
    }


    public void Filereader(File file) {
        boolean isload = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int age;


            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                    // will check if any line is empty will skip it //

                  if( parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty() || parts[3].trim().isEmpty() || parts[4].trim().isEmpty()){
                      continue;
                  }
                    String names = parts[0].trim();
                    age = Integer.parseInt(parts[1].trim());
                    String location = parts[2].trim();
                    String date = parts[3].trim();
                    char gender = parts[4].trim().charAt(0);

                    Martyrs martyr = new Martyrs(names, age, location, date, gender);

                    checksize();
                    array[size] = martyr;
                    size++;
                    isload = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isload){
            alert.ifdatafileload(isload);
        }else {
            alert.ifdatafileload(isload);
        }
    }
}