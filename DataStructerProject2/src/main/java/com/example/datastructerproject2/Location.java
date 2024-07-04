package com.example.datastructerproject2;

import java.io.Serializable;

public class Location extends Node implements Comparable<Location> {
    private String LocationName;
    private MartyrDatetree MartyrDatetree;


    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public MartyrDatetree getMartyrDatetree() {
        return this.MartyrDatetree;
    }

    public Location(String locationName){
        super(locationName);
        this.LocationName = locationName;
        this.MartyrDatetree = new MartyrDatetree();
    }

    public Location() {
        this.LocationName = LocationName;
        this.MartyrDatetree = new MartyrDatetree();
    }


    @Override
    public int compareTo(Location location) {
        return this.getLocationName().compareTo(location.getLocationName());
    }

    @Override
    public String toString() {
        return  LocationName;
    }
}
