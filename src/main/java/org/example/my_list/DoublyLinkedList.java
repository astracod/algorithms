package org.example.my_list;

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

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

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
            while (tmp != null && tmp.getKey() < k) {
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
        int bufSize = list2.size;
        list2.size = this.size;
        this.size = bufSize;

        Node buf = list2.head;
        list2.head = this.head;
        this.head = buf;

        buf= list2.tail;
        list2.tail = this.tail;
        this.tail = buf;
    }

    public boolean isSorted() {
        Node tmp = head;
        while (tmp.next != null) {
            if (tmp.key > tmp.next.key) return false;
            tmp = tmp.getNext();
        }
        return true;
    }

    public void printRec(boolean res) {
        Node tmp = this.head;
        if (this.size == 0) return;
        if (res) {
            if (tmp != null) {
                printRec(tmp);
            }
        } else {
            if (tmp != null) {
                revertPrintRec(tmp);
            }
        }
    }

    private void printRec(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            printRec(node.next);
        }
    }

    private void revertPrintRec(Node node) {
        if (node != null) {
            printRec(node.next);
        }
        System.out.print(node.key + " ");
    }

    public void printInt(int i) {
        int denominator = 10;
        int num = i % denominator;
        int numerator = i / denominator;

        System.out.print(num+" ");

        if (numerator > 0) {
            printInt(numerator);
        }
    }

    public void revertPrintInt(int i) {
        int denominator = 10;
        int num = i % denominator;
        int numerator = i / denominator;

        if (numerator > 0) {
            revertPrintInt(numerator);
        }
        System.out.print(num+" ");
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
        l1.add(7);
        l1.print();
        System.out.println("--------2 list-----------");
        l2.add(8);
        l2.add(4);
        l2.add(5);
        l2.print();
        System.out.println("----------swap-------------");
        l1.swap(l2);
        l1.print();
        System.out.println(" l1 size : "+ l1.getSize());
        l2.print();
        System.out.println(" l2 size : "+ l2.getSize());
    }
}