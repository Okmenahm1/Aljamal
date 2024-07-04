package com.example.dataprrojectphase11;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelloApplication extends Application {

    Tab Districttap = new Tab("District");
    Tab Locationtabp = new Tab("Location ");
    Tab LoadFiletamp = new Tab("File");
    static TextField Totalnumbermartyrstext = new TextField();
    static TextField Totalnumberofmaleandfemalemartyrstext = new TextField();
    static TextField Averagemartyrsagestext = new TextField();
    static TextField Thedatehathasthemaximumnumberofmartyrstext = new TextField();
    static TextField Districtnametext = new TextField();

    static int index = -1;
    static int indexlocation = 0;

    static int districtIndex = 0;




    static Alertt alertt = new Alertt();
    public static DistrictLinkedList districtLinkedList = new DistrictLinkedList();
    public static District district = new District();
    public static Location location = new Location();


    @Override
    public void start(Stage stage) throws IOException {

        final int[] width = {850};
        final int[] height = {280};

        TabPane tabPane = new TabPane(Districttap, Locationtabp, LoadFiletamp);

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






        Districttap.setContent(Districtsc());
        Locationtabp.setContent(Locationscreen());
        LoadFiletamp.setContent(Filee());


        Scene scene = new Scene(tabPane, width[0], height[0]);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public static BorderPane Districtsc() {

        BorderPane borderPane = new BorderPane();

        VBox vBox = new VBox(10);

        Button newdistrictbutt = new Button("Insert New Ditrict");

        TextField insertnewdisctirctext = new TextField();
        insertnewdisctirctext.setPromptText("Enter The Name OF District");

        Button button = new Button("CLick me");

        button.setOnAction(e ->{

        });


        HBox hBoxinsert = new HBox(newdistrictbutt, insertnewdisctirctext,button);


        newdistrictbutt.setOnAction(e -> {
            String districtName = insertnewdisctirctext.getText().trim(); // get the name //
            if (insertnewdisctirctext.getText().isEmpty()) {
                alertt.filedEmpty();  // check fileds if empty //
                return;
            }


            if (districtLinkedList.getDistrictByName(districtName) == null) {
                district = new District(districtName);  // if the firstrict not found then make new one //
                districtLinkedList.addDistrict(district); // and add it to the linkedlist //
                alertt.addDiscticrsuccsefull();
            } else {
                alertt.addDiscticrAlert();  // show alert that the operation gose correct //
            }



        });


        Button updatedistrictbutt = new Button("Update District");

        TextField updatedistrict = new TextField();
        updatedistrict.setPromptText("Enter The Name you want to change");

        TextField updatetodistrict = new TextField();
        updatetodistrict.setPromptText("Enter The New Name");

        HBox hBoxupdatedistrict = new HBox(updatedistrictbutt, updatedistrict, updatetodistrict);


        updatedistrictbutt.setOnAction(e -> {
            String oldDistrictName = updatedistrict.getText().trim();
            String newDistrictName = updatetodistrict.getText().trim();

            if (oldDistrictName.isEmpty() || newDistrictName.isEmpty()) {
                alertt.filedEmpty();
                return;
            }


            District oldDistrict = districtLinkedList.getDistrictByName(oldDistrictName);
            if(oldDistrict == null){ // check if its excited  //
                alertt.updateDiscticrAlert();
                return;
            }

            else {
                oldDistrict.setName(newDistrictName); // here will change the name //
                alertt.updateDiscticrAlertsuccfell();
            }




        });


        Button deletedistrictbutt = new Button("Delete District");

        TextField deltedisctirtext = new TextField();
        deltedisctirtext.setPromptText("Enter Name Of District");

        HBox hBoxdeltedistrict = new HBox(deletedistrictbutt, deltedisctirtext);

        deletedistrictbutt.setOnAction(e -> {
            String districtName = deltedisctirtext.getText().trim();

            if(districtName.isEmpty()){
                alertt.filedEmpty();
                return;
            }

            District districtToDelete = districtLinkedList.getDistrictByName(districtName);
            if(districtToDelete == null){
                alertt.deleteDisctict();
                return;
            }
            else if(districtLinkedList.deleteDistrict(districtToDelete)){
                    alertt.deleteDiscticrsuccsefull();
            }





        });


        Button getthetotalnumberofmartyrsbutt = new Button("get the total number of martyrs");

        DatePicker datePicker = new DatePicker();

        datePicker.setPromptText("Select a date");

        TextField TotalMartyrtext = new TextField();

        HBox hBoxtogetmartyr = new HBox(getthetotalnumberofmartyrsbutt, datePicker, TotalMartyrtext);

        getthetotalnumberofmartyrsbutt.setOnAction(e -> {
            LocalDate selectedDate = datePicker.getValue();

            if(selectedDate == null){
                alertt.filedEmpty();
                return;
            }

            int districtssize = districtLinkedList.getSize();
            int totalmartrysdate = 0;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // change the format //
            String formattedDate = selectedDate.format(formatter);

            for (int i = 0; i < districtssize; i++) {
                int locationsize = districtLinkedList.getDistrict(i).getLocations().getSize();
                 // move on evrey each ditrict //
                for (int j = 0; j < locationsize; j++) {
                    int martryrssize = districtLinkedList.getDistrict(i).getLocations().getLocation(j).getMartyrs().getSize();
                    // move on evrey each location //
                    for (int k = 0; k < martryrssize; k++) {
                        // move on evrey martry in evrey district //
                        Martyr currentMartyr = districtLinkedList.getDistrict(i).getLocations().getLocation(j).getMartyrs().getMartyrByIndex(k);

                        if (currentMartyr.getDate().equals(formattedDate)) {
                            totalmartrysdate++;
                        }
                    }
                }
            }

            TotalMartyrtext.setText(String.valueOf(totalmartrysdate));
        });



        HBox nextprehbox = new HBox(10);
        HBox nextprevlabelshbox = new HBox(5);



        Totalnumbermartyrstext.setPromptText("Total number of martyrs: ");


        Totalnumberofmaleandfemalemartyrstext.setPromptText("Total number of Male martyrs: Total Number Of Female Martys: ");


        Averagemartyrsagestext.setPromptText("Average martyrs ages: ");


        Thedatehathasthemaximumnumberofmartyrstext.setPromptText("The date that has the maximum number of martyrs: ");

        nextprevlabelshbox.getChildren().addAll(nextprehbox, Totalnumbermartyrstext, Totalnumberofmaleandfemalemartyrstext, Averagemartyrsagestext, Thedatehathasthemaximumnumberofmartyrstext,Districtnametext);


        Button nextbut = new Button("Next");
        Button prevbut = new Button("Previous");




        nextbut.setOnAction(e -> {

            index++;
            if (index < districtLinkedList.getSize()) {
                District district = districtLinkedList.getDistrict(index);


                Totalnumbermartyrstext.setText("Total Martrys: " + martyrsindistrict());

                Districtnametext.setText(district.getName());

                Totalnumberofmaleandfemalemartyrstext.setText("Males: " + malefemalemartrysindisctrict("male") + " Females: " + malefemalemartrysindisctrict("female"));

                Averagemartyrsagestext.setText("Average Ages: " +  averagemartyrsages());


                if(martyrsindistrict() == 0){
                    Thedatehathasthemaximumnumberofmartyrstext.setText("No Martrys Found");
                }else
                Thedatehathasthemaximumnumberofmartyrstext.setText(thedatehavethemostmartrys());



            } else {
                // If index goes up the first go the first district  //
                index = -1;
            }
        });


        prevbut.setOnAction(e -> {
            index--;
            if (index >= 0) {
                District district = districtLinkedList.getDistrict(index);
                Totalnumbermartyrstext.setText("Total Martrys: " + martyrsindistrict());

                Districtnametext.setText(district.getName());

                Totalnumberofmaleandfemalemartyrstext.setText("Males: " + malefemalemartrysindisctrict("male") + " Females: " + malefemalemartrysindisctrict("female"));

                Averagemartyrsagestext.setText("Average Ages: " +  averagemartyrsages());

                if(martyrsindistrict() == 0){
                    Thedatehathasthemaximumnumberofmartyrstext.setText("No Martrys Found");
                }else
                Thedatehathasthemaximumnumberofmartyrstext.setText(thedatehavethemostmartrys());

            } else {

                index = districtLinkedList.getSize();
            }
        });


        nextprehbox.getChildren().addAll(prevbut, nextbut);





        vBox.getChildren().addAll(hBoxinsert, hBoxupdatedistrict, hBoxdeltedistrict, nextprevlabelshbox, hBoxtogetmartyr);
        vBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox);

        return borderPane;
    }


    public static BorderPane Locationscreen() {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox(10);


        Button newlocationbutt = new Button("Add Loaction");

        TextField disctricttext = new TextField();
        disctricttext.setPromptText("Insert Disctrict Name");

        TextField newlocationtext = new TextField();
        newlocationtext.setPromptText("Insert New Loaction Name");

        HBox hBoxnewloaction = new HBox(newlocationbutt, disctricttext, newlocationtext);

        newlocationbutt.setOnAction(e -> {
            String locationName = newlocationtext.getText().trim();
            String districtName = disctricttext.getText().trim();

            if(locationName.isEmpty() || districtName.isEmpty()){
                alertt.filedEmpty();
                alertt.addLoactions();
                return;
            }

            District district = districtLinkedList.getDistrictByName(districtName);
            if (district == null) { // will chekc if the dsitrict is there //
                district = new District(districtName);
                districtLinkedList.addDistrict(district);
            }

            Location location = district.getLocations().getLocationByName(locationName);
            if (location == null) {  // check if the lcoation is there //
                location = new Location(locationName);
                district.getLocations().addLoaction(location);

                alertt.addLoactionsuccsefull();
            }else
                alertt.addLoactions();



        });


        Button updatebutt = new Button("Update Loaction");

        TextField districtupdatetext = new TextField();
        districtupdatetext.setPromptText("District Name");

        TextField oldloactiontext = new TextField();
        oldloactiontext.setPromptText("Enter Old Name");

        TextField newloactiontext = new TextField();
        newloactiontext.setPromptText("Enter New Name");

        HBox hBoxupdateloaction = new HBox(updatebutt, districtupdatetext,oldloactiontext, newloactiontext);


        updatebutt.setOnAction(e -> {

        String districtName = districtupdatetext.getText().trim();
        String oldLocationName = oldloactiontext.getText().trim();
        String newLocationName = newloactiontext.getText().trim();

        if (districtName.isEmpty() || oldLocationName.isEmpty() || newLocationName.isEmpty()) {
            alertt.filedEmpty();
            return;
        }

        District districtToUpdate = districtLinkedList.getDistrictByName(districtName);
        if (districtToUpdate == null) {
            alertt.districtNotFound(); // will get the location from dsitrict //
            return;
        }

        Location locationToUpdate = districtToUpdate.getLocations().getLocationByName(oldLocationName);
        if (locationToUpdate != null) { // will check if the location is there //
            if (districtToUpdate.getLocations().getLocationByName(newLocationName) != null) {
                alertt.updateLoaction();
                return;
            }

            locationToUpdate.setName(newLocationName); // change it //
            alertt.updateLoactionsuccsefull();
        } else {
            alertt.locationNotFound();
        }
    });


        Button deltebutt = new Button("Delete Loaction");

        TextField deltedistricttext = new TextField();
        deltedistricttext.setPromptText("Enter District Name");

        TextField deltelocationtext = new TextField();
        deltelocationtext.setPromptText("Enter Loaction Name");

        HBox hBoxdelteloaction = new HBox(deltebutt,deltedistricttext ,deltelocationtext);

        deltebutt.setOnAction(e -> {
            String districtName = deltedistricttext.getText().trim();
            String locationNameToDelete = deltelocationtext.getText().trim();

            if (districtName.isEmpty() || locationNameToDelete.isEmpty()) {
                alertt.filedEmpty();
                return;
            }

            District districtToDelete = districtLinkedList.getDistrictByName(districtName);
            if (districtToDelete == null) {
                alertt.districtNotFound();
                return;
            }

            Location locationToDelete = districtToDelete.getLocations().getLocationByName(locationNameToDelete);
            if (locationToDelete == null) {
                alertt.locationNotFound();
                return;
            }

            // Delete the location from the district //
            districtToDelete.getLocations().deleteLocationByName(locationToDelete.getName());
            alertt.deleteLocationSuccessful();
        });


        Button nextbutt = new Button("Next");
        Button Previousbutt = new Button("Previous");

        TextField locationnntext = new TextField();
        TextField districttextname = new TextField();

        HBox hBoxnextprev = new HBox(10);
        hBoxnextprev.getChildren().addAll(Previousbutt, nextbutt,locationnntext,districttextname);

        nextbutt.setOnAction(e -> {
            District district1 = districtLinkedList.getDistrict(districtIndex);


            if (indexlocation > district1.getLocations().getSize() - 1) {
                indexlocation = 0;
                districtIndex++;
            }


            if (districtIndex > districtLinkedList.getSize() - 1) {
                districtIndex = 0;
            }


            String locationname = district1.getLocations().getLocation(indexlocation).getName();
            locationnntext.setText(locationname);

          
            String districtname = district1.getName();
            districttextname.setText(districtname);
            indexlocation++;




        });



        Previousbutt.setOnAction(e -> {
            District district1 = districtLinkedList.getDistrict(districtIndex);


            indexlocation--;


            if (indexlocation < 0) {
                indexlocation = district1.getLocations().getSize() - 1;
                districtIndex--;
            }


            if (districtIndex < 0) {
                districtIndex = districtLinkedList.getSize() - 1;
            }


            String locationname = district1.getLocations().getLocation(indexlocation).getName();
            locationnntext.setText(locationname);
            String districtname = district1.getName();
            districttextname.setText(districtname);
        });


        Button searchlocationbutt = new Button("Search");

        TextField locationnametosarchestattext = new TextField();
        locationnametosarchestattext.setPromptText("Enter The Loaction Name");

        HBox hBoxsearch = new HBox(searchlocationbutt, locationnametosarchestattext);

        searchlocationbutt.setOnAction(e -> {
            String locationName = locationnametosarchestattext.getText().trim();


            if (locationName.isEmpty()) {
                alertt.filedEmpty();
                return;
            }

            Location location = new Location();
            for (int i = 0; i < districtLinkedList.getSize(); i++) {
                District district = districtLinkedList.getDistrict(i);
                location = district.getLocations().getLocationByName(locationName);
                if (location != null) {
                    break;
                }
            }

            if (location == null) {
                alertt.locationNotFound();
                return;
            }

            int totalMartyrs = location.getMartyrs().getSize();

            // Calculate total number of male and female martyrs //
            int totalMaleMartyrs = 0;
            int totalFemaleMartyrs = 0;
            for (int i = 0; i < location.getMartyrs().getSize(); i++) {
                if (location.getMartyrs().getMartyrByIndex(i).getGender().equalsIgnoreCase("M")) {
                    totalMaleMartyrs++;
                } else if (location.getMartyrs().getMartyrByIndex(i).getGender().equalsIgnoreCase("F")) {
                    totalFemaleMartyrs++;
                }
            }

            // Calculate average martyrs ages //
            double averageAge = 0;
            if (totalMartyrs > 0) {
                int totalAge = 0;
                for (int i = 0; i < location.getMartyrs().getSize(); i++) {
                    totalAge += location.getMartyrs().getMartyrByIndex(i).getAge();
                }
                averageAge = (double) totalAge / totalMartyrs;
            }

            // Find the youngest and oldest martyrs //
            int minAge = Integer.MAX_VALUE;
            int maxAge = Integer.MIN_VALUE;
            Martyr youngestMartyr = null;
            Martyr oldestMartyr = null;
            for (int i = 0; i < location.getMartyrs().getSize(); i++) {
                Martyr martyr = location.getMartyrs().getMartyrByIndex(i);
                if (martyr.getAge() < minAge) {
                    minAge = martyr.getAge();
                    youngestMartyr = martyr;
                }
                if (martyr.getAge() > maxAge) {
                    maxAge = martyr.getAge();
                    oldestMartyr = martyr;
                }
            }

            String alertMessage = "Location: " + locationName + "\n" + "Total number of martyrs: " + totalMartyrs + "\n" + "Total number of male martyrs: " + totalMaleMartyrs + "\n" + "Total number of female martyrs: " + totalFemaleMartyrs + "\n" + "Average age of martyrs: " + String.format("%.2f", averageAge) + "\n" + "Youngest martyr: " + (youngestMartyr != null ? youngestMartyr.getName() + " (" + youngestMartyr.getAge() + " years old)" : "N/A") + "\n" + "Oldest martyr: " + (oldestMartyr != null ? oldestMartyr.getName() + " (" + oldestMartyr.getAge() + " years old)" : "N/A");


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Location Statistics");
            alert.setHeaderText(null);
            alert.setContentText(alertMessage);
            alert.showAndWait();




        });


        Button addMartyr = new Button("Add Martyr");

        TextField martyrnametext = new TextField();
        martyrnametext.setPromptText("Enter Martyr's Name");

        DatePicker martyrdatetext = new DatePicker();
        martyrdatetext.setPromptText("Select Martyr's Date");

        TextField martyragetext = new TextField();
        martyragetext.setPromptText("Enter Martyr's Age");

        TextField martyrloactiontext = new TextField();
        martyrloactiontext.setPromptText("Enter Martyr's Location");

        TextField martyrdisctircttext = new TextField();
        martyrdisctircttext.setPromptText("Enter Martyr's District");

        TextField martyrgendertext = new TextField();
        martyrgendertext.setPromptText("Enter Martyr's Gender");

        HBox hBoxmartyrrecord = new HBox(addMartyr, martyrnametext, martyrdatetext, martyragetext, martyrloactiontext, martyrdisctircttext, martyrgendertext);


        addMartyr.setOnAction(e -> {
            String martyrName = martyrnametext.getText().trim();
            String martyrDate = String.valueOf(martyrdatetext.getValue());
            String martyrAgeText = martyragetext.getText().trim();
            String martyrLocation = martyrloactiontext.getText().trim();
            String martyrDistrict = martyrdisctircttext.getText().trim();
            String martyrGender = martyrgendertext.getText().trim();


            if (martyrName.isEmpty() || martyrDate.isEmpty() || martyrAgeText.isEmpty() || martyrLocation.isEmpty() || martyrDistrict.isEmpty() || martyrGender.isEmpty()) {
                alertt.filedEmpty();
                return;
            }

            if(!martyrGender.equalsIgnoreCase("Male") || !martyrGender.equalsIgnoreCase("Female") || !martyrGender.equalsIgnoreCase("M") || !martyrGender.equalsIgnoreCase("F")){
                alertt.invalidGender();
                return;
            }


            int martyrAge = 0;
            try {
                martyrAge = Integer.parseInt(martyrAgeText);
            }catch (NumberFormatException ex){
                alertt.invalidage();
            }



            // Create a new Martyr object //
            Martyr newMartyr = new Martyr(martyrName, martyrDate, martyrAge, martyrLocation, martyrDistrict, martyrGender);

            // Find the location to add the martyr //
            Location location = new Location();
            for (int i = 0; i < districtLinkedList.getSize(); i++) {
                District district = districtLinkedList.getDistrict(i);
                location = district.getLocations().getLocationByName(martyrLocation);
                if (location != null) {
                    break;
                }
            }

            if (location == null) {
                alertt.locationNotFound();
                return;
            }

            // Add the martyr to the location //
            location.getMartyrs().addMartyr(newMartyr);

            alertt.Martryraddedsucc();

            martyrnametext.clear();
            martyrdatetext.setValue(null);
            martyragetext.clear();
            martyrloactiontext.clear();
            martyrdisctircttext.clear();
            martyrgendertext.clear();
        });


        Button updateMartyrButton = new Button("Update Martyr");

        TextField martyrNameToChangeRecordsText = new TextField();
        martyrNameToChangeRecordsText.setPromptText("Enter Martyr Name To Change Records");

        TextField martyrNewNameText = new TextField();
        martyrNewNameText.setPromptText("Enter Martyr New Name");

        TextField martyrNewGenderText = new TextField();
        martyrNewGenderText.setPromptText("Enter New Gender");

        TextField districtText = new TextField();
        districtText.setPromptText("Enter District");

        TextField locationText = new TextField();
        locationText.setPromptText("Enter Location");

        HBox updateMartyrBox = new HBox(updateMartyrButton, martyrNameToChangeRecordsText, martyrNewNameText,martyrNewGenderText, districtText, locationText);
        updateMartyrButton.setOnAction(e -> {
            String oldMartyrName = martyrNameToChangeRecordsText.getText().trim();
            String newMartyrName = martyrNewNameText.getText().trim();
            String newMartyrGender = martyrNewGenderText.getText().trim();
            String districtupdate = districtText.getText().trim();
            String locationupdate = locationText.getText().trim();

            if (oldMartyrName.isEmpty() || newMartyrName.isEmpty() || newMartyrGender.isEmpty() || districtupdate.isEmpty() || locationupdate.isEmpty()) {alertt.filedEmpty();
                alertt.filedEmpty();
                return;
            }

            District district = districtLinkedList.getDistrictByName(districtupdate);
            if (district == null) {
                alertt.districtNotFound();
                return;
            }

            Location location = district.getLocations().getLocationByName(locationupdate);

            if (location == null) {
                alertt.locationNotFound();
                return;
            }

            Martyr martyr = location.getMartyrs().getLocationByName(oldMartyrName);
            martyr.setName(newMartyrName);
            martyr.setGender(newMartyrGender);

            alertt.martyrEditsuccsefull();




        });


        Button searchbutt = new Button("Search");

        TextField partnametext = new TextField();
        partnametext.setPromptText("Enter The Name Of Martyr");

        TextField districtTextt = new TextField();
        districtTextt.setPromptText("Enter District");

        TextField locationTextt = new TextField();
        locationTextt.setPromptText("Enter Location");

        HBox hBoxsearchbymartyrname = new HBox(searchbutt, partnametext,districtTextt,locationTextt);

        VBox vBox1labels = new VBox(5);
        searchbutt.setOnAction(e -> {
            String martyrName = partnametext.getText().trim();
            String districtstring = districtTextt.getText().trim();
            String locationstring = locationTextt.getText().trim();

            if (martyrName.isEmpty() || districtstring.isEmpty() || locationstring.isEmpty()){
                alertt.filedEmpty();
                return;
            }

            District district = districtLinkedList.getDistrictByName(districtstring);
            if (district == null) {
                alertt.districtNotFound();
                return;
            }

            Location location = district.getLocations().getLocationByName(locationstring);

            if (location == null) {
                alertt.locationNotFound();
                return;
            }

            Martyr martyr = location.getMartyrs().getLocationByName(martyrName);

            if(martyr == null){
                alertt.martyrNotFound(martyrName);
                return;
            }

            if(martyr.getName().contains(martyrName)){
                StringBuilder content = new StringBuilder();
                content.append("Martyr Data:\n");
                content.append("Name: ").append(martyr.getName()).append("\n").append("Gender: ").append(martyr.getGender()).append("\n").append("Age: ").append(martyr.getAge()).append("\n").append("District: ").append(district.getName()).append("\n").append("Location: ").append(location.getName()).append("\n\n");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Martyr Information");
                alert.setHeaderText(null);
                alert.setContentText(content.toString());
                alert.showAndWait();
            }




        });


        vBox.getChildren().addAll(hBoxnewloaction, hBoxupdateloaction, hBoxdelteloaction, hBoxnextprev, hBoxsearch, hBoxmartyrrecord, updateMartyrBox, hBoxsearchbymartyrname);
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, vBox1labels);
        hBox.setAlignment(Pos.TOP_LEFT);
        borderPane.setCenter(hBox);

        return borderPane;
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

                District district = districtLinkedList.getDistrictByName(districtName);
                if (district == null) {
                    district = new District(districtName);
                    districtLinkedList.addDistrict(district);
                }

                Location location = district.getLocations().getLocationByName(locationName);
                if (location == null) {
                    location = new Location(locationName);
                    district.getLocations().addLoaction(location);
                }

                Martyr martyr = new Martyr(name, dateOfMartyr, age, locationName, districtName, gender);
                location.getMartyrs().addMartyr(martyr);




            }
            alertt.addFilesucc();
            district.getLocations().printLocations();




        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }



    public  VBox Filee() {
        VBox vBox = new VBox();

        Button button = new Button("Load Data");
        vBox.getChildren().add(button);
        vBox.setAlignment(Pos.CENTER);

        button.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();

            File desktopDirectory = new File(System.getProperty("user.home"), "Desktop");


            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel","*.csv"));
            fileChooser.setInitialDirectory(desktopDirectory);

            File file = fileChooser.showOpenDialog(null);

            try {
                if (file == null) {
                    alertt.fileAdd();
                    return;
                }

                Filereader(file);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        return vBox;
    }


    public static int martyrsindistrict() {
        int totalMartyrsInDistrict = 0;
        District district = districtLinkedList.getDistrict(index);


        for (int i = 0; i < district.getLocations().getSize(); i++) {
            totalMartyrsInDistrict += district.getLocations().getLocation(i).getMartyrs().getSize();
        }

        return totalMartyrsInDistrict;
    }


    public static int malefemalemartrysindisctrict(String string){
        District district = districtLinkedList.getDistrict(index);
        int totalmaleMartyrsInDistrict = 0;
        int totalfemaleMartyrsInDistrict = 0;

        for (int i = 0; i < district.getLocations().getSize(); i++) {

            for (int j = 0;j < district.getLocations().getLocation(i).getMartyrs().getSize();j++) {

                if(district.getLocations().getLocation(i).getMartyrs().getMartyrByIndex(j).getGender().equalsIgnoreCase("M")){
                    totalmaleMartyrsInDistrict++;
                }

                else if (district.getLocations().getLocation(i).getMartyrs().getMartyrByIndex(j).getGender().equalsIgnoreCase("F")) {
                    totalfemaleMartyrsInDistrict++;
                }

            }


        }
        if(string.equalsIgnoreCase("male")){
            return totalmaleMartyrsInDistrict;
        }else if(string.equalsIgnoreCase("female")){
            return totalfemaleMartyrsInDistrict;
        }
        return -1;

    }

    public static double averagemartyrsages() {
        District district = districtLinkedList.getDistrict(index);
        double totalmartyrages = 0;
        double totalmartyrs = 0;
        double avarge = 0;

        for (int i = 0; i < district.getLocations().getSize(); i++) {
            for (int j = 0; j < district.getLocations().getLocation(i).getMartyrs().getSize(); j++) {

                totalmartyrs++;

                totalmartyrages += district.getLocations().getLocation(i).getMartyrs().getMartyrByIndex(j).getAge();
            }
        }

        if (totalmartyrs != 0) {
            avarge = totalmartyrages / totalmartyrs;
        } else {
            avarge = 0;
        }

        return avarge;
    }


    public static String thedatehavethemostmartrys() {
        String dateWithMaxMartyrs = null;
        int maxMartyrs = 0;

        for (int i = 0; i < districtLinkedList.getSize(); i++) {
            District district = districtLinkedList.getDistrict(index);

            for (int j = 0; j < district.getLocations().getSize(); j++) {
                Location location = district.getLocations().getLocation(j);

                for (int k = 0; k < location.getMartyrs().getSize(); k++) {
                    Martyr martyr = location.getMartyrs().getMartyrByIndex(k);
                    int martyrCount = 1;


                    if (k + 1 < location.getMartyrs().getSize() && martyr.getDate().equals(location.getMartyrs().getMartyrByIndex(k + 1).getDate())) {
                        martyrCount++;
                    }

                    if (martyrCount > maxMartyrs) {
                        maxMartyrs = martyrCount;
                        dateWithMaxMartyrs = martyr.getDate();
                    }
                }
            }
        }

        return dateWithMaxMartyrs;
    }

}
