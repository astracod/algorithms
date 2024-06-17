package org.example.MyList;

public class SinglyLinkedList {
    public static class Node {
        private int key;

        private Node next;

        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }

        public Node(int key) {
            this.key = key;
            this.next = null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private Node head;

    private int size = 0;

    public Node getHead() {
        return head;
    }

    public SinglyLinkedList() {
        head = null;
    }

    public void add(int k) {
        head = new Node(k, head);
        ++size;
    }

    public void removeFirst() {
        Node tmp = head;
        head = tmp.getNext();
        --size;
    }

    public int getSize() {
        return size;
    }

    public int contain(int value){
        Node tmp = head;
        while (tmp != null) {
            if(tmp.key == value) return tmp.getKey();
            else tmp = tmp.next;
        }
        return -1;
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.key + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
