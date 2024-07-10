package org.example.my_stack;

public class StackList {
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

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private Node head;

    private int size = 0;

    public StackList() {
        head = null;
        size = 0;
    }

    public void push(int k) {
        head = new Node(k, head);
        ++size;
    }

    public void pop() {
        if(head==null) System.out.println("error");
        else {
            System.out.println(head.key);
            head = head.getNext();
            --size;
        }
    }

    public int getSize() {
        return size;
    }

    public void peek() {		//peek/top/back
        if(head==null) System.out.println("error");
        else System.out.println(head.key);
    }

    public void clear() {
        head = null;
        size = 0;
    }
    public boolean isEmpty() {
        return head == null;
    }
}

class SolutionsStackList{
    public static void main(String[] args) {
        StackList list = new StackList();

        int i = 1;
        while (list.getSize() < 4){
            list.push(i++);
        }
        list.clear();
        list.peek();

    }
}