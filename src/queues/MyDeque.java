package queues;

public class MyDeque {

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

    public void insertFront(int value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
        size++;
    }

    public void insertRear(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            rear = front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public int deleteRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        int data = rear.data;

        if (front == rear) {
            front = rear = null;
        } else {
            Node curr = front;
            while (curr.next != rear) {
                curr = curr.next;
            }
            curr.next = null;
            rear = curr;
        }

        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
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
        MyDeque dq = new MyDeque();
        dq.insertRear(1);
        dq.insertRear(2);
        dq.insertFront(0);
        dq.traverse();
        System.out.println("deleteRear: " + dq.deleteRear());
        System.out.println("deleteFront: " + dq.deleteFront());
        dq.traverse();
        System.out.println("size: " + dq.size());
    }
}