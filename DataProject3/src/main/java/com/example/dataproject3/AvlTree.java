package com.example.dataproject3;

import java.util.ArrayList;
import java.util.List;

public class AvlTree {
    private Node root;
    List <String> districtlist = new ArrayList<>();
    List <String> locationlist = new ArrayList<>();
    List <String> martyrsList = new ArrayList<>();
    List <Martyr> martyrslistobjects = new ArrayList<>();

    public AvlTree() {
        root = null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public int height(){
        if (root == null) {
            return -1; // Conventionally, height of an empty tree is -1
        } else {
            return root.getHeight();
        }
    }


    public void insert(Martyr data) {
        root = insert(root, data);
        if (!districtlist.contains(data.getDistrict())) {
            districtlist.add(data.getDistrict());
        }
        if (!locationlist.contains(data.getLocation())) {
            locationlist.add(data.getLocation());
        }
        martyrslistobjects.add(data);
        martyrsList.add(data.getName());

    }

    private Node insert(Node node, Martyr data) {
        if (node == null) {
            return new Node(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(node.getRight(), data));
        } else {
            return node;
        }

        return makeBalance(node);
    }

    public void delete(String martyrName) {
        root = delete(root, martyrName);
    }

    private Node delete(Node node, String martyrName) {
        if (node == null) {
            return null;
        }

        if (martyrName.compareTo(node.getData().getName()) < 0) {
            node.setLeft(delete(node.getLeft(), martyrName));
        } else if (martyrName.compareTo(node.getData().getName()) > 0) {
            node.setRight(delete(node.getRight(), martyrName));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                deleteNodeWithTwoChildren(node);
            }
        }

        return makeBalance(node);
    }

    private Node search(Node node, String martyrName) {
        if (node == null || node.getData().getName().equals(martyrName)) {
            return node;
        }

        if (martyrName.compareTo(node.getData().getName()) < 0) {
            return search(node.getLeft(), martyrName);
        } else {
            return search(node.getRight(), martyrName);
        }
    }

    public Node search(String martyrName) {
        return search(root, martyrName);
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private int getHeight(Node node) {
        return node == null ? -1 : node.getHeight();
    }

    private int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);
        updateHeight(node);
        updateHeight(rightChild);
        return rightChild;
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);
        updateHeight(node);
        updateHeight(leftChild);
        return leftChild;
    }

    private void updateHeight(Node node) {
        if (node == null) {
            return;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        node.setHeight(Math.max(leftHeight, rightHeight) + 1);
    }

    private Node makeBalance(Node node) {
        updateHeight(node);
        int bf = balanceFactor(node);
        if (bf > 1) {
            if (balanceFactor(node.getLeft()) >= 0) {
                return rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        } else if (bf < -1) {
            if (balanceFactor(node.getRight()) <= 0) {
                return rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
        return node;
    }

    private void deleteNodeWithTwoChildren(Node node) {
        Node successor = findMin(node.getRight());
        node.setData(successor.getData());
        node.setRight(delete(node.getRight(), successor.getData().getName()));
    }


    public void printTree() {
        StringBuilder builder = new StringBuilder();
        printOrder(root, builder);
        System.out.println(builder.toString());
    }


    public StringBuilder printOrder(Node node, StringBuilder builder) {
        if (node != null) {
            printOrder(node.getLeft(), builder);
            builder.append(node.getData().getName()).append(" ");
            printOrder(node.getRight(), builder);
        }
        return builder;
    }




    public List<Martyr> inOrderTraversal() {
        List<Martyr> list = new ArrayList<>();
        inOrderTraversalHelper(root, list);
        return list;
    }

    private void inOrderTraversalHelper(Node node, List<Martyr> list) {
        if (node != null) {
            inOrderTraversalHelper(node.getLeft(), list);
            list.add(node.getData());
            inOrderTraversalHelper(node.getRight(), list);
        }
    }


    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }
}
