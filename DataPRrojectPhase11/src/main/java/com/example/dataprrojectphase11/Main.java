package com.example.dataprrojectphase11;

public class Main {




    public static void main(String[] args) {
        DistrictLinkedList districtLinkedList = new DistrictLinkedList();

        District district1 = new District("Ammer");
        Location location = new Location("Birzeit");
        Location location1 = new Location("Kobar");
        Location location2 = new Location("Abu shkedem");
        District district2 = new District("Ramllah");
        District district3 = new District("Gaza");

        Martyr martyr = new Martyr("Muhammad","25/03",22, location1.getName(), district1.getName(), "M");
        Martyr martyr2 = new Martyr("Muhammad","25/03",20, location1.getName(), district1.getName(), "M");


        districtLinkedList.addDistrict(district2);
        districtLinkedList.addDistrict(district1);
        districtLinkedList.addDistrict(district3);


       // district1.getLocations().addLoaction(location);
        district1.getLocations().addLoaction(location1);
        district1.getLocations().addLoaction(location2);
        location1.getMartyrs().addMartyr(martyr);
        location1.getMartyrs().addMartyr(martyr2);

        System.out.println(district1.getLocations().getLocation(1).getName());

//        System.out.println(districtLinkedList.getSize());
//        System.out.println(district1.getLocations().getSize());
//        System.out.println(district2.getLocations().getSize());
//        System.out.println(location1.getMartyrs().getSize());
//        districtLinkedList.printList();
//
//        location1.getMartyrs().printList();
    }






}
