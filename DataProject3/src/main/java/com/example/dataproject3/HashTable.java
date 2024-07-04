package com.example.dataproject3;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private MartyrDate[] table;
    private int size;
    private int capacity;
    private static final double LOAD_FACTOR = 0.5;
    List <String> districtlist = new ArrayList<>();
    List <String> locationlist = new ArrayList<>();
    List <String> martyrsList = new ArrayList<>();

    public MartyrDate[] getTable() {
        return table;
    }

    public void setTable(MartyrDate[] table) {
        this.table = table;
    }

    public HashTable() {
        this.capacity = 11;
        this.table = new MartyrDate[capacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private int hash(String date) {
        return Math.abs(date.hashCode() % capacity);
    }

    public int findNextPrime(int num) {
        if (num % 2 == 0) {
            num += 1;
        } else {
            num += 2;
        }
        while (!isPrime(num)) {
            num += 2;
        }
        return num;
    }

    private static boolean isPrime(int n) {
        if (n <= 1){
            return false;
        }

        // Check if n=2 or n=3 //
        if (n == 2 || n == 3){
            return true;
        }
        // Check whether n is divisible by 2 or 3 //
        if (n % 2 == 0 || n % 3 == 0){
            return false;
        }

        // Check from 5 to square root of n //
        // Iterate i by (i+6) //
        for (int i = 5; i <= Math.sqrt(n); i = i + 6){
            if (n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }

        return true;
    }

    private void rehash() {
        MartyrDate[] oldTable = table;
        capacity = findNextPrime(2 * capacity);
        table = new MartyrDate[capacity];
        size = 0;
        for (MartyrDate record : oldTable) {
            if (record != null && record.getFlag() == 'F') {
                insert(record.getDate());
            }
        }
    }

    public void insert(String date) {
        if ((double) size / capacity >= LOAD_FACTOR) {
            rehash();
        }

        int hash = hash(date);
        int i = 0;
        while (table[(hash + i * i) % capacity] != null) {
            if (table[(hash + i * i) % capacity].getDate().equals(date) && table[(hash + i * i) % capacity].getFlag() == 'F') {
            //    System.out.println("Date already exists: " + date);
                return;
            }
            i++;
        }

        int idx = (hash + i * i) % capacity;
        table[idx] = new MartyrDate(date);
        locationlist =  table[idx].getAvlTree().locationlist;
        districtlist =  table[idx].getAvlTree().districtlist;
        martyrsList = table[idx].getAvlTree().martyrsList;
        table[idx].setFlag('F');
        size++;
       // System.out.println("Inserted date: " + date + " at index: " + idx);
    }
    public MartyrDate search(String date) {
        int hash = hash(date);
        int i = 0;
        while (table[(hash + i * i) % capacity] != null) {
            MartyrDate martyrDate = table[(hash + i * i) % capacity];
            if (martyrDate.getDate().equals(date) && martyrDate.getFlag() == 'F') {
              //  System.out.println("Found date: " + date + " at index: " + ((hash + i * i) % capacity));
                return martyrDate;
            }
            i++;
        }
//        System.out.println("Date not found: " + date);
        return null;
    }

    public void delete(String date) {
        int hash = hash(date);
        int i = 0;
        while (table[(hash + i * i) % capacity] != null) {
            MartyrDate martyrDate = table[(hash + i * i) % capacity];
            if (martyrDate.getDate().equals(date) && martyrDate.getFlag() == 'F') {
                martyrDate.setFlag('D');
                martyrDate.getAvlTree().clear(); // Ensure AVL tree clear method is implemented
                size--;
                return;
            }
            i++;
        }
    }

    public List<String> printTable() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i].getFlag() == 'F') {
                list.add(table[i].getDate());
            }
        }
        return list;
    }



    public String districthavemostmartyrs(String date) {
        List<String> districts = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        MartyrDate martyrDate = search(date);
        if (martyrDate == null) {
            return null; // No martyrs found for the given date
        }

        List<Martyr> martyrList = martyrDate.getAvlTree().inOrderTraversal();

        for (int i = 0; i < martyrList.size(); i++) {
            Martyr martyr = martyrList.get(i);
            String district = martyr.getDistrict();
            int index = districts.indexOf(district);
            if (index != -1) {
                counts.set(index, counts.get(index) + 1);
            } else {
                districts.add(district);
                counts.add(1);
            }
        }

        int maxCount = 0;
        String maxDistrict = null;

        for (int i = 0; i < districts.size(); i++) {
            if (counts.get(i) > maxCount) {
                maxCount = counts.get(i);
                maxDistrict = districts.get(i);
            }
        }

        return maxDistrict;
    }


    public String locationhavemostmartyrs(String date) {
        List<String> location = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        MartyrDate martyrDate = search(date);
        if (martyrDate == null) {
            return null; // No martyrs found for the given date //
        }

        List<Martyr> martyrList = martyrDate.getAvlTree().inOrderTraversal();

        for (int i = 0; i < martyrList.size(); i++) {
            Martyr martyr = martyrList.get(i);
            String location1 = martyr.getLocation();
            int index = location.indexOf(location1);
            if (index != -1) {
                counts.set(index, counts.get(index) + 1);
            } else {
                location.add(location1);
                counts.add(1);
            }
        }

        int maxCount = 0;
        String maxLocation = null;

        for (int i = 0; i < location.size(); i++) {
            if (counts.get(i) > maxCount) {
                maxCount = counts.get(i);
                maxLocation = location.get(i);
            }
        }

        return maxLocation;
    }




    public int getNextNonNullIndex(int currentIndex) {
        for (int i = currentIndex + 1; i < capacity; i++) {
            if (table[i] != null) {
                return i;
            }
        }
        return -1;
    }


    public int getPreviousNonNullIndex(int currentIndex) {
        for (int i = currentIndex - 1; i >= 0; i--) {
            if (table[i] != null) {
                return i;
            }
        }
        return -1;
    }


}
