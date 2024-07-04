package com.example.dataprrojectphase11;
import javafx.scene.layout.BorderPane;


public class District extends DoubleNode implements Comparable <District>{ // implements compare to compare the district by alphabet//
    // extends from doublenodes cuz district is double circular //
    private BorderPane borderPane; // border pane //
    private String name;
    private LocationCircularLinkedList locations;


    public LocationCircularLinkedList getLocations(){
        return this.locations;
    }
// return the location list //




    public District(String name){
        super(name);
        this.name = name;
        this.locations = new LocationCircularLinkedList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public District(){
        this.name = name;
        this.locations = new LocationCircularLinkedList();

    }


    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    @Override
    public int compareTo(District district) {
        return this.getName().compareToIgnoreCase(district.getName());  // Compare the names of district1 and district2 ignoring case sensitivity //
    }


    @Override
    public String toString() {
        return "District{" + "name='" + name + '\'' +'}';
    }
}
