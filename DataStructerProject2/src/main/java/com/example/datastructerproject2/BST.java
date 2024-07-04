package com.example.datastructerproject2;

public class BST extends BaseBinaryTree implements BSTIF {


    @Override
    public Node find(Object data) {
        return find(data, getRoot());
    }

    private Node find(Object data, Node node) {
        if (node == null) {
            return null;
        }

        Comparable<Object> comparableData = (Comparable<Object>) data;

        if (node.getData().equals(data)) {
            return node;
        } else if (comparableData.compareTo(node.getData()) > 0) {
            return find(data, node.getRight());
        } else {
            return find(data, node.getLeft());
        }
    }

    @Override
    public void insert(Object data) {
        root = insert(data, getRoot());
    }

    private Node insert(Object data, Node node) {
        if (node == null) {
            return new Node(data);
        }

        Comparable<Object> comparableData = (Comparable<Object>) data;

        if (comparableData.compareTo(node.getData()) <= 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else {
            node.setRight(insert(data, node.getRight()));
        }

        return node;
    }


    @Override
    public void delete(Object data) {
        root = delete(data, getRoot());
    }

    public Node delete(Object data, Node node) {
        if (node == null) {
            return null;
        }
        Comparable<Object> comparableData = (Comparable<Object>) data;

        if (comparableData.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));

        }
        else if (comparableData.compareTo(node.getData()) > 0) {
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


    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }


}
