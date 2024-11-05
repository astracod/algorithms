package org.example.my_list;

public class SinglyLinkedList {
    public static class Node {
        private int key;

        private Node next;

        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }

        public Node() {
        }

        public Node(int key) {
            this.key = key;
            this.next = null;
        }

        public int getKey() {
            return key;
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

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public SinglyLinkedList(SinglyLinkedList list) {
        if (list.head == null) return;

        Node l1 = list.head;
        this.head = new Node(l1.getKey());
        Node copy = this.getHead();
        l1 = l1.getNext();
        this.size++;

        while (l1 != null) {
            copy.setNext(new Node(l1.getKey()));
            copy = copy.getNext();
            this.size++;
            l1 = l1.getNext();
        }
    }

    public void add(int k) {
        // в ссылку next добавляется прежнее значение ссылки head и обновляется head через знак =, что делает его первым.
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

    public void setHead(Node newNode) {
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
        if (list.head == null) return new SinglyLinkedList();
        Node first = this.getHead();
        Node second = list.getHead();
        SinglyLinkedList lastList = new SinglyLinkedList();
        Node ll;

        if (first.getKey() <= second.getKey()) {
            lastList.head = new Node(first.getKey());
            ll = lastList.getHead();
            first = first.getNext();
            lastList.size++;
        } else {
            lastList.setHead(new Node(second.getKey()));
            ll = lastList.getHead();
            second = second.getNext();
            lastList.size++;
        }

        while (first != null && second != null) {
            if (first.getKey() <= second.getKey()) {
                ll.setNext(new Node(first.getKey()));
                ll = ll.getNext();
                lastList.size++;
                first = first.getNext();
            } else {
                ll.setNext(new Node(second.getKey()));
                ll = ll.getNext();
                lastList.size++;
                second = second.getNext();
            }
        }

        if (first != null) {
            while (first != null) {
                ll.setNext(new Node(first.getKey()));
                lastList.size++;
                first = first.getNext();
                ll = ll.getNext();
            }
        } else {
            while (second != null) {
                ll.setNext(new Node(second.getKey()));
                lastList.size++;
                second = second.getNext();
                ll = ll.getNext();
            }
        }
        return lastList;
    }

    public SinglyLinkedList alternateMerger(SinglyLinkedList firstList, SinglyLinkedList secondList) {
        Node first = firstList.head;
        Node second = secondList.head;
        SinglyLinkedList newList = new SinglyLinkedList();

        newList.setHead(new Node(first.getKey()));
        Node ll = newList.getHead();
        ll.setNext(new Node(second.getKey()));
        ll = ll.getNext();
        first = first.getNext();
        second = second.getNext();
        newList.size = newList.size + 2;

        while (first != null && second != null) {
            ll.setNext(new Node(first.getKey()));
            ll = ll.getNext();
            ll.setNext(new Node(second.getKey()));
            ll = ll.getNext();
            first = first.getNext();
            second = second.getNext();
            newList.size = newList.size + 2;
        }
        if (first != null) {
            while (first != null) {
                ll.setNext(new Node(first.getKey()));
                newList.size++;
                first = first.getNext();
                ll = ll.getNext();
            }
        } else {
            while (second != null) {
                ll.setNext(new Node(second.getKey()));
                newList.size++;
                second = second.getNext();
                ll = ll.getNext();
            }
        }
        return newList;
    }

    public Node removeElements(Node head, int val) {
        while(head != null && head.key == val){
            head = head.next;
        }
        Node tmp = head;
        while(tmp != null && tmp.next != null){
            if(tmp.next.key == val) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        }
        return head;
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

