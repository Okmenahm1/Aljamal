package com.example.dataprrojectphase11;


public class MartyrCircularLinkedList extends Circularlinkedlist {

    private Martyr head;
    int size = 0;



    @Override
    public Martyr getHead() {
        return head;
    }

    public void setHead(Martyr head) {
        this.head = head;
    }


    public void addMartyr(Martyr martyr) {
        if (head == null) {
            head = martyr;
            head.setNext(head); // Pointing to itself since it's the only node in the list //
        } else {
            Martyr current = head;
            // Find the correct position to insert the new location alphabetically //
            while (current.compareTo(martyr) < 0 && current.getNext() != head) {
                current = (Martyr) current.getNext();
            }
            if (current.compareTo(martyr) >= 0) {

                martyr.setNext(current.getNext());
                current.setNext(martyr);
                if (current == head) {
                    head = martyr;
                }
            } else {

                martyr.setNext(head);
                current.setNext(martyr);
            }
        }
        size++;
        super.setSize(size);
    }



    public Martyr getMartyrByIndex(int index) {
        if (head == null || index < 0 || index >= size) {
            return null; // Return null if the list is empty or index is out of bounds //
        }

        Martyr current = head;
        int currentIndex = 0;

        // Iterate through the list until the target index is reached //
        while (currentIndex < index) {
            current = (Martyr) current.getNext();
            currentIndex++;
        }

        return current; // return the martyr //
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


}
