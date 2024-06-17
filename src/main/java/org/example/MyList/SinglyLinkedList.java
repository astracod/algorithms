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

    private int index;

    public SinglyLinkedList() {
        head = null;
    }

    public void add(int k) {
        head = new Node(k, head);
        ++size;
    }

    public void insertionByValue(int k) {
        if (head == null) add(k);
        else if (head.getKey() > k) {
            Node tmp = head;
            head = new Node(k, tmp);
            size++;
        } else {
            Node tmp = head;
            while (tmp != null) {
                if (tmp.getNext() == null && k > tmp.getKey()) {
                    Node last = new Node(k, null);
                    tmp.setNext(last);
                }
                if (tmp.getKey() < k && tmp.getNext().getKey() > k) {
                    Node now = new Node(k, tmp.getNext());
                    tmp.setNext(now);
                }
                tmp = tmp.getNext();
            }
            size++;
        }
    }

    public void addByIndex(int index, int value) {
        Node tmp = head;
        int counter = 0;
        while (tmp != null) {
            ++counter;
            if (counter == index) {
                Node newElement = new Node(value, tmp.getNext());
                tmp.setNext(newElement);
                size++;
                break;
            }
            tmp = tmp.getNext();
        }
    }

    public void removeFirst() {
        head = head.getNext();
        --size;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public int contain(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.key == value) return tmp.getKey();
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

    public void printMessage(String message) {
        System.out.println(message);
    }
}
