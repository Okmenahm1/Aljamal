package com.example.dataproject3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Martyr martyr = new Martyr("Muhammad","15/5/2024",25,"Birzeit","Ramllah","Male");
        Martyr martyr1 = new Martyr("mahmood","15/5/2024",20,"Birzeit","Ramllah","Male");
        Martyr martyr2 = new Martyr("kareem","15/5/2024",30,"Birzeit","Ramllah","Male");
        Martyr martyr3 = new Martyr("jameel","15/5/2024",15,"Birzeit","Ramllah","Male");



        HashTable ht = new HashTable();
        ht.insert("4/15/2024");
        ht.insert("4/15/2024");
        System.out.println(ht.printTable().get(0));
        System.out.println(ht.printTable().get(1));




//        for (int i = 0; i < hashTable.getTable().length; i++) {
//            MartyrDate martyrDate1 = hashTable.getTable()[i];
//            if (martyrDate1 != null && martyrDate1.getFlag() == 'F') {
//                AvlTree avlTree = martyrDate1.getAvlTree();
//                 node =avlTree.search(martyr.getName());
//
//
//
//            }




    }
}
