package stacks;

public class MyStack {

    private Node top;
    private int size;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void traverse() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack");
        }
        return top.data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.traverse();
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        stack.traverse();
        System.out.println("size: " + stack.size());
    }
}