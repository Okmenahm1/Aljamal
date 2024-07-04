package com.example.datastructerproject2;

public class Stack {
    District[] stack;
    static int SIZE = 100;
    int top = -1;



    public int getSize(){
        return stack.length;
    }



    public Stack (){
        this.stack = new District[SIZE];
    }

    public Stack(int size) {
        stack = new District[size];
        top = -1;
    }

    public boolean isFull(){
        return top == SIZE-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(District o) {
        if(isFull()){
            return;
        }
        stack[++top] = o;
    }


    public District pop(){
        if(isEmpty()){
            return null;
        }

        return stack[top--];
    }

    public District peek(){
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

