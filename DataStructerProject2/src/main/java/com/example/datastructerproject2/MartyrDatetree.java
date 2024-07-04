package com.example.datastructerproject2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MartyrDatetree extends BST implements MDBSTIF{


    @Override
    public void insert(MartyrDate data) {
        root = insert(data, getRoot());
    }

    private Node insert(MartyrDate data, Node node) {
        if (node == null) {
            return new Node(data);
        }


        if (data.compareTo((MartyrDate) node.getData()) == 0) {
            return node;
        }

        if (data.compareTo((MartyrDate) node.getData()) < 0) {
            node.setLeft(insert(data, node.getLeft())); // Insert into the left subtree
        } else if (data.compareTo((MartyrDate) node.getData()) > 0) {
            node.setRight(insert(data, node.getRight())); // Insert into the right subtree
        }

        return node;
    }


    @Override
    public Node find(MartyrDate date) {
        return find(date, getRoot());
    }

    private Node find(MartyrDate date, Node node) {
        if (node == null) {
            return null;
        }

        MartyrDate datemart = (MartyrDate) node.getData();


        if (datemart.equals(date)) {
            return node;
        } else if (date.compareTo(datemart) > 0) {
            return find(date, node.getRight());
        } else {
            return find(date, node.getLeft());
        }
    }




    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            MartyrDate martyrDate = (MartyrDate) node.getData();
            System.out.println(martyrDate); // Assuming MartyrDate has a proper toString() method
            inOrder(node.getRight());
        }
    }


    public void inorderPrint() {
        inOrder(getRoot());
    }



}
