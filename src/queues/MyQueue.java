package queues;

public class MyQueue {

    private Node front;
    private Node rear;
    private int size;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            rear = front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    public void traverse() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.traverse();
        System.out.println("peek: " + queue.peek());
        System.out.println("dequeue: " + queue.dequeue());
        queue.traverse();
        System.out.println("size: " + queue.size());
    }
}