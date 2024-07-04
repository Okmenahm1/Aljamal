package com.example.dataprrojectphase11;

public class Circularlinkedlist{
    private Node head;
    private int size;

    public Circularlinkedlist() {
        this.head = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Method to add a node at the beginning of the linked list
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            Node temp = head;
            temp.setNext(newNode);
            newNode.setNext(head);
        }
        size++;
    }


    // Method to add a node at the end of the linked list
    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            Node temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
        }
        size++;
    }

    // Method to remove a node from the beginning of the linked list
    public void removeFirst() {
        if (head == null) {
            return;
        }
        if (head.getNext() == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(head.getNext());
            head = head.getNext();
        }
        size--;
    }

    // Method to remove a node from the end of the linked list
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.getNext() == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.getNext().getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(head);
        }
        size--;
    }




}
