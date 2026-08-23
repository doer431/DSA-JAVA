package linkedlist;

public class DoublyLinkedList {

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
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        n++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        n++;
    }

    public void traverse() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public void traverseReverse() {
        Node curr = tail;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.prev;
        }
    }

    public boolean insertAfter(int value, int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {
                Node newNode = new Node(value);
                newNode.next = curr.next;
                newNode.prev = curr;
                if (curr.next != null) {
                    curr.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                curr.next = newNode;
                n++;
                return true;
            }
            curr = curr.next;
        }
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
            head.prev = null;
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
            tail.next = null;
        }
        n--;
    }

    public void remove(int key) {
        Node curr = head;
        while (curr != null) {
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
        }
        System.out.println("no such element");
    }

    public String search(int value) {
        Node curr = head;
        int pos = 1;
        while (curr != null) {
            if (curr.data == value) {
                return "index at : " + pos;
            }
            curr = curr.next;
            pos++;
        }
        return "Not found";
    }



    public void reverse() {
        Node curr = head;
        Node temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = curr.prev;
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    public void clear() {
        head = null;
        tail = null;
        n = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.traverse();
        dll.traverseReverse();
        dll.reverse();
        System.out.println("after reverse:");
        dll.traverse();
    }
}