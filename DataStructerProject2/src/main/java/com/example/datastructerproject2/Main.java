package com.example.datastructerproject2;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        Date date = new Date("01/06/2009");
        MartyrDate martyrDate = new MartyrDate(date);
        // Creating an instance of DistrictTree
        DistrictTree districtTree = new DistrictTree();
        Martyr martyr1 = new Martyr("Ali", "01/06/2009", 25, "Location1", "District1", "Male");
        Martyr martyr2 = new Martyr("Muhammad", "01/06/2009", 30, "Location2", "District2", "Male");
        Martyr martyr3 = new Martyr("Fatima", "02/06/2009", 20, "Location3", "District3", "Female");
        Martyr martyr4 = new Martyr("Hassan", "03/06/2009", 35, "Location4", "District4", "Male");
        Martyr martyr5 = new Martyr("Zainab", "04/06/2009", 28, "Location5", "District5", "Female");


        // Creating districts
        District ramallah = new District("Ramallah");
        District alQuds = new District("al-Quds");

        // Creating locations
        Location beitunia = new Location("Beitunia");
        Location alAmari = new Location("Al-Amari");

        // Inserting districts into the DistrictTree
        districtTree.insert(ramallah);
        districtTree.insert(alQuds);

        // Inserting locations into districts
        ramallah.getLocations().insert(beitunia);
        alQuds.getLocations().insert(alAmari);

        beitunia.getMartyrDatetree().insert(martyrDate);
        martyrDate.getLinkedList().addMartyr(martyr1);


        beitunia.getMartyrDatetree().find(martyrDate);
        if(beitunia.getMartyrDatetree().find(martyrDate) != null){
            Node node = beitunia.getMartyrDatetree().find(martyrDate);
            MartyrDate martyrDate1 = (MartyrDate) node.getData();
            martyrDate1.getLinkedList().printlinkedlist();
        }



    }
}
