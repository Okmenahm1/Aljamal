package com.example.datastructerproject2;

import java.util.ArrayList;

public class LocationTree extends BST implements LBSTIF  {



    @Override
    public Node find(String data) {
        return find(data, getRoot());
    }

    private Node find(String data, Node node) {
        if (node == null) {
            return null;
        }

        Location location = (Location) node.getData();

        if (location.getLocationName().equalsIgnoreCase(data)) {
            return node;
        } else if (data.compareToIgnoreCase(location.getLocationName()) > 0) {
            return find(data, node.getRight());
        } else {
            return find(data, node.getLeft());
        }
    }



    @Override
    public void delete(Location data) {
        root = delete(data, getRoot());
    }

    private Node delete(Location data, Node node) {
        if (node == null) {
            return null;
        }

        if (((Comparable<Location>) data).compareTo((Location) node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));

        }
        else if (((Comparable<Location>) data).compareTo((Location) node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));

        }
        else {
            if (node.getRight() != null && node.getLeft() != null) {
                deleteNodeWithTwoChildren(node);
            }
            else if (node.getRight() == null) {
                node = node.getLeft();
            }
            else {
                node = node.getRight();
            }
        }
        return node;
    }



    private void deleteNodeWithTwoChildren(Node node) {
        Node successor = findMin(node.getRight());
        node.setData(successor.getData());
        node.setRight(delete(node.getData(), node.getRight()));
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }


    @Override
    public void insert(Location data) {
        root = insert(data, getRoot());
    }

    private Node insert(Location data, Node node) {
        if (node == null) {
            return new Node(data);
        }

        String newDataName = data.getLocationName().toLowerCase();
        String currentNodeName = ((Location) node.getData()).getLocationName().toLowerCase();


        if(newDataName.compareToIgnoreCase(currentNodeName) == 0){
            return node;
        }

        if (newDataName.compareToIgnoreCase(currentNodeName) < 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else if (newDataName.compareToIgnoreCase(currentNodeName) > 0) {
            node.setRight(insert(data, node.getRight()));
        }

        return node;
    }

    private void inOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }else {
            System.out.println("null");
        }
    }

    public void inorderPrint() {
        inOrder(getRoot());
    }

    public ArrayList<String> combolocation() {
        ArrayList<String> list = new ArrayList<>();
        inorderTraversalForComboBox(getRoot(), list);
        return list;
    }

    private void inorderTraversalForComboBox(Node node, ArrayList<String> list) {
        if (node != null) {
            inorderTraversalForComboBox(node.getLeft(), list);
            Location location = (Location) node.getData();
            list.add(location.getLocationName());
            inorderTraversalForComboBox(node.getRight(), list);
        }
    }

    public Stacklocation stacklocation() {
        Stacklocation stack = new Stacklocation();
        inorderTraversalForStack(getRoot(), stack);
        return stack;
    }

    private void inorderTraversalForStack(Node node, Stacklocation stack) {
        if (node != null) {
            inorderTraversalForStack(node.getLeft(), stack);
            Location location = (Location) node.getData();
            stack.push(location);
            inorderTraversalForStack(node.getRight(), stack);
        }
    }

}
