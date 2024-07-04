package com.example.dataprrojectphase11;
import javafx.scene.layout.BorderPane;

public class Location extends Node implements Comparable <Location> {

    private BorderPane borderPane;


    private MartyrCircularLinkedList martyrs;

    private String name;


    public Location(String name) {
        super(name);
        this.name = name;
        this.martyrs = new MartyrCircularLinkedList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MartyrCircularLinkedList getMartyrs() {
        return martyrs;
    }


    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }



    public Location() {
        this.name = name;
        this.martyrs = new MartyrCircularLinkedList();
    }


    @Override
    public String toString() {
        return "Location{" + "name='" + name + '\'' + '}';
    }

    @Override
    public int compareTo(Location location) {
        // Corrected to compare the names of two different locations ignoring case sensitivity //
         return this.getName().compareToIgnoreCase(location.getName());

    }
}