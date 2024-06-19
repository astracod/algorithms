package org.example.MyList;

import java.util.Objects;

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
        size = 0;
    }

    public void add(int k) {
        head = new Node(k, head);
        ++size;
    }

    public void insertionByValue(int k) {
        if (head == null) add(k);
        else if (head.getKey() > k)
            head = new Node(k, head);
        else {
            Node tmp = head;
            while (tmp.getNext() != null && tmp.getNext().getKey() < k)
                tmp = tmp.getNext();
            tmp.setNext(new Node(k, tmp.getNext()));
        }
        size++;
    }

    public void addByIndex(int index, int k) {
        if (index > size) return;
        if (index == 0) {
            head = new Node(k, head);
            size++;
            return;
        }
        Node tmp = head;
        int counter = 0;
        while (tmp != null) {
            ++counter;
            if (counter == index) {
                tmp.setNext(new Node(k, tmp.getNext()));
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

    public void removeByValue(int value) {
        if (head == null)        // если список пуст
            return;
        if (head.getKey() == value) {    // если нужно удалить первый элемент
            head = head.getNext();
            size--;
            return;
        }
        Node x = head;            // если нужно удалить любой другой элемент
        while (x.getNext() != null && x.getNext().getKey() != value)
            x = x.getNext();
        if (x.getNext() != null) {
            x.setNext(x.getNext().getNext());
            size--;
        }
    }

    public void removeByIndex(int index) {
        if (index > size - 1 || this.size == 0) return;
        Node tmp = head;
        int counter = 0;
        while (tmp.getNext() != null) {
            if (index == 0) {
                head = head.getNext();
                size--;
                return;
            }
            if (counter == index - 1) {
                tmp.setNext(tmp.getNext().getNext());
                size--;
                return;
            }
            counter++;
            tmp = tmp.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node newNode){
        head = newNode;
    }

    public int contain(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.key == value) return tmp.getKey();
            else tmp = tmp.next;
        }
        return -1;
    }

    public String findLess(SinglyLinkedList list) {
        Node first = this.getHead();
        Node second = list.getHead();
        while (first != null && second != null) {
            if (first.getKey() > second.getKey()) return "second";
            if (first.getKey() < second.getKey()) return "first";
            first = first.getNext();
            second = second.getNext();
        }
        if (first == null && second == null) return "equal";
        if (first != null) return "second";
        return "first";
    }

    public SinglyLinkedList mergeSortingLists(SinglyLinkedList list) {
        Node first = this.getHead();
        Node second = list.getHead();
        SinglyLinkedList lastList = new SinglyLinkedList();
        Node ll;
        if (first.getKey() <= second.getKey()) {
            lastList.setHead(new Node(first.getKey(), null));
            ll = lastList.getHead();
            first = first.getNext();
            lastList.size++;
        } else {
            lastList.setHead(new Node(second.getKey(), null));
            ll = lastList.getHead();
            second = second.getNext();
            lastList.size++;
        }
        int counter = 1;
        while (first.getNext() != null && second.getNext() != null) {
            if (first.getKey() <= second.getKey()) {
                Objects.requireNonNull(ll).setNext(new Node(first.getKey()));
                ll = ll.getNext();
                lastList.size++;
                first = first.getNext();
            } else {
                ll.setNext(new Node(second.getKey()));
                ll = ll.getNext();
                lastList.size++;
                second = second.getNext();
            }

            ++counter;
            if (counter == this.size && first.getKey() <= second.getKey()){
                Objects.requireNonNull(ll).setNext(new Node(first.getNext().getKey()));
                lastList.size++;
                ll = ll.getNext();
            }
            else if (counter == list.size && (first.getKey() > second.getKey())){
                Objects.requireNonNull(ll).setNext(new Node(second.getNext().getKey()));
                lastList.size++;
                ll = ll.getNext();
            }
        }

        if (first.getNext() != null) {
            while (first.getNext() != null) {
                Objects.requireNonNull(ll).setNext(new Node(first.getKey()));
                lastList.size++;
                first = first.getNext();
                ll = ll.getNext();
            }
        } else {
            while (second.getNext() != null) {
                ll.setNext(new Node(second.getKey()));
                lastList.size++;
                second = second.getNext();
                ll = ll.getNext();
            }
        }
        lastList.print();
        return lastList;
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
