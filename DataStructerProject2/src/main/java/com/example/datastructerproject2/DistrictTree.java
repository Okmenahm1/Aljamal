package com.example.datastructerproject2;

import java.util.ArrayList;

public class DistrictTree extends BST implements DBSTIF{
    private int districttreesize = 0;



    public int getDistrictTreeSize() {
        return districttreesize;
    }

    public void setDistricttreesize(int districttreesize) {
        this.districttreesize = districttreesize;
    }

    @Override
    public void insert(District data) {
        root = insert(data, getRoot());
        districttreesize++;
    }

    private Node insert(District data, Node node) {
        if (node == null) {
            return new Node(data);
        }

        String newDataName = data.getDistrictName().toLowerCase();
        String currentNodeName = ((District) node.getData()).getDistrictName().toLowerCase();


        if(newDataName.compareToIgnoreCase(currentNodeName) == 0){
            districttreesize--;
            return node;

        }

        if (newDataName.compareToIgnoreCase(currentNodeName) < 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else if (newDataName.compareToIgnoreCase(currentNodeName) > 0) {
            node.setRight(insert(data, node.getRight()));
        }

        return node;
    }


    @Override
    public void delete(District data) {
        root = delete(data, getRoot());
    }

    private Node delete(District data, Node node) {
        if (node == null) {
            return null;
        }

        String dataName = data.getDistrictName().toLowerCase();
        String nodeName = ((District) node.getData()).getDistrictName().toLowerCase();

        int comparison = dataName.compareToIgnoreCase(nodeName);

        if (comparison < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (comparison > 0) {
            node.setRight(delete(data, node.getRight()));
        } else {
            if (node.getRight() == null && node.getLeft() == null) {
                node = null;
            } else if (node.getRight() == null) {
                node = node.getLeft();
            } else if (node.getLeft() == null) {
                node = node.getRight();
            } else {
                deleteNodeWithTwoChildren(node);
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





    @Override
    public Node find(String data) {
        return find(data, getRoot());
    }

    private Node find(String data, Node node) {
        if (node == null) {
            return null;
        }

        District district = (District) node.getData();

        if (district.getDistrictName().equalsIgnoreCase(data)) {
            return node;
        } else if (data.compareToIgnoreCase(district.getDistrictName()) > 0) {
            return find(data, node.getRight());
        } else {
            return find(data, node.getLeft());
        }
    }


    public ArrayList<String> combodistrict() {
        ArrayList<String> list = new ArrayList<>();
        inorderTraversalForComboBox(getRoot(), list);
        return list;
    }

    private void inorderTraversalForComboBox(Node node, ArrayList<String> list) {
        if (node != null) {
            inorderTraversalForComboBox(node.getLeft(), list);
            District district = (District) node.getData();
            list.add(district.getDistrictName());
            inorderTraversalForComboBox(node.getRight(), list);
        }
    }

    public Stack stackdistrict() {
        Stack stack = new Stack();
        inorderTraversalForStack(getRoot(), stack);
        return stack;
    }

    private void inorderTraversalForStack(Node node, Stack stack) {
        if (node != null) {
            inorderTraversalForStack(node.getLeft(), stack);
            District district = (District) node.getData();
            stack.push(district);
            inorderTraversalForStack(node.getRight(), stack);

        }
    }







}
