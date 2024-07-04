package com.example.datastructerproject2;

public class District extends Node implements Comparable<District> {
    private String DistrictName;
    private LocationTree locations;

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }

    public LocationTree getLocations() {
        return this.locations;
    }
    public District(String DistrictName) {
        super(DistrictName);
        this.DistrictName = DistrictName;
        this.locations = new LocationTree();
    }

    public District() {
        this.DistrictName = DistrictName;
        this.locations = new LocationTree();
    }

    @Override
    public int compareTo(District district) {
        return this.getDistrictName().compareToIgnoreCase(district.getDistrictName());
    }

    @Override
    public String toString() {
        return  DistrictName;
    }
}
