package Homework.HW5;

public class LinkedList {
    Node head;

    static class Node {
        Object value;
        Node next;

        Node(Object obj) {
            value = obj;
            next = null;
        }
    }

    public void insert(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }
}
