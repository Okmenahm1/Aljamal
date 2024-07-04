package com.example.dataproject3;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;

public class HelloController {
    private HashTable hashTable = new HashTable();
    Alertt alert = new Alertt();
    int index = -1;
    int treesize = 0;
    int hegiht = 0;
    TextField tf = new TextField();











    @FXML
    private TextField martyrtodelete;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem menuItemOpen;

    @FXML
    private MenuItem menuItemSaveAs;

    @FXML
    private TextField totalMartyrsTextFiled;

    @FXML
    private Button insertNewDateButton;

    @FXML
    private TextField datenextprevtxt;

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private DatePicker datePicker1;

    @FXML
    private DatePicker datePicker2;

    @FXML
    private DatePicker datePicker3;

    @FXML
    private Button updateDateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private DatePicker datePicker4;

    @FXML
    private TableView<String> tableView;

    @FXML
    private Label datelabel;

    @FXML
    private TableColumn<String, String> hashTableColumn;



    @FXML
    private Button prevButton;

    @FXML
    private Button nextButton;

    @FXML
    private TextField averageMartyrsTextField;

    @FXML
    private TextField districtTextField;

    @FXML
    private TextField locationTextField;

    @FXML
    private Button LoadButton;

    @FXML
    private ComboBox<String> comboBoxdistrict;
    @FXML
    private ComboBox<String> comboBoxlocation;

    @FXML
    private Button insertMartyrButton;

    @FXML
    private Button printButton;

    @FXML
    private TextField martyrnametext;

    @FXML
    private DatePicker datepickeraddmartyr;

    @FXML
    private TextField agetext;

    @FXML
    private TextField districttext;

    @FXML
    private TextField locationtext;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private Button deletebutton;

    @FXML
    private ComboBox<String> combonamesdelete;

    @FXML
    private Button sizebutt;

    @FXML
    private TextField sizetext;

    @FXML
    private Button highetbutt;

    @FXML
    private TextField highettext;

    @FXML
    private Button printbutt;

    @FXML
    private TableView<String> tableView1;

    private TextField martyrtextttt = new TextField();



    @FXML
    private void initialize() {
        genderGroup = new ToggleGroup();
        try {
            femaleRadioButton.setToggleGroup(genderGroup);
            maleRadioButton.setToggleGroup(genderGroup);
        }catch (Exception e){
            System.out.println("");
        }


        hashTableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        try {
            Image gifImage = new Image(getClass().getResource("/com/example/dataproject3/image.gif").toExternalForm());
            backgroundImageView.setImage(gifImage);
        } catch (Exception e) {
            System.err.println("");
        }
    }



    @FXML
    void handleInsertNewDateButtonAction(ActionEvent event) {
        LocalDate newDate = datePicker1.getValue();
        if (newDate == null) {
            alert.showAlert("Error", "No Date IsSelected");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formattedDate = newDate.format(formatter);

        hashTable.insert(formattedDate);
        alert.showSuAlert("Success", "Inserted Date Successfully");




        
    }


    @FXML
    public void handleUpdateDateButtonAction(ActionEvent event) {
        LocalDate oldDate = datePicker2.getValue();
        LocalDate newDate = datePicker3.getValue();

        if (newDate == null || oldDate == null) {
            alert.showAlert("Error", "No Date IsSelected");
            return;
        }

        if(oldDate.isEqual(newDate)) {
            alert.showAlert("Error", "Old Date Already Selected");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formattedoldDate = oldDate.format(formatter);
        String formattedDate = newDate.format(formatter);

        if (hashTable.search(formattedDate) != null){
            alert.showAlert("Error", "Old Date Already Excited Cant Change To This Date!!");
            return;
        }

        if(hashTable.search(formattedoldDate) == null){
            alert.showAlert("Error", "No Record Found");
            return;
        }else {
            MartyrDate martyrDate = hashTable.search(formattedoldDate);
            martyrDate.setDate(formattedDate);
            alert.showSuAlert("Success", "Record Updated Successfully");
        }

    }

    @FXML
    void handleDeleteButtonAction(ActionEvent event) {
        LocalDate date = datePicker4.getValue();
        if(date == null) {
            alert.showAlert("Error", "No Date IsSelected");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formatteddate = date.format(formatter);
        if (hashTable.search(formatteddate) == null){
            alert.showAlert("Error", "No Record Found");
            return;
        }
        hashTable.delete(formatteddate);
        alert.showSuAlert("Success", "Record Deleted Successfully");

    }

    @FXML
    void handlePrevButtonAction(ActionEvent event) {
        if(index == -1){
            alert.showAlert("Error", "No Record Found");
            return;
        }
        index--;
        MartyrDate[] arr = hashTable.getTable();
        if (index < 0) {
            alert.showAlert("Error", "You Have Reached The Beginning!");
            index = 0;
        }
        else if (arr[index] == null) {
            int prevIndex = hashTable.getPreviousNonNullIndex(index);

            if (prevIndex != -1) {
                index = prevIndex;
            }
            else {
                alert.showAlert("Error", "No previous entries found!");
                return;
            }
        }

        datenextprevtxt.setText(arr[index].getDate());
        districtTextField.setText(hashTable.districthavemostmartyrs(datenextprevtxt.getText()));
        locationTextField.setText(hashTable.locationhavemostmartyrs(datenextprevtxt.getText()));
        updateMartyrDetails(arr[index]);
    }

    @FXML
    void handleNextButtonAction(ActionEvent event) {
        index++;
        MartyrDate[] arr = hashTable.getTable();
        if (index >= arr.length) {
            alert.showAlert("Error", "You Have Reached The End!");
            index = arr.length - 1;
        }
        else if (arr[index] == null) {
            int nextIndex = hashTable.getNextNonNullIndex(index);

            if (nextIndex != -1) {
                index = nextIndex;
            }
            else {
                alert.showAlert("Error", "No next entries found!");
                return;
            }
        }

        datenextprevtxt.setText(arr[index].getDate());
        districtTextField.setText(hashTable.districthavemostmartyrs(datenextprevtxt.getText()));
        locationTextField.setText(hashTable.locationhavemostmartyrs(datenextprevtxt.getText()));
        updateMartyrDetails(arr[index]);
    }

    private void updateMartyrDetails(MartyrDate martyrDate) {
        if (martyrDate != null) {
            if (totalMartyrsTextFiled == null) {
                System.out.println("totalMartyrsTextFiled is null");
            } else {
                totalMartyrsTextFiled.setText(String.valueOf(martyrDate.getAvlTree().size()));
            }
            martyrDate.getAvlTree().printTree();
        }
    }



    @FXML
    void handleMenuItemOpenAction(ActionEvent event) throws IOException {
       File();
    }

    @FXML
    void handleMenuItemSaveAsAction(ActionEvent event) {
        // Implement the action for Save As menu item
    }

    @FXML
    void handleLoadButton(ActionEvent event) throws IOException {
        if (datenextprevtxt.getText().isEmpty()){
            alert.showAlert("Error", "Can't Load Without A Date!!!");
            return;
        }

        // Load the new scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Martyrscreen.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 750, 500);
        Stage stage = new Stage();
        stage.setTitle("Martyr Screen");
        stage.setScene(scene);
        stage.show();

        HelloController controller = fxmlLoader.getController();

        if (controller == null) {
            System.err.println("Controller is null");
            return;
        }

        // Create MartyrDate object from the current date text
        String dateText = datenextprevtxt.getText();
        tf.setText(dateText);
        MartyrDate martyrDate = hashTable.search(dateText);

        if (martyrDate != null) {
            controller.martyrtextttt.setText(martyrDate.getDate());
            controller.datelabel.setText("You Are Inserting In: " + martyrDate.getDate());
            controller.comboBoxdistrict.getItems().addAll(martyrDate.getAvlTree().districtlist);
            controller.comboBoxlocation.getItems().addAll(martyrDate.getAvlTree().locationlist);
            controller.hashTable = hashTable;
            controller.treesize = treesize;
            controller.hegiht = hegiht;
            controller.combonamesdelete.getItems().addAll(martyrDate.getAvlTree().martyrsList);

        }
    }



    @FXML
    void handlePrintButtonAction(ActionEvent event) {
        List<String> dataList = hashTable.printTable();
        tableView.getItems().clear();
        tableView.setItems(FXCollections.observableArrayList(dataList));

    }





    public void Filereader(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Skipping the first line if it's a header
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                // Check if any field is empty and skip such lines
                if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty() || parts[3].trim().isEmpty() || parts[4].trim().isEmpty() || parts[5].trim().isEmpty()) {
                    continue;
                }

                String name = parts[0].trim();
                String dateOfMartyr = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                String locationName = parts[3].trim();
                String districtName = parts[4].trim();
                String gender = parts[5].trim();



                Martyr martyr = new Martyr(name, dateOfMartyr, age, locationName, districtName, gender);


                hashTable.insert(dateOfMartyr);
                MartyrDate martyrDate = hashTable.search(dateOfMartyr);
                if(martyrDate != null) {
                    martyrDate.getAvlTree().insert(martyr);
                }



            }

            alert.showSuAlert("Success", "Record Inserted Successfully");
            System.out.println(hashTable.getSize());
            System.out.println(hashTable.getCapacity());

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void File(){
        FileChooser fileChooser = new FileChooser();

        File desktopDirectory = new File(System.getProperty("user.home"), "Desktop");


        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel","*.csv"));
        fileChooser.setInitialDirectory(desktopDirectory);

        File file = fileChooser.showOpenDialog(null);


        if (file == null) {
            alert.showAlert("Error", "No File Selected");
            return;
        }

        Filereader(file);

    }



    @FXML
    void handleInsertMartyrAction(ActionEvent event) {
        String formattedDate = martyrtextttt.getText().trim();


        String martyrname = martyrnametext.getText().trim();
        if (martyrname.isEmpty()) {
            alert.showAlert("Error", "Please enter a martyr's name");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(agetext.getText().trim());
        } catch (NumberFormatException e) {
            alert.showAlert("Error", "Invalid Age Entered");
            return;
        }
        if (age < 0 || age > 100) {
            alert.showAlert("Error", "Invalid Age Entered");
            return;
        }

        String district = districttext.getText().trim();
        if (district.isEmpty()) {
            alert.showAlert("Error", "Please enter a district");
            return;
        }

        String location = locationtext.getText().trim();
        if (location.isEmpty()) {
            alert.showAlert("Error", "Please enter a location");
            return;
        }

        String gender;
        if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else {
            alert.showAlert("Error", "Please select a gender");
            return;
        }

        Martyr martyr = new Martyr(martyrname,formattedDate,age,location,district,gender);

        MartyrDate martyrDate = hashTable.search(formattedDate);

        if (martyrDate != null){
            martyrDate.getAvlTree().insert(martyr);
            combonamesdelete.getItems().clear();
            combonamesdelete.getItems().addAll(martyrDate.getAvlTree().martyrsList);
            alert.showSuAlert("Success", "Martyr information inserted successfully");
        }else {
            alert.showAlert("Error", "Martyr Didnt added!!");
        }



    }


    @FXML
    void handleComboDistrictAction(ActionEvent event){
      districttext.setText(comboBoxdistrict.getSelectionModel().getSelectedItem());

    }

    @FXML
    void handleComboLocationAction(ActionEvent event){
        locationtext.setText(comboBoxlocation.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleComboMartyrsAction(ActionEvent event){
        if (combonamesdelete.getSelectionModel().getSelectedItem() == null){
            return;
        }
        martyrtodelete.setText(combonamesdelete.getSelectionModel().getSelectedItem());
    }


    @FXML
    void handleTreeSizeAction(ActionEvent event){
        MartyrDate martyrDate = hashTable.search(martyrtextttt.getText().trim());
        if (martyrDate != null){
            sizetext.setText(String.valueOf(martyrDate.getAvlTree().size()));
        }

    }


    @FXML
    void handleTreeHeghitAction(ActionEvent event){
        MartyrDate martyrDate = hashTable.search(martyrtextttt.getText().trim());
        if (martyrDate != null){
            highettext.setText(String.valueOf(martyrDate.getAvlTree().height()));
        }
    }

    @FXML
    void handleDeleteMartyrAction(ActionEvent event) {
        String date = martyrtextttt.getText().trim();
        String martyrName = martyrtodelete.getText().trim();


        if (martyrName.isEmpty()) {
            alert.showAlert("Error", "Please Select the martyr's name");
            return;
        }

        MartyrDate martyrDate = hashTable.search(date);

        if (martyrDate != null) {
            martyrDate.getAvlTree().delete(martyrName);
            alert.showSuAlert("Success", "Martyr Deleted Successfully");
            combonamesdelete.getItems().remove(martyrName);
            martyrtodelete.clear();

        } else {
            alert.showAlert("Error", "Martyr not found or not deleted");
            martyrtodelete.clear();
        }
    }








}