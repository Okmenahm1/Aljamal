package com.example.datastructerproject2;

public class Stacklocation {

    Location[] stack;
    static int SIZE = 100;
    int top = -1;


    public int getSize() {
        return stack.length;
    }


    public Stacklocation() {
        this.stack = new Location[SIZE];
    }

    public Stacklocation(int size) {
        stack = new Location[size];
        top = -1;
    }

    public boolean isFull() {
        return top == SIZE - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Location o) {
        if (isFull()) {
            return;
        }
        stack[++top] = o;
    }


    public Location pop() {
        if (isEmpty()) {
            return null;
        }

        return stack[top--];
    }

    public Location peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    public void clear() {
        top = -1;
    }

    public void print(com.example.datastructerproject2.Stack stack) {
        com.example.datastructerproject2.Stack stack2 = new com.example.datastructerproject2.Stack(stack.getSize());

        while (!stack.isEmpty()) {
            System.out.println(stack.peek().toString());
            stack2.push(stack.pop());
        }

        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }


    }


}



