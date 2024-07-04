package com.example.dataproject3;

class MartyrDate {
    private String date;
    private char flag;
    private AvlTree martyrs;

    public MartyrDate(String date) {
        this.date = date;
        this.flag = 'E';
        this.martyrs = new AvlTree();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public char getFlag() {
        return flag;
    }

    public AvlTree getAvlTree() {
        return martyrs;
    }

    @Override
    public String toString() {
        return date;
    }
}
