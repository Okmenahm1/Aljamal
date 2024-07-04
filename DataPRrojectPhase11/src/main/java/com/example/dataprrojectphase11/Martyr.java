package com.example.dataprrojectphase11;

public class Martyr extends Node implements Comparable<Martyr>{
    private String name;
    private String date;
    private int age;
    private String location;
    private String district;
    private String gender;

    Alertt alertt = new Alertt();




    public Martyr(String name, String date, int age, String location, String district, String gender) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.location = location;
        this.district = district;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public int compareTo(Martyr martyr) {

        int genders = this.getGender().compareToIgnoreCase(martyr.getGender());
        if (genders != 0) {

            return genders;
        } else {

            if (this.getAge() < martyr.getAge()) {
                return -1;
            } else if (this.getAge() > martyr.getAge()) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    @Override
    public String toString() {
        return "Martyr{" + "name='" + name + '\'' + ", date='" + date + '\'' + ", age=" + age + ", location='" + location + '\'' + ", district='" + district + '\'' + ", gender='" + gender + '\'' + '}';
    }
}
