package com.example.dataproject3;

public class Martyr implements Comparable<Martyr> {
    private String name;
    private String date;
    private int age;
    private String location;
    private String district;
    private String gender;


    public Martyr() {
    }

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
    public int compareTo(Martyr other) {
        int districtComparison = this.district.compareTo(other.district);
        if (districtComparison != 0) {
            return districtComparison;
        }
        return this.name.compareTo(other.name);
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' + ", date='" + date + '\'' + ", age=" + age + ", location='" + location + '\'' + ", district='" + district + '\'' + ", gender='" + gender + '\'' + '}';
    }
}
