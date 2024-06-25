package org.example.algorithms;

import org.example.MyList.SinglyLinkedList;

public class DoublyLinkedList {
    public static class Node {
        private Node prev;
        private Node next;
        private int key;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }

        public Node(Node prev, int key, Node next) {
            this.prev = prev;
            this.key = key;
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

    private Node head;

    private Node tail;

    private int size = 0;

    public int getSize() {
        return size;
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.key + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void addFirst(int k) {
        head = new Node(null, k, head);
        if (tail == null)
            tail = head;
        ++size;
    }

    /**
     * добавление в конец списка
     *
     * @param k
     */
    public void add(int k) {
        if (tail == null) {
            tail = new Node(null, k, null);
            head = tail;
        } else {
            tail.setNext(new Node(tail, k, null));
            tail = tail.getNext();
        }
        size++;
    }

    public void removeLast() {
        Node tmp = tail.getPrev();
        tmp.setNext(null);
        tail = tmp;
        size--;
    }

    public void removeFirst() {
        Node tmp = head.getNext();
        tmp.setPrev(null);
        head = tmp;
        size--;
    }

    public void addByIndex(int index, int k) {
        if (index > this.size || index < 0) return;
        Node tmp = head;
        Node lastNode = tail;
        if (index == 0) {
            tmp = new Node(null, k, tmp);
            head = tmp;
        }
        if (index > 0 && index < this.size) {
            while (index > 0) {
                tmp = tmp.getNext();
                index--;
            }
            Node insert = new Node(tmp.getPrev(), k, tmp);
            tmp.getPrev().setNext(insert);
            tmp.setPrev(insert);
        }
        if (index == this.size) {
            Node newNode = new Node(lastNode, k, null);
            lastNode.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void addToSorted(int k) {
        Node tmp = head;
        Node last = tail;
        if (k <= tmp.key) {
            tmp.setPrev(new Node(null, k, tmp));
            head = tmp.getPrev();
            size++;
            return;
        }
        if (k >= last.key) {
            Node newNode = new Node(tmp, k, null);
            tail.setNext(newNode);
            Node pr = tail;
            tail = tail.getNext();
            tail.setPrev(pr);
        }
        while (tmp != null && tmp.getKey() <= k) {
            if (tmp.next != null && tmp.next.key > k) {
                Node newNode = new Node(tmp, k, tmp.getNext());
                tmp.setNext(newNode);
                tmp.next.setPrev(newNode);
                break;
            }
            tmp = tmp.getNext();
        }
        size++;
    }

    public void remove(int k) {
        Node tmp = head;
        Node lastNode = tail;
        if (lastNode.key == k) {
            lastNode.getPrev().setNext(null);
            tail = lastNode.getPrev();
        }
        while (tmp != null) {
            if (tmp.key == k) {
                if (tmp.getPrev() == null) {
                    tmp.getNext().setPrev(null);
                    tmp = tmp.getNext();
                    head = tmp;
                }
                if (tmp != head && tmp != tail) {
                    tmp.getPrev().setNext(tmp.getNext());
                    tmp.getNext().setPrev(tmp.getPrev());
                }
            }
            tmp = tmp.getNext();
        }
        size--;
    }

    public void removeByIndex(int i) {
        Node tmp = head;
        if (i == 0) {
            tmp.getNext().setPrev(null);
            head = tmp.getNext();
            size--;
            return;
        }
        if (i == this.size - 1) {
            tmp.getPrev().setNext(null);
            tail = tmp.getPrev();
            size--;
            return;
        }
        while (i >= 0) {
            if (i == 0) {
                tmp.getPrev().setNext(tmp.getNext());
                tmp.getNext().setPrev(tmp.getPrev());
            }
            tmp = tmp.getNext();
            i--;
        }
    }

}

class SolutionDoublyList {
    public static void main(String[] args) {
        DoublyLinkedList l1 = new DoublyLinkedList();
        DoublyLinkedList l2 = new DoublyLinkedList();

        System.out.println("----Method Add-----------");
        l1.add(2);
        l1.add(3);
        l1.add(5);
        l1.print();
        System.out.println("----Method addToSorted-----------");
        l1.addToSorted(4);
        l1.addToSorted(6);
        l1.addToSorted(1);
        l1.addToSorted(1);
        l1.print();
        System.out.println("----Method removeByIndex-----------");
        l1.removeByIndex(2);
        l1.removeByIndex(0);
        l1.print();
    }
}
