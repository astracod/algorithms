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
        if (index > size-1 || this.size == 0) return;
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

    public int contain(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.key == value) return tmp.getKey();
            else tmp = tmp.next;
        }
        return -1;
    }

    /**
     * Метод работает только с листами одинаковой длины.
     * Надо реализовать функционал для разнозначных длин SinglyLinkedList
     * @param list
     * @return
     */
    public String findLess(SinglyLinkedList list) {
        Node first = this.getHead();
        Node second = list.getHead();
        int counter = 0;
        if (this.getSize() == list.getSize()) {
            while (this.getSize() != counter) {
                if (first.getKey() > second.getKey()) return "second";
                if (first.getKey() < second.getKey()) return "first";
                first = first.getNext();
                second = second.getNext();
                counter++;
            }
        }
        return "equal";
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
