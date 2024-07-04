package com.example.dataprrojectphase11;

public class Doublelinkedlist {
    private DoubleNode head;
    private int size;


    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Doublelinkedlist() {
        this.head = null;
        this.size = 0;
    }

    // Method to add a node at the beginning of the linked list
    public void addFirst(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    // Method to add a node at the end of the linked list
    public void addLast(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DoubleNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrev(temp);
        }
        size++;
    }

    // Method to remove a node from the beginning of the linked list
    public void removeFirst() {
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
    }

    // Method to remove a node from the end of the linked list
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
        } else {
            DoubleNode temp = head;
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
        }
        size--;
    }




}
