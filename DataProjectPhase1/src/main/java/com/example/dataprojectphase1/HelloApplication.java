package com.example.dataprojectphase1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox vBox = new VBox(10);


        Button Districtbutt = new Button("District");

        Districtbutt.setOnAction(e -> {
            Districtscene(stage);
        });

        Button Locationbutt = new Button("Locations");

        Locationbutt.setOnAction(e ->{

        });

        Button LoadFile = new Button("Load File");

        LoadFile.setOnAction(e ->{

        });

        vBox.getChildren().addAll(Districtbutt,Locationbutt,LoadFile);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void Districtscene(Stage stage){
        District districtScreen = new District();
        Button backbutton = new Button("Back");

        districtScreen.getBorderPane().setBottom(backbutton);

        backbutton.setOnAction(e ->{
            try {
                start(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Scene scene = new Scene(districtScreen.getBorderPane(),750,450);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}