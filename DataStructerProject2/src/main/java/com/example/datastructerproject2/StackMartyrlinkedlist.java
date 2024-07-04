package com.example.datastructerproject2;

public class StackMartyrlinkedlist {

    Martryslinkedlist[] stack;
    static int SIZE = 100;
    int top = -1;


    public int getSize() {
        return stack.length;
    }


    public StackMartyrlinkedlist() {
        this.stack = new Martryslinkedlist[SIZE];
    }

    public StackMartyrlinkedlist(int size) {
        stack = new Martryslinkedlist[size];
        top = -1;
    }

    public boolean isFull() {
        return top == SIZE - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Martryslinkedlist o) {
        if (isFull()) {
            return;
        }
        stack[++top] = o;
    }


    public Martryslinkedlist pop() {
        if (isEmpty()) {
            return null;
        }

        return stack[top--];
    }

    public Martryslinkedlist peek() {
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



