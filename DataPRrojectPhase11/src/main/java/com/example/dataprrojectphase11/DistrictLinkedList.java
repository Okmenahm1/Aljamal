package com.example.dataprrojectphase11;


public class DistrictLinkedList extends Doublelinkedlist { // extend to get any thing from it //
    private LocationCircularLinkedList location;
    private District head;
    private int size = 0;


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public District getHead() {
        return head;
    }

    public void setHead(District head) {
        this.head = head;
    }

    public DistrictLinkedList() {
        location = new LocationCircularLinkedList();
    }




    public void addDistrict(District district) {
        if (head == null) {
            head = district;
            head.setNext(head); // Pointing to itself since it's the only node in the list //
            head.setPrev(head); // Pointing to itself since it's the only node in the list //
        } else {
            District current = head;
            // Sort  positions to insert the new district alphabetically //
            while (current.compareTo(district) < 0 && current.getNext() != head) {
                current = (District) current.getNext();
            }
            if (current.compareTo(district) >= 0) {
                // Insert before current //
                District prev = (District) current.getPrev();
                prev.setNext(district);
                district.setPrev(prev);
                district.setNext(current);
                current.setPrev(district);
                if (current == head) {
                    head = district;
                }
            } else {
                // Insert after last
                District last = current;
                last.setNext(district); // Set the next of the last district to the new district  //
                district.setPrev(last); // Set the previous of the new district to the last district //
                district.setNext(head); // Set the next of the new district to the head //
                head.setPrev(district); // Set the previous of the head to the new district //
            }
        }
        size++;
        super.setSize(size);
    }


    public District getDistrictByName(String name) {
        if (head == null) {
            return null; // If the list is empty return null //
        }

        District current = head;
        do {
            if (current.getName().equalsIgnoreCase(name)) {
                return current; // If the current districts name matches the specified name return it //
            }
            current = (District) current.getNext();
        } while (current != head);

        return null; // If no district with the specified name is found return null //
    }


    public District getDistrict(int index) {
        if (head == null || index < 0 || index >= size) {
            return null; // Return null if the list is empty or the index is out of bounds //
        }

        District current = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            current = (District) current.getNext(); // will move in dsitricts depend on the currentindex and it will return the current if dsitrict found //
            currentIndex++;
        }

        return current; // return the index //
    }

    public boolean deleteDistrict(District district) {
        if (head == null) {
            return false; // If the list is empty return false //
        }

        // If the district to delete is the head //
        if (head == district) {
            if (size == 1) {
                head = null; // If there's only one district in the list set head to null //
            } else {
                head = (District) head.getNext(); // Move head to the next district //
            }
            size--;
            return true; // Successfully deleted the district //
        }

        // Search for the district to delete //
        District current = head;
        do {
            if (current.getNext() == district) {
                // Found the district to delete
                current.setNext(district.getNext()); // Link previous district to the next one //
                size--;
                return true; // Successfully deleted the district //
            }
            current = (District) current.getNext();
        } while (current != head);

        // If the district was not found //
        return false;
    }




    }


