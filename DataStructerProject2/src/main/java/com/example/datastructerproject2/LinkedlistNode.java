package com.example.datastructerproject2;

public class LinkedlistNode {

    private Object data;
    private LinkedlistNode prev;
    private LinkedlistNode next;

    public LinkedlistNode(Object data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public LinkedlistNode() {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LinkedlistNode getPrev() {
        return prev;
    }

    public void setPrev(LinkedlistNode prev) {
        this.prev = prev;
    }

    public LinkedlistNode getNext() {
        return next;
    }

    public void setNext(LinkedlistNode next) {
        this.next = next;
    }


}

