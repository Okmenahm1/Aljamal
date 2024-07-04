package com.example.datastructerproject2;

import java.util.ArrayList;
import java.util.List;

public class Martryslinkedlist {

    private Martyr head;
    private int size = 0;

    public Martyr getHead() {
        return head;
    }

    public void setHead(Martyr head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addMartyr(Martyr martyr) {
        if (head == null) {
            head = martyr;
            head.setNext(head); // Pointing to itself since it's the only node in the list //
        } else {
            Martyr current = head;
            // Find the correct position to insert the new location according to the sorting criteria //
            while ((current.compareTo(martyr) < 0 || (current.compareTo(martyr) == 0 && "m".equalsIgnoreCase(martyr.getGender())))
                    && current.getNext() != head) {
                current = (Martyr) current.getNext();
            }
            if (current.compareTo(martyr) >= 0 || (current.compareTo(martyr) == 0 && "m".equalsIgnoreCase(martyr.getGender()))) {
                // Inserting after current node if martyr is male and older or if martyr has same age and male
                martyr.setNext(current.getNext());
                current.setNext(martyr);
                if (current == head) {
                    head = martyr;
                }
            } else {
                // Inserting before current node if martyr is female and older
                martyr.setNext(head);
                current.setNext(martyr);
            }
        }
        size++;
    }

    public Martyr getLocationByName(String name) {
        if (head == null) {
            return null; // If the list is empty return null //
        }

        Martyr current = head;
        do {
            if (current.getName().contains(name)) {
                return current; // If the current locations name matches the specified name return it //
            }
            current = (Martyr) current.getNext();
        } while (current != head);

        return null; // If no location with the name is found return null //
    }



    public void deleteMartyr(String name) {
        if (head == null) {
            return; // List is empty
        }

        Martyr current = head;
        Martyr previous = null;

        // Iterate over the list to find the martyr to delete
        do {
            if (current.getName().equals(name)) {
                if (previous == null) { // Head node needs to be deleted
                    if (current.getNext() == head) { // Only one node in the list
                        head = null;
                    } else { // More than one node in the list
                        Martyr last = head;
                        while (last.getNext() != head) {
                            last = (Martyr) last.getNext();
                        }
                        head = (Martyr) current.getNext();
                        last.setNext(head);
                    }
                } else { // Deleting a node other than the head
                    previous.setNext(current.getNext());
                }
                size--;
                return;
            }
            previous = current;
            current = (Martyr) current.getNext();
        } while (current != head);
    }






    public void printlinkedlist(){
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Martyr current = head;
        do {
            System.out.println(current);
            current = (Martyr) current.getNext();
        } while (current != head);
    }




}
