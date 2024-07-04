package com.example.datastructerproject2;

import java.util.Date;

public class Node {
    private Node left,right;
    private Object data;


    public Node(Object data){
        this.data = data;
        left = null;
        right = null;
    }


    public Node(){
        this.data = data;
        left = null;
        right = null;
    }



    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}
