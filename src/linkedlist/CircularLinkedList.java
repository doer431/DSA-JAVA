package linkedlist;

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private int n;

    private static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
        }
    }

    public int size() {
        return n;
    }

    public void insertHead(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        n++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        n++;
    }

    public void traverse() {
        if (head == null) {
            return;
        }
        Node curr = head;
        do {
            System.out.print(curr.data + "->");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    public void traverseReverse() {
        if (tail == null) {
            return;
        }
        Node curr = tail;
        do {
            System.out.print(curr.data + "->");
            curr = curr.prev;
        } while (curr != tail);
        System.out.println();
    }

    public boolean insertAfter(int value, int key) {
        if (head == null) {
            System.out.println("empty list");
            return false;
        }
        Node curr = head;
        do {
            if (curr.data == key) {
                Node newNode = new Node(value);
                newNode.next = curr.next;
                newNode.prev = curr;
                curr.next.prev = newNode;
                curr.next = newNode;
                if (curr == tail) {
                    tail = newNode;
                }
                n++;
                return true;
            }
            curr = curr.next;
        } while (curr != head);
        System.out.println("item not found");
        return false;
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("empty list");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        n--;
    }

    public void pop() {
        if (tail == null) {
            System.out.println("empty list");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        n--;
    }

    public void remove(int key) {
        if (head == null) {
            System.out.println("empty list");
            return;
        }
        Node curr = head;
        do {
            if (curr.data == key) {
                if (curr == head) {
                    deleteHead();
                } else if (curr == tail) {
                    pop();
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    n--;
                }
                return;
            }
            curr = curr.next;
        } while (curr != head);
        System.out.println("no such element");
    }

    public String search(int value) {
        if (head == null) {
            return "Not found";
        }
        Node curr = head;
        int pos = 1;
        do {
            if (curr.data == value) {
                return "index at : " + pos;
            }
            curr = curr.next;
            pos++;
        } while (curr != head);
        return "Not found";
    }



    public void clear() {
        head = null;
        tail = null;
        n = 0;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.append(1);
        cll.append(2);
        cll.append(3);
        cll.traverse();
        cll.traverseReverse();
        cll.remove(2);
        cll.traverse();
    }
}