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
        if (head == null) {
            addFirst(k);
        } else if (k <= tmp.key) {
            tmp.setPrev(new Node(null, k, tmp));
            head = tmp.getPrev();
        } else if (k >= last.key) {
            tail.setNext(new Node(last, k, null));
            tail = tail.getNext();
        } else {
            while (tmp != null &&  tmp.getKey() < k) {
                tmp = tmp.getNext();
            }
            Node newNode = new Node(tmp.getPrev(), k, tmp);
            tmp.setPrev(newNode);
            newNode.getPrev().setNext(newNode);
        }
        size++;
    }

    public void remove(int k) {
        Node tmp = head;
        Node lastNode = tail;
        if (tmp.key == k && tmp.next == null) {
            head = null;
            tail = null;
            size = 0;
        } else if (lastNode.key == k) {
            lastNode.getPrev().setNext(null);
            tail = lastNode.getPrev();
        } else if (tmp.key == k) {
            tmp.getNext().setPrev(null);
            tmp = tmp.getNext();
            head = tmp;
        } else {
            while (tmp != null && tmp.key != k) {
                tmp = tmp.getNext();
            }
            if (tmp != null) {
                tmp.getPrev().setNext(tmp.getNext());
                tmp.getNext().setPrev(tmp.getPrev());
            }
        }
        size--;
    }

    public void removeByIndex(int i) {
        if (head == null) return;
        if (this.size - 1 < i) return;
        Node tmp = head;
        while (i > 0) {
            tmp = tmp.getNext();
            i--;
        }
        if (tmp.getPrev() != null) {
            tmp.getPrev().setNext(tmp.getNext());
        } else {
            head = tmp.getNext();
        }
        if (tmp.getNext() != null) {
            tmp.getNext().setPrev(tmp.getPrev());
        } else {
            tail = tmp.getPrev();
        }
    }

    public void swap(DoublyLinkedList list2) {
        Node firstHead = this.head;
        Node secondHead = list2.head;
        Node firstTail = this.tail;
        Node secondTail = list2.tail;

        Node bufFH = firstHead;
        Node bufFT = firstTail;
        firstHead = secondHead;
        firstTail = secondTail;

        secondHead = bufFH;
        secondTail = bufFT;

        System.out.println("----first list-------");
        while (firstHead != null){
            System.out.print(firstHead.key+ " ");
            firstHead = firstHead.next;
        }
        System.out.println();
        System.out.println("----second list-------");
        while (secondHead != null){
            System.out.print(secondHead.key+" ");
            secondHead = secondHead.next;
        }
    }

    public boolean isSorted(){
        Node tmp = head;
        while (tmp.next != null){
            if (tmp.key > tmp.next.key) return false;
            tmp = tmp.getNext();
        }
        return true;
    }

}

class SolutionDoublyList {
    public static void main(String[] args) {
        DoublyLinkedList l1 = new DoublyLinkedList();
        DoublyLinkedList l2 = new DoublyLinkedList();

        System.out.println("----Method Swap-----------");
        l1.add(1);
        l1.add(3);
        l1.add(5);
        l1.print();
        System.out.println("--------2 list-----------");
        l2.add(8);
        l2.add(4);
        l2.add(5);
        l2.print();
        System.out.println(l1.isSorted());

    }
}