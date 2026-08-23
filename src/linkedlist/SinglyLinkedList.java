package linkedlist;

public class SinglyLinkedList {

    private Node head;
    private int n;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public int size() {
        return n;
    }

    public void insertHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        n++;
    }

    public void traverse() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            n++;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        n++;
    }

    public boolean insertAfter(int value, int key) {
        Node newNode = new Node(value);
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {
                newNode.next = curr.next;
                curr.next = newNode;
                n++;
                return true;
            }
            curr = curr.next;
        }
        System.out.println("item not found");
        return false;
    }

    public void clear() {
        head = null;
        n = 0;
        // Dropping the reference to head is enough. Once nodes become
        // unreachable, Java's garbage collector reclaims their memory
        // automatically — same idea as Python's GC. O(1) and safe.
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        head = head.next;
        n--;
    }

    public void pop() {
        if (head == null) {
            System.out.println("empty LL");
            return;
        }
        if (head.next == null) {
            deleteHead();
            return;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        n--;
    }

    public void remove(int key) {
        if (head == null) {
            System.out.println("empty list");
            return;
        }
        if (head.data == key) {
            deleteHead();
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == key) {
                break;
            }
            curr = curr.next;
        }
        if (curr.next == null) {
            System.out.println("no such element");
        } else {
            curr.next = curr.next.next;
            n--;
        }
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
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        head = prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList  ll = new SinglyLinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.traverse();
        ll.reverse();
        System.out.println("after reverse:");
        ll.traverse();
        System.out.println(ll.search(2));
    }
}
