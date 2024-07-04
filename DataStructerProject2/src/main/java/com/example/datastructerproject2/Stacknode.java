package com.example.datastructerproject2;

public class Stacknode {
    Node[] stack;
    static int SIZE = 100;
    int top = -1;



    public int getSize(){
        return stack.length;
    }



    public Stacknode (){
        this.stack = new Node[SIZE];
    }

    public Stacknode(int size) {
        stack = new Node[size];
        top = -1;
    }

    public boolean isFull(){
        return top == SIZE-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(Node o) {
        if(isFull()){
            return;
        }
        stack[++top] = o;
    }


    public Node pop(){
        if(isEmpty()){
            return null;
        }

        return stack[top--];
    }

    public Node peek(){
        if(isEmpty()){
            return null;
        }
        return stack[top];
    }

    public void clear() {
        top = -1;
    }

    public void print(Stack stack){
        Stack stack2 = new Stack(stack.getSize());

        while(!stack.isEmpty()){
            System.out.println(stack.peek().toString());
            stack2.push(stack.pop());
        }

        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }


    }


}

