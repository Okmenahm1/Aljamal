package com.example.dataprrojectphase11;

public class Node {
    private Object data;
    private Node next;

    public Node() {
        this.data = data;
        this.next = null;
    }


    // Constructor with data parameter
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
