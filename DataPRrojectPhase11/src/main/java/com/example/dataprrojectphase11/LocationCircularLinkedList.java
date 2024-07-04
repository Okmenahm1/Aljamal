package com.example.dataprrojectphase11;

public class LocationCircularLinkedList extends Circularlinkedlist{


    private Location head;
    private int size = 0;

    @Override
    public Location getHead() {
        return head;
    }

    public void setHead(Location head) {
        this.head = head;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }




    public void addLoaction(Location location) {
        if (head == null) {
            head = location;
            head.setNext(head); // Pointing to itself since it's the only node in the list //
        } else {
            Location current = head;
            // Sort the positions to insert the new location alphabetically //
            while (current.compareTo(location) < 0 && current.getNext() != head) {
                current = (Location) current.getNext();
            }
            if (current.compareTo(location) >= 0) { // if its (larger) //

                location.setNext(current.getNext());
                current.setNext(location);
                if (current == head) {
                    head = location;
                }
            } else {

                location.setNext(head);
                current.setNext(location);
            }
        }
        size++;
        super.setSize(size);
    }


    public Location getLocationByName(String name) {
        if (head == null) {
            return null; // If the list is empty return null //
        }

        Location current = head;
        do {
            if (current.getName().equalsIgnoreCase(name)) {
                return current; // If the current locations name matches the specified name return it //
            }
            current = (Location) current.getNext();
        } while (current != head);

        return null; // If no location with the name is found return null //
    }

    public Location getLocation(int index) {
        if (head == null || index < 0 || index >= size) {
            return null; // Return null if the list is empty or the index is out of bounds //
        }

        Location current = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            current = (Location) current.getNext();
            currentIndex++;
        }

        return current;
    }

    public void deleteLocationByName(String name) {
        if (head == null) {
            return; // If the list is empty nothing to delete //
        }

        Location current = head;
        Location temp = null;

        do {
            if (current.getName().equalsIgnoreCase(name)) {
                // Found the location to delete /
                if (current == head) {
                    // If the location to delete is the head //
                    if (size == 1) {
                        // If the head is the only node in the list //
                        head = null;
                    } else {
                        // If the head has other after it //
                        Location last = head;
                        while (last.getNext() != head) {
                            last = (Location) last.getNext();
                        }
                        last.setNext(head.getNext());
                        head = (Location) head.getNext();
                    }
                } else {
                    // If the location to delete is not the head //
                    temp.setNext(current.getNext());
                }
                size--;
                return; // Location deleted exit the method //
            }
            temp = current;
            current = (Location) current.getNext();
        } while (current != head);
    }

    public void printLocations() {
        if (head == null) {
            return; // If the list is empty, nothing to print
        }

        Location current = head;
        do {
            System.out.print(current.getData() + " ");
            current = (Location) current.getNext();
        } while (current != head);
    }


}