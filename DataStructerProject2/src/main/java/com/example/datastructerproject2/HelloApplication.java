package com.example.datastructerproject2;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class HelloApplication extends Application {
    Tab Districttap = new Tab("District");
    Tab Locationtabp = new Tab("Location ");
    Tab Martrystab = new Tab("Martyrs");
    Tab LoadFiletamp = new Tab("File");
    public static DistrictTree districtTree = new DistrictTree();
    public static ComboBox<String> combo = new ComboBox<>();
    public static ComboBox<String> combodelete = new ComboBox<>();
    public static ComboBox<String> combodistrictforlocation = new ComboBox<>();
    public static ComboBox<String> comboforubdatelocations = new ComboBox<>();
    public static ComboBox<String> combodistrictupdatelocations = new ComboBox<>();
    public static Stacklocation currentLevelStack = new Stacklocation();
    public static Stacklocation nextLevelStack = new Stacklocation();
    public static ComboBox<String> combofordeletelocations = new ComboBox<>();
    public static ComboBox<String> combodistricttodeletelocations = new ComboBox<>();
    public static ComboBox<String> combodistrictformartrys = new ComboBox<>();
    public static ComboBox<String> combolocationformartrys = new ComboBox<>();
    public static Stack currentdistrictstack = new Stack();
    public static Stack nextdistrictstack = new Stack();
    public static TableView<Martyr> martyrTable = new TableView<>();
    private static ObservableList<Martyr> martyrData = FXCollections.observableArrayList();
    private static ObservableList<Martyr> martyrDataforsearch = FXCollections.observableArrayList();






    public static Alertt alert = new Alertt();

    @Override
    public void start(Stage stage) throws IOException {

        TabPane tabPane = new TabPane(Districttap, Locationtabp, Martrystab, LoadFiletamp);

        final int[] width = {850};
        final int[] height = {280};

        Districttap.setOnSelectionChanged(event -> {
            if (Districttap.isSelected()) {
                width[0] = 850;
                height[0] = 280;
                stage.setWidth(width[0]);
                stage.setHeight(height[0]);
            }
        });


        Locationtabp.setOnSelectionChanged(event -> {
            if (Locationtabp.isSelected()) {
                width[0] = 1150;
                height[0] = 370;
                stage.setWidth(width[0]);
                stage.setHeight(height[0]);
            }
        });

        LoadFiletamp.setOnSelectionChanged(event -> {
            if (LoadFiletamp.isSelected()) {
                width[0] = 240;
                height[0] = 240;
                stage.setWidth(width[0]);
                stage.setHeight(height[0]);
            }
        });

        LoadFiletamp.setOnSelectionChanged(event -> {
            if (LoadFiletamp.isSelected()) {
                width[0] = 1150;
                height[0] = 370;
                stage.setWidth(width[0]);
                stage.setHeight(height[0]);
            }


        });

        Districttap.setContent(Districtscene());
        Locationtabp.setContent(Locationscreen());
        Martrystab.setContent(MartyrsSecene());
        LoadFiletamp.setContent(Filee());

        Scene scene = new Scene(tabPane, width[0], height[0]);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public static BorderPane Districtscene() {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15));

        HBox inserthBox = new HBox(10);
        inserthBox.setPadding(new Insets(10));
        inserthBox.setAlignment(Pos.CENTER);

        Button inserbutton = new Button("Insert");
        Button backbutton = new Button("Back");
        TextField districtnametxt = new TextField();
        districtnametxt.setPromptText("Enter The Name Of District");
        inserthBox.getChildren().addAll(new Label("District Name:"), districtnametxt, inserbutton, backbutton);

        backbutton.setOnAction(actionEvent -> {
            districtTree.inorderPrint();
        });

        inserbutton.setOnAction(actionEvent -> {
            if (districtnametxt.getText().isEmpty()) {
                alert.filedEmpty();
                districtnametxt.clear();
                return;
            }

            String districtName = districtnametxt.getText().trim();

            if (districtTree.find(districtName) != null) {
                alert.duplicated();
                districtnametxt.clear();
                return;
            }

            District district = new District(districtName);
            districtTree.insert(district);
            updatecombo(combodistricttodeletelocations);
            updatecombo(combo);
            updatecombo(combodelete);
            updatecombo(combodistrictforlocation);
            updatecombo(combodistrictupdatelocations);
            updatecombo(combodistrictformartrys);
            stackupdatedisctrict(currentdistrictstack);

            alert.addDiscticrsuccsefull();
            districtnametxt.clear();
        });

        HBox updatehBox1 = new HBox(10);
        updatehBox1.setPadding(new Insets(10));
        updatehBox1.setAlignment(Pos.CENTER);

        Button updatebutton = new Button("Update");
        TextField olddistrictupdatetxt = new TextField();
        olddistrictupdatetxt.setEditable(false);
        TextField newdistrictupdatetxt = new TextField();
        olddistrictupdatetxt.setPromptText("Old District");
        newdistrictupdatetxt.setPromptText("Enter New District");

        combo.setOnAction(actionEvent -> {
            olddistrictupdatetxt.setText(combo.getSelectionModel().getSelectedItem());
        });

        updatehBox1.getChildren().addAll(new Label("Old District:"), olddistrictupdatetxt, new Label("New District:"), newdistrictupdatetxt, combo, updatebutton);

        updatebutton.setOnAction(actionEvent -> {
            if (olddistrictupdatetxt.getText().isEmpty() || newdistrictupdatetxt.getText().isEmpty()) {
                alert.filedEmpty();
                olddistrictupdatetxt.clear();
                newdistrictupdatetxt.clear();
                return;
            }
            String olddistrict = olddistrictupdatetxt.getText().trim();
            String newdistrict = newdistrictupdatetxt.getText().trim();

            if (districtTree.find(newdistrict) != null) {
                alert.duplicated();
                olddistrictupdatetxt.clear();
                newdistrictupdatetxt.clear();
                return;
            } else if (districtTree.find(olddistrict) == null) {
                alert.DiscticrNotFound();
                olddistrictupdatetxt.clear();
                newdistrictupdatetxt.clear();
                return;
            }
            if (districtTree.find(olddistrict) != null && districtTree.find(newdistrict) == null) {
                Node oldDistrictNode = districtTree.find(olddistrict);

                districtTree.delete(oldDistrictNode.getData());

                District oldDistrict = (District) oldDistrictNode.getData();
                oldDistrict.setDistrictName(newdistrict);

                districtTree.insert(oldDistrict);

                alert.updateDiscticrAlertsuccfell();
                olddistrictupdatetxt.clear();
                newdistrictupdatetxt.clear();
                updatecombo(combodistricttodeletelocations);
                updatecombo(combo);
                updatecombo(combodelete);
                updatecombo(combodistrictforlocation);
                updatecombo(combodistrictupdatelocations);
                updatecombo(combodistrictformartrys);
            }
        });

        HBox deletehbox = new HBox(10);
        deletehbox.setPadding(new Insets(10));
        deletehbox.setAlignment(Pos.CENTER);

        Button deletedestrictbut = new Button("Delete");
        TextField deletedistricttxt = new TextField();
        deletedistricttxt.setEditable(false);
        deletehbox.getChildren().addAll(new Label("Select District to Delete:"), combodelete, deletedistricttxt, deletedestrictbut);

        combodelete.setOnAction(actionEvent -> {
            deletedistricttxt.setText(combodelete.getSelectionModel().getSelectedItem());
        });

        deletedestrictbut.setOnAction(actionEvent -> {
            String districtNameToDelete = deletedistricttxt.getText().trim();
            if (districtNameToDelete.isEmpty()) {
                alert.filedEmpty();
                return;
            }
            Node districtNodeToDelete = districtTree.find(districtNameToDelete);
            if (districtNodeToDelete != null) {
                District districtToDelete = (District) districtNodeToDelete.getData();
                districtTree.delete(districtToDelete);
                alert.deleteDistrictSuccessfull();
                deletedistricttxt.clear();
                updatecombo(combodistricttodeletelocations);
                updatecombo(combo);
                updatecombo(combodelete);
                updatecombo(combodistrictforlocation);
                updatecombo(combodistrictupdatelocations);
                updatecombo(combodistrictformartrys);
                stackupdatedisctrict(currentdistrictstack);
            } else {
                alert.notfound();
            }
        });

        HBox nextprevhbox = new HBox(10);
        nextprevhbox.setPadding(new Insets(10));
        nextprevhbox.setAlignment(Pos.CENTER);

        Button nextbutton = new Button("Next");
        Button prevbutton = new Button("Prev");
        TextField textFieldnextprevtxt = new TextField();
        textFieldnextprevtxt.setEditable(false);
        nextprevhbox.getChildren().addAll(prevbutton, textFieldnextprevtxt, nextbutton);

        VBox vboxfornext = new VBox(10);
        vboxfornext.setPadding(new Insets(10));
        vboxfornext.setAlignment(Pos.CENTER);

        Label totalnumberofmartyrslabel = new Label("Total number of martyrs:");
        TextField totalnumberofmartyrtxt = new TextField();
        totalnumberofmartyrtxt.setEditable(false);
        vboxfornext.getChildren().addAll(nextprevhbox, new HBox(10, totalnumberofmartyrslabel, totalnumberofmartyrtxt));

        nextbutton.setOnAction(actionEvent -> {
            nextdistrictstack.push(currentdistrictstack.peek());
            textFieldnextprevtxt.setText(String.valueOf(currentdistrictstack.pop()));
            String district = textFieldnextprevtxt.getText().trim();
            totalnumberofmartyrtxt.setText(String.valueOf(Totalnumberofmartyrsindistrict(district)));

            if (textFieldnextprevtxt.getText().equalsIgnoreCase("null")) {
                textFieldnextprevtxt.setText("Has Reached All Districts");
            }
        });

        prevbutton.setOnAction(actionEvent -> {
            currentdistrictstack.push(nextdistrictstack.peek());
            textFieldnextprevtxt.setText(String.valueOf(nextdistrictstack.pop()));
            String district = textFieldnextprevtxt.getText().trim();
            totalnumberofmartyrtxt.setText(String.valueOf(Totalnumberofmartyrsindistrict(district)));

            if (textFieldnextprevtxt.getText().equalsIgnoreCase("null")) {
                textFieldnextprevtxt.setText("No More Previous Districts");
            }
        });

        vBox.getChildren().addAll(inserthBox, updatehBox1, deletehbox, vboxfornext);

        borderPane.setCenter(vBox);
        return borderPane;
    }


    public static BorderPane Locationscreen() {
        BorderPane borderPane = new BorderPane();
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(15));
        vbox.setAlignment(Pos.CENTER);

        // Insert Location Section
        HBox inserthbox = new HBox(10);
        inserthbox.setPadding(new Insets(10));
        inserthbox.setAlignment(Pos.CENTER);

        Button insertlocationbut = new Button("Insert Location");
        insertlocationbut.setShape(new Rectangle(100, 20));
        insertlocationbut.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        insertlocationbut.setFont(Font.font("Arial", 14));

        TextField locationaddtext = new TextField();
        locationaddtext.setPromptText("Enter Location Name");
        inserthbox.getChildren().addAll(new Label("Choose District:"), combodistrictforlocation, new Label("Location Name:"), locationaddtext, insertlocationbut);

        insertlocationbut.setOnAction(actionEvent -> {
            String selecteddistrict = combodistrictforlocation.getSelectionModel().getSelectedItem();
            String locationname = locationaddtext.getText().trim();
            if (selecteddistrict == null) {
                alert.filedEmpty();
                return;
            }

            Node districtnode = districtTree.find(selecteddistrict);
            District district1 = (District) districtnode.getData();

            if (locationname.isEmpty()) {
                alert.filedEmpty();
                return;
            }

            if (district1.getLocations().find(locationname) != null) {
                alert.duplicated();
                return;
            }

            Location location = new Location(locationname);
            district1.getLocations().insert(location);
            updatestack(currentLevelStack);
            stackUpdateLocation(currentLevelStack, districtTree.getRoot());
            alert.addLocationSuccessfull();
            locationaddtext.clear();
        });

        // Update Location Section
        HBox updatehBox1 = new HBox(10);
        updatehBox1.setPadding(new Insets(10));
        updatehBox1.setAlignment(Pos.CENTER);

        Button updatebutton = new Button("Update");
        updatebutton.setShape(new Rectangle(100, 20));
        updatebutton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white;");
        updatebutton.setFont(Font.font("Arial", 14));

        ComboBox<String> oldlocationcombo = new ComboBox<>();
        TextField newlocationupdatetxt = new TextField();
        TextField districtlocatriontoupdate = new TextField();
        oldlocationcombo.setPromptText("Old Location");
        newlocationupdatetxt.setPromptText("Enter New Location");
        districtlocatriontoupdate.setPromptText("District");
        districtlocatriontoupdate.setEditable(false);

        combodistrictupdatelocations.setOnAction(actionEvent -> {
            districtlocatriontoupdate.setText(combodistrictupdatelocations.getSelectionModel().getSelectedItem());
            updatecombolocations(oldlocationcombo, combodistrictupdatelocations.getSelectionModel().getSelectedItem());
        });

        updatehBox1.getChildren().addAll(new Label("District:"), combodistrictupdatelocations, new Label("Old Location:"), oldlocationcombo, new Label("New Location:"), newlocationupdatetxt, updatebutton);

        updatebutton.setOnAction(actionEvent -> {
            if (oldlocationcombo.getSelectionModel().getSelectedItem().isEmpty() || newlocationupdatetxt.getText().isEmpty()) {
                alert.filedEmpty();
                oldlocationcombo.getSelectionModel().clearSelection();
                newlocationupdatetxt.clear();
                return;
            }
            String oldlocation = oldlocationcombo.getSelectionModel().getSelectedItem();
            String newlocation = newlocationupdatetxt.getText().trim();
            String districtname = combodistrictupdatelocations.getSelectionModel().getSelectedItem();
            District district = (District) districtTree.find(districtname).getData();

            if (district.getLocations().find(newlocation) != null) {
                alert.duplicated();
                oldlocationcombo.getSelectionModel().clearSelection();
                newlocationupdatetxt.clear();
                return;
            } else if (district.getLocations().find(oldlocation) == null) {
                alert.notfound();
                oldlocationcombo.getSelectionModel().clearSelection();
                newlocationupdatetxt.clear();
                return;
            }
            if (district.getLocations().find(oldlocation) != null && district.getLocations().find(newlocation) == null) {
                Node oldLocationNode = district.getLocations().find(oldlocation);

                district.getLocations().delete(oldLocationNode.getData());

                Location oldLocation = (Location) oldLocationNode.getData();
                oldLocation.setLocationName(newlocation);

                district.getLocations().insert(oldLocation);

                stackUpdateLocation(currentLevelStack, districtTree.getRoot());
                alert.updateLoactionsuccsefull();
                oldlocationcombo.getSelectionModel().clearSelection();
                newlocationupdatetxt.clear();

                updatecombolocations(oldlocationcombo, district.getDistrictName());
            }
        });

        // Delete Location Section
        HBox deletelocationhbox = new HBox(10);
        deletelocationhbox.setPadding(new Insets(10));
        deletelocationhbox.setAlignment(Pos.CENTER);

        Button deletelocationbutton = new Button("Delete");
        deletelocationbutton.setShape(new Rectangle(100, 20));
        deletelocationbutton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white;");
        deletelocationbutton.setFont(Font.font("Arial", 14));

        TextField districttxt = new TextField();
        districttxt.setPromptText("District");
        districttxt.setEditable(false);
        TextField locationtodeletetxt = new TextField();
        locationtodeletetxt.setPromptText("Location");
        locationtodeletetxt.setEditable(false);
        deletelocationhbox.getChildren().addAll(new Label("District:"), combodistricttodeletelocations, new Label("Location:"), combofordeletelocations, districttxt, locationtodeletetxt, deletelocationbutton);

        combodistricttodeletelocations.setOnAction(actionEvent -> {
            districttxt.setText(combodistricttodeletelocations.getSelectionModel().getSelectedItem());
            updatecombolocations(combofordeletelocations, combodistricttodeletelocations.getSelectionModel().getSelectedItem());
        });

        combofordeletelocations.setOnAction(actionEvent -> {
            locationtodeletetxt.setText(combofordeletelocations.getSelectionModel().getSelectedItem());
        });

        deletelocationbutton.setOnAction(actionEvent -> {
            String locationtodeletename = locationtodeletetxt.getText().trim();
            String districtname = districttxt.getText().trim();

            if (locationtodeletetxt.getText().isEmpty() || districttxt.getText().isEmpty()) {
                alert.filedEmpty();
                return;
            }

            Node districtNode = districtTree.find(districtname);
            if (districtNode == null) {
                alert.notfound();
                return;
            }

            District district = (District) districtNode.getData();
            if (district != null) {
                Node locationNodeToDelete = district.getLocations().find(locationtodeletename);
                if (locationNodeToDelete != null) {
                    Location location = (Location) locationNodeToDelete.getData();
                    district.getLocations().delete(location);
                    alert.locationDeletedSuccessfull();
                    updatecombolocations(combofordeletelocations, district.getDistrictName());
                    stackUpdateLocation(currentLevelStack, districtTree.getRoot());
                } else {
                    alert.notfound();
                }
            }
        });

        // Next/Prev Location Section
        HBox nextprevhbox = new HBox(10);
        nextprevhbox.setPadding(new Insets(10));
        nextprevhbox.setAlignment(Pos.CENTER);

        Button nextbutt = new Button("Next");
        nextbutt.setShape(new Rectangle(100, 20));
        nextbutt.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        nextbutt.setFont(Font.font("Arial", 14));

        Button prevbutt = new Button("Previous");
        prevbutt.setShape(new Rectangle(100, 20));
        prevbutt.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        prevbutt.setFont(Font.font("Arial", 14));

        TextField currentlocationtxt = new TextField();
        currentlocationtxt.setPrefSize(100, 25);
        TextField Theearliestdatethathasmartyrstxt = new TextField();
        TextField The_latest_dates_that_has_martyrstxt = new TextField();
        TextField The_date_that_has_the_maximum_number_of_martyrstxt = new TextField();
        currentlocationtxt.setEditable(false);
        Theearliestdatethathasmartyrstxt.setEditable(false);
        The_latest_dates_that_has_martyrstxt.setEditable(false);
        The_date_that_has_the_maximum_number_of_martyrstxt.setEditable(false);

        nextprevhbox.getChildren().addAll(
                prevbutt,
                nextbutt,
                new Label("Current Location:"), currentlocationtxt,
                new Label("Earliest Date:"), Theearliestdatethathasmartyrstxt,
                new Label("Latest Date:"), The_latest_dates_that_has_martyrstxt,
                new Label("Date with Maximum Martyrs:"), The_date_that_has_the_maximum_number_of_martyrstxt
        );

        nextbutt.setOnAction(actionEvent -> {
            nextLevelStack.push(currentLevelStack.peek());
            currentlocationtxt.setText(String.valueOf(currentLevelStack.pop()));
            The_latest_dates_that_has_martyrstxt.setText(Theearliestdatethathasmartyrs(currentlocationtxt.getText().trim()));
            Theearliestdatethathasmartyrstxt.setText(Thelatestdatethathasmartyrs(currentlocationtxt.getText().trim()));
            The_date_that_has_the_maximum_number_of_martyrstxt.setText(TheDateWithMostMartyrs(currentlocationtxt.getText().trim()));
            if (currentlocationtxt.getText().equalsIgnoreCase("null")) {
                currentlocationtxt.setText("Has Reached All Locations");
            }
        });

        prevbutt.setOnAction(actionEvent -> {
            currentLevelStack.push(nextLevelStack.peek());
            currentlocationtxt.setText(String.valueOf(nextLevelStack.pop()));
            The_latest_dates_that_has_martyrstxt.setText(Theearliestdatethathasmartyrs(currentlocationtxt.getText().trim()));
            Theearliestdatethathasmartyrstxt.setText(Thelatestdatethathasmartyrs(currentlocationtxt.getText().trim()));

            if (currentlocationtxt.getText().equalsIgnoreCase("null")) {
                currentlocationtxt.setText("No More Previous Locations");
            }
        });

        vbox.getChildren().addAll(inserthbox, updatehBox1, deletelocationhbox, nextprevhbox);

        borderPane.setCenter(vbox);
        return borderPane;
    }



    public static BorderPane MartyrsSecene() {
        BorderPane borderPane = new BorderPane();
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        VBox insertVBox = new VBox(10);
        insertVBox.setPadding(new Insets(10));
        insertVBox.setAlignment(Pos.CENTER);

        Button insertButton = new Button("Insert");
        TextField martyrnametxt = new TextField();
        DatePicker datepicker = new DatePicker();
        TextField martyragetxt = new TextField();
        TextField martyrlocationtxt = new TextField();
        TextField martyrdistricttxt = new TextField();
        TextField martyrgendertxt = new TextField();

        insertVBox.getChildren().addAll(
                new Label("Name:"), martyrnametxt,
                new Label("Date:"), datepicker,
                new Label("Age:"), martyragetxt,
                new Label("Location:"), martyrlocationtxt,
                new Label("District:"), martyrdistricttxt,
                new Label("Gender:"), martyrgendertxt,
                new Label("District:"), combodistrictformartrys,
                new Label("Location:"), combolocationformartrys,
                insertButton
        );

        combodistrictformartrys.setOnAction(actionEvent -> {
            updatecombolocations(combolocationformartrys, combodistrictformartrys.getSelectionModel().getSelectedItem());
            martyrdistricttxt.setText(combodistrictformartrys.getSelectionModel().getSelectedItem());
        });

        combolocationformartrys.setOnAction(actionEvent -> {
            martyrlocationtxt.setText(combolocationformartrys.getSelectionModel().getSelectedItem());
        });

        insertButton.setOnAction(actionEvent -> {
            if (martyrnametxt.getText().trim().isEmpty() || datepicker.getValue() == null || martyragetxt.getText().trim().isEmpty() || martyrlocationtxt.getText().trim().isEmpty() || martyrdistricttxt.getText().trim().isEmpty() || martyrgendertxt.getText().trim().isEmpty()) {
                alert.filedEmpty();
                return;
            }

            String martyrname = martyrnametxt.getText().trim();
            LocalDate localDate = datepicker.getValue();
            String martyrdistrict = martyrdistricttxt.getText().trim();
            String martyrlocation = martyrlocationtxt.getText().trim();
            String martyrgender = martyrgendertxt.getText().trim();

            int martyrAge;
            try {
                martyrAge = Integer.parseInt(martyragetxt.getText().trim());
            } catch (NumberFormatException ex) {
                alert.invalidage();
                return;
            }

            if (martyrAge <= 0 || martyrAge > 125) {
                alert.invalidage();
                return;
            }

            if (!martyrgender.equalsIgnoreCase("Male") && !martyrgender.equalsIgnoreCase("Female") && !martyrgender.equalsIgnoreCase("M") && !martyrgender.equalsIgnoreCase("F")) {
                alert.invalidGender();
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String martyrdate = localDate.format(formatter);
            Date date = new Date(martyrdate);
            MartyrDate martyrDate = new MartyrDate(date);

            Node districtNode = districtTree.find(martyrdistrict);
            District district;
            if (districtNode == null) {
                district = new District(martyrdistrict);
                districtTree.insert(district);
            } else {
                district = (District) districtNode.getData();
            }

            Node locationNode = district.getLocations().find(martyrlocation);
            Location location;
            if (locationNode == null) {
                location = new Location(martyrlocation);
                district.getLocations().insert(location);
            } else {
                location = (Location) locationNode.getData();
            }

            Node martyrDateNode = location.getMartyrDatetree().find(martyrDate);
            if (martyrDateNode == null) {
                martyrDate = new MartyrDate(date);
                location.getMartyrDatetree().insert(martyrDate);
            } else {
                martyrDate = (MartyrDate) martyrDateNode.getData();
            }

            Martyr martyr = new Martyr(martyrname, martyrdate, martyrAge, martyrlocation, martyrdistrict, martyrgender);
            martyrDate.getLinkedList().addMartyr(martyr);
            martyrData.add(martyr);
            alert.addMartyrSuccessfully();
        });

        HBox hboxdelete = new HBox(10);
        hboxdelete.setPadding(new Insets(10));
        hboxdelete.setAlignment(Pos.CENTER);

        Button deleteButton = new Button("Delete");
        TextField nameofmartyrtodeletetxt = new TextField();
        nameofmartyrtodeletetxt.setPromptText("Name of Martyr");
        DatePicker datePicker1 = new DatePicker();

        hboxdelete.getChildren().addAll(new Label("Martyr Name:"), nameofmartyrtodeletetxt, new Label("Date:"), datePicker1, deleteButton);

        deleteButton.setOnAction(actionEvent -> {
            if (nameofmartyrtodeletetxt.getText().isEmpty() || datePicker1.getValue() == null) {
                alert.filedEmpty();
                return;
            }

            String martyrname = martyrnametxt.getText().trim();
            String districtname = combodistrictformartrys.getSelectionModel().getSelectedItem();
            String locationname = combolocationformartrys.getSelectionModel().getSelectedItem();
            LocalDate localDate = datePicker1.getValue();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String martyrdate = localDate.format(formatter);
            Date date = new Date(martyrdate);
            MartyrDate martyrDate = new MartyrDate(date);

            deleteMartyrs(martyrname, districtname, locationname, martyrDate);
        });

        HBox hboxupdate = new HBox(10);
        hboxupdate.setPadding(new Insets(10));
        hboxupdate.setAlignment(Pos.CENTER);

        Button updateButton = new Button("Update");
        TextField nameofmartyrtoupdatetxt = new TextField();
        nameofmartyrtoupdatetxt.setPromptText("Name of Martyr");
        TextField newnametxt = new TextField();
        newnametxt.setPromptText("Enter New Name");

        hboxupdate.getChildren().addAll(new Label("Martyr Name:"), nameofmartyrtoupdatetxt, new Label("New Name:"), newnametxt, updateButton);

        updateButton.setOnAction(actionEvent -> {
            String oldname = nameofmartyrtoupdatetxt.getText().trim();
            String newname = newnametxt.getText().trim();
            String districtname = combodistrictformartrys.getSelectionModel().getSelectedItem();
            String locationname = combolocationformartrys.getSelectionModel().getSelectedItem();

            // Add your update logic here
        });

        HBox searchhbox = new HBox(10);
        searchhbox.setPadding(new Insets(10));
        searchhbox.setAlignment(Pos.CENTER);

        Button searchbutt = new Button("Search");
        TextField nameofmartyrtosearchtxt = new TextField();
        nameofmartyrtosearchtxt.setPromptText("Name of Martyr");

        searchhbox.getChildren().addAll(new Label("Martyr Name:"), nameofmartyrtosearchtxt, searchbutt);

        searchbutt.setOnAction(actionEvent -> {
            if (nameofmartyrtosearchtxt.getText().isEmpty()) {
                alert.filedEmpty();
                return;
            }
            String martyrname = nameofmartyrtosearchtxt.getText().trim();
            String districtname = combodistrictformartrys.getSelectionModel().getSelectedItem();
            String locationname = combolocationformartrys.getSelectionModel().getSelectedItem();

            martyrTable.getItems().clear();
            searchMartyrs(martyrname, districtname, locationname);
            martyrTable.setItems(martyrDataforsearch);
        });

        vbox.getChildren().addAll(insertVBox, hboxdelete, hboxupdate, searchhbox);

        borderPane.setCenter(vbox);
        borderPane.setRight(martyrTable);
        initializeMartyrTable();
        return borderPane;
    }


    public VBox Filee() {
        VBox vBox = new VBox();

        Button button = new Button("Load Data");
        vBox.getChildren().add(button);
        vBox.setAlignment(Pos.CENTER);

        button.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();

            File desktopDirectory = new File(System.getProperty("user.home"), "Desktop");


            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel", "*.csv"));
            fileChooser.setInitialDirectory(desktopDirectory);

            File file = fileChooser.showOpenDialog(null);

            if (file == null) {
                alert.addFile();
                return;
            }


            Filereader(file);
            alert.addFilesucc();
        });

        return vBox;
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
                Date date = new Date(dateOfMartyr);

                MartyrDate martyrdate = new MartyrDate(date);

                Node districtNode = districtTree.find(districtName);
                District district;
                if (districtNode == null) {
                    district = new District(districtName);
                    districtTree.insert(district);
                } else {
                    district = (District) districtNode.getData();
                }

                Node locationNode = district.getLocations().find(locationName);
                Location location;
                if (locationNode == null) {
                    location = new Location(locationName);
                    district.getLocations().insert(location);
                } else {
                    location = (Location) locationNode.getData();
                }


                Node martyrDateNode = location.getMartyrDatetree().find(martyrdate);
                MartyrDate martyrDate;
                if (martyrDateNode == null) {
                    martyrDate = new MartyrDate(date);
                    location.getMartyrDatetree().insert(martyrDate);
                } else {
                    martyrDate = (MartyrDate) martyrDateNode.getData();
                }


                Martyr martyr = new Martyr(name, dateOfMartyr, age, locationName, districtName, gender);
                martyrdate.getLinkedList().addMartyr(martyr);
                martyrData.add(martyr);





            }





            updatecombo(combodistricttodeletelocations);
            updatecombo(combo);
            updatecombo(combodelete);
            updatecombo(combodistrictforlocation);
            updatecombo(combodistrictupdatelocations);
            updatecombo(combodistrictformartrys);
            updatestack(currentLevelStack);
            stackupdatedisctrict(currentdistrictstack);
            stackUpdateLocation(currentLevelStack,districtTree.getRoot());


        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }







    private static void initializeMartyrTable() {
        TableColumn<Martyr, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Martyr, String> dateColumn = new TableColumn<>("Date of Martyr");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Martyr, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Martyr, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Martyr, String> districtColumn = new TableColumn<>("District");
        districtColumn.setCellValueFactory(new PropertyValueFactory<>("district"));

        TableColumn<Martyr, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        martyrTable.getColumns().clear();
        martyrTable.getColumns().addAll(nameColumn, dateColumn, ageColumn, locationColumn, districtColumn, genderColumn);
        martyrTable.setItems(martyrData);
        martyrTable.setPrefWidth(600);
        nameColumn.setPrefWidth(200);
    }








    public static void updatecombo(ComboBox<String> combodelete) {
        combodelete.getItems().clear();
        ArrayList<String> districtNames = districtTree.combodistrict();
        combodelete.getItems().addAll(districtNames);
    }

    public static void updatecombolocations(ComboBox<String> combolocation, String district) {
        District district1 = (District) districtTree.find(district).getData();
        if (district1 == null) {
            return;
        }
        combolocation.getItems().clear();
        ArrayList<String> districtNames = district1.getLocations().combolocation();
        combolocation.getItems().addAll(districtNames);
    }


    public static void updatestack(Stacklocation stacklocation) {
        updatestack(districtTree.getRoot(), stacklocation);
    }

    private static void updatestack(Node districtNode, Stacklocation stacklocation) {
        if (districtNode == null) {
            return;
        }

        District district = (District) districtNode.getData();


        traverseLocationPushNodes(district.getLocations().getRoot(), stacklocation);


        updatestack(districtNode.getLeft(), stacklocation);
        updatestack(districtNode.getRight(), stacklocation);
    }

    private static void traverseLocationPushNodes(Node locationNode, Stacklocation stacklocation) {
        if (locationNode == null) {
            return;
        }


        traverseLocationPushNodes(locationNode.getLeft(), stacklocation);
        traverseLocationPushNodes(locationNode.getRight(), stacklocation);
    }

    public static void updatecombolocations(ComboBox<String> combo) {
        updatecombolocations(districtTree.getRoot(), combo);
    }

    public static void updatecombolocations(Node node, ComboBox<String> combo) {
        if (node != null) {
            District district = (District) node.getData();
            if (district != null) {
                ArrayList<String> locationNames = district.getLocations().combolocation();
                combo.getItems().addAll(locationNames);
            }

            updatecombolocations(node.getLeft(), combo);
            updatecombolocations(node.getRight(), combo);
        }
    }



    public static void stackupdatedisctrict(Stack stack) {
        updatestackdistrict(districtTree.getRoot(), stack); // for district names nextprev//
    }

    private static void updatestackdistrict(Node districtNode, Stack stack) {
        if (districtNode == null) {
            return;
        }

        District district = (District) districtNode.getData(); // for districts name nextpprev //
        stack.push(district);

        updatestackdistrict(districtNode.getLeft(), stack);
        updatestackdistrict(districtNode.getRight(), stack);
    }










    public static void stackUpdateLocation(Stacklocation stack, Node districtTreeRoot) { // nextprev locations //
        if (districtTreeRoot == null) {
            return;
        }

        // Traverse the district tree and call stackUpdateLocation for each district node //
        traverseDistrictTreeAndUpdateStack(districtTreeRoot, stack);
    }



    private static void updateStackLocation(Node locationNode, Stacklocation stack) {
        if (locationNode == null) {
            return;
        }

        Location location = (Location) locationNode.getData(); // Get location from the node //
        stack.push(location); // Push location onto the stack //

        // Recursively traverse left and right nodes of the location tree  //
        updateStackLocation(locationNode.getLeft(), stack);
        updateStackLocation(locationNode.getRight(), stack);
    }

    private static void traverseDistrictTreeAndUpdateStack(Node currentNode, Stacklocation stack) {
        if (currentNode == null) {
            return;
        }

        District district = (District) currentNode.getData(); // Get the district from the current node //

        // Update the stack with locations in the current district //
        updateStackLocation(district.getLocations().getRoot(), stack);

        // Recursively call this method for left and right children to traverse the entire district tree //
        traverseDistrictTreeAndUpdateStack(currentNode.getLeft(), stack);
        traverseDistrictTreeAndUpdateStack(currentNode.getRight(), stack);
    }













    public static int Totalnumberofmartyrsindistrict(String districtname) {
        // Find the district node in the districtTree //
        Node districtNode = districtTree.find(districtname);


        if (districtNode == null) {
            return 0;
        }


        District district = (District) districtNode.getData();


        int totalMartyrs = 0;

        // go through each location in the district //
        totalMartyrs = traverseLocationCountMartyrs(district.getLocations().getRoot(), totalMartyrs);

        return totalMartyrs;
    }

    private static int traverseLocationCountMartyrs(Node locationNode, int totalMartyrs) {
        if (locationNode == null) {
            return totalMartyrs;
        }


        Location location = (Location) locationNode.getData();

        MartyrDatetree martyrDateTree = location.getMartyrDatetree();


        int martyrsInLocation = countMartyrsInTree(martyrDateTree.getRoot());

        // Add the count to the total number of martyrs //
        totalMartyrs += martyrsInLocation;

        // go left and right nodes //
        totalMartyrs = traverseLocationCountMartyrs(locationNode.getLeft(), totalMartyrs);
        totalMartyrs = traverseLocationCountMartyrs(locationNode.getRight(), totalMartyrs);

        return totalMartyrs;
    }

    private static int countMartyrsInTree(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }

        return 1 + countMartyrsInTree(rootNode.getLeft()) + countMartyrsInTree(rootNode.getRight());
    }







    public static String Theearliestdatethathasmartyrs(String locationName) {

        Node districtTreeRoot = districtTree.getRoot();
        MartyrDate earliestMartyrDate = findEarliestDateInLocation(districtTreeRoot, locationName);


        if (earliestMartyrDate != null) {
            return earliestMartyrDate.toString();
        } else {
            return null;
        }
    }

    private static MartyrDate findEarliestDateInLocation(Node districtNode, String locationName) {
        if (districtNode == null) {
            return null;
        }

        District district = (District) districtNode.getData();

        // Traverse the location tree of the current district
        Node locationRoot = district.getLocations().getRoot();
        MartyrDate earliestDate = findLocationAndEarliestDate(locationRoot, locationName);


        if (earliestDate != null) {
            return earliestDate;
        }


        MartyrDate leftResult = findEarliestDateInLocation(districtNode.getLeft(), locationName);
        if (leftResult != null) {
            return leftResult;
        }
        return findEarliestDateInLocation(districtNode.getRight(), locationName);
    }

    private static MartyrDate findLocationAndEarliestDate(Node locationNode, String locationName) {
        if (locationNode == null) {
            return null;
        }

        Location location = (Location) locationNode.getData();
        if (location.getLocationName().equals(locationName)) {

            return findEarliestDateInTree(location.getMartyrDatetree().getRoot());
        }


        MartyrDate leftResult = findLocationAndEarliestDate(locationNode.getLeft(), locationName);
        if (leftResult != null) {
            return leftResult;
        }
        return findLocationAndEarliestDate(locationNode.getRight(), locationName);
    }

    private static MartyrDate findEarliestDateInTree(Node rootNode) {
        if (rootNode == null) {
            return null;
        }

        MartyrDate rootDate = (MartyrDate) rootNode.getData();


        MartyrDate leftEarliest = findEarliestDateInTree(rootNode.getLeft());
        MartyrDate rightEarliest = findEarliestDateInTree(rootNode.getRight());


        MartyrDate earliest = rootDate;
        if (leftEarliest != null && leftEarliest.getMartyrDate().before(earliest.getMartyrDate())) {
            earliest = leftEarliest;
        }
        if (rightEarliest != null && rightEarliest.getMartyrDate().before(earliest.getMartyrDate())) {
            earliest = rightEarliest;
        }

        return earliest;
    }










    public static String Thelatestdatethathasmartyrs(String locationName) {

        Node districtTreeRoot = districtTree.getRoot();
        MartyrDate latestMartyrDate = findLatestDateInLocation(districtTreeRoot, locationName);


        if (latestMartyrDate != null) {
            return latestMartyrDate.toString();
        } else {
            return null;
        }
    }

    private static MartyrDate findLatestDateInLocation(Node districtNode, String locationName) {
        if (districtNode == null) {
            return null;
        }

        District district = (District) districtNode.getData();


        Node locationRoot = district.getLocations().getRoot();
        MartyrDate latestDate = findLocationAndLatestDate(locationRoot, locationName);


        if (latestDate != null) {
            return latestDate;
        }

        // Recursively left and right districts //
        MartyrDate leftResult = findLatestDateInLocation(districtNode.getLeft(), locationName);
        if (leftResult != null) {
            return leftResult;
        }
        return findLatestDateInLocation(districtNode.getRight(), locationName);
    }

    private static MartyrDate findLocationAndLatestDate(Node locationNode, String locationName) {
        if (locationNode == null) {
            return null;
        }

        Location location = (Location) locationNode.getData();
        if (location.getLocationName().equals(locationName)) {
            // If the location is found, find the latest date in the martyr date tree //
            return findLatestDateInTree(location.getMartyrDatetree().getRoot());
        }

        // search in left and right locations //
        MartyrDate leftResult = findLocationAndLatestDate(locationNode.getLeft(), locationName);
        if (leftResult != null) {
            return leftResult;
        }
        return findLocationAndLatestDate(locationNode.getRight(), locationName);
    }

    private static MartyrDate findLatestDateInTree(Node rootNode) {
        if (rootNode == null) {
            return null;
        }

        MartyrDate rootDate = (MartyrDate) rootNode.getData();


        MartyrDate latest = rootDate;


        return latest;
    }







    public static String TheDateWithMostMartyrs(String locationName) {

        Node districtTreeRoot = districtTree.getRoot(); // get the root of districttree //
        MartyrDate dateWithMostMartyrs = findDateWithMostMartyrsInLocation(districtTreeRoot, locationName);


        if (dateWithMostMartyrs != null) {
            return dateWithMostMartyrs.toString();
        } else {
            return null; // Return null if no martyrs were found //
        }
    }

    private static MartyrDate findDateWithMostMartyrsInLocation(Node districtNode, String locationName) {
        if (districtNode == null) {
            return null; // Return null if district node is not found //
        }

        District district = (District) districtNode.getData();

        // Traverse the location tree of the current district //
        Node locationRoot = district.getLocations().getRoot();
        MartyrDate dateWithMostMartyrs = findLocationAndDateWithMostMartyrs(locationRoot, locationName);


        if (dateWithMostMartyrs != null) {
            return dateWithMostMartyrs;
        }


        MartyrDate leftResult = findDateWithMostMartyrsInLocation(districtNode.getLeft(), locationName);
        if (leftResult != null) {
            return leftResult;
        }
        return findDateWithMostMartyrsInLocation(districtNode.getRight(), locationName);
    }

    private static MartyrDate findLocationAndDateWithMostMartyrs(Node locationNode, String locationName) {
        if (locationNode == null) {
            return null;
        }

        Location location = (Location) locationNode.getData();
        if (location.getLocationName().equals(locationName)) {
            return findDateWithMostMartyrsInTree(location.getMartyrDatetree().getRoot());
        }


        MartyrDate leftResult = findLocationAndDateWithMostMartyrs(locationNode.getLeft(), locationName);
        if (leftResult != null) {
            return leftResult;
        }
        return findLocationAndDateWithMostMartyrs(locationNode.getRight(), locationName);
    }

    private static MartyrDate findDateWithMostMartyrsInTree(Node rootNode) {
        MartyrDate result = new MartyrDate();
        result = null;
        findDateWithMostMartyrsHelper(rootNode, result);
        return result;
    }

    private static void findDateWithMostMartyrsHelper(Node node, MartyrDate result) {
        if (node == null) {
            return;
        }

        MartyrDate martyrDate = (MartyrDate) node.getData();
        int martyrCount = martyrDate.getLinkedList().getSize();

        if (result == null || martyrCount > result.getLinkedList().getSize()) {
            result = martyrDate;
        }


        findDateWithMostMartyrsHelper(node.getLeft(), result);
        findDateWithMostMartyrsHelper(node.getRight(), result);
    }









    public static void deleteMartyrs(String martyrname,String district,String location,MartyrDate date){
        if(districtTree.find(district) == null){
            alert.notfound();
            System.out.println("District not found");
            return;
        }
       District district1 = (District) districtTree.find(district).getData();
        if(district1.getLocations().find(location) == null){
            alert.notfound();
            System.out.println("L<ocation not found");
            return;
        }
        Location location1 = (Location) district1.getLocations().find(location).getData();


        Node martyrDateNode = location1.getMartyrDatetree().find(date);
        if(martyrDateNode == null){
            alert.notfound();
            System.out.println("Martyr not found");
            return;
        }
        MartyrDate foundMartyrDate = (MartyrDate) martyrDateNode.getData();
        foundMartyrDate.getLinkedList().deleteMartyr(martyrname);
        alert.deleteDistrictSuccessfull();



    }






    public static void searchMartyrs(String name, String district, String location) {
        martyrDataforsearch.clear();


        Node districtNode = districtTree.find(district);
        if (districtNode == null) {
            alert.notfound();
            return;
        }

        District districtData = (District) districtNode.getData();


        Node locationNode = districtData.getLocations().find(location);
        if (locationNode == null) {
            alert.notfound();
            return;
        }

        Location locationData = (Location) locationNode.getData();


        traverseMartyrDateTreeForSearch(locationData.getMartyrDatetree().getRoot(), name);

        martyrTable.setItems(martyrDataforsearch);

    }

    private static void traverseMartyrDateTreeForSearch(Node martyrDateNode, String name) {
        if (martyrDateNode == null) {
            return;
        }

        MartyrDate martyrDate = (MartyrDate) martyrDateNode.getData();
        Martyr current = martyrDate.getLinkedList().getHead();

        if (current != null) {
            do {
                if (current.getName().toLowerCase().contains(name.toLowerCase())) {
                    martyrDataforsearch.add(current);
                }
                current = (Martyr) current.getNext();
            } while (current != martyrDate.getLinkedList().getHead());
        }

        traverseMartyrDateTreeForSearch(martyrDateNode.getLeft(), name);
        traverseMartyrDateTreeForSearch(martyrDateNode.getRight(), name);
    }






}





