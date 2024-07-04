package com.example.datastructerproject2;



import java.text.SimpleDateFormat;
import java.util.Date;

public class MartyrDate implements Comparable<MartyrDate> {
    private Date martyrDate;
    private Martryslinkedlist linkedList;

    public MartyrDate(Date martyrDate) {
        this.martyrDate = martyrDate;
        this.linkedList = new Martryslinkedlist(); // Initialize the linked list
    }

    public MartyrDate() {
        this(new Date()); // Default constructor sets martyrDate to current date
    }

    public Martryslinkedlist getLinkedList() {
        return linkedList;
    }

    public Date getMartyrDate() {
        return martyrDate;
    }

    public void setMartyrDate(Date martyrDate) {
        this.martyrDate = martyrDate;
    }

    @Override
    public int compareTo(MartyrDate other) {
        return this.martyrDate.compareTo(other.getMartyrDate());
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(martyrDate);
    }
}
