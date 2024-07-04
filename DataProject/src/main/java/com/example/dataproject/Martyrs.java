package com.example.dataproject;

public class Martyrs {

    String names;
    int age;
    String location;
    String Date;
    char Gender;
    Alertsclass alert = new Alertsclass();

    public Martyrs() {
    }

    public Martyrs(String names, int age, String location, String date, char gender) {
        this.names = names;
        this.age = age;
        this.location = location;
        Date = date;
        Gender = gender;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char gender) {
        Gender = gender;
    }
}
// nothing is new here :) i will waste my time to write  //
