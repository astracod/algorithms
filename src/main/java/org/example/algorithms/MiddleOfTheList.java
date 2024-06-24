package org.example.algorithms;

public class MiddleOfTheList {

    public static class ListNode {

        int val;
        ListNode next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode head;

    public void setHead(ListNode head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int size = 0;

    public MiddleOfTheList() {
        this.head = null;
        this.size = 0;
    }

    public ListNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void add(int k) {
        head = new ListNode(k, head);
        ++size;
    }

    public void print() {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public ListNode middleNode(ListNode head) {
        ListNode tmp = head;
        int counter = 0;
        while (tmp != null) {
            tmp = tmp.next;
            counter++;
        }
        int result = counter / 2;
        ListNode resultNode = head;
        int i = 0;
        while (resultNode != null) {
            if (i == result) return resultNode;
            resultNode = resultNode.next;
            i++;
        }
        return new ListNode();
    }

    public ListNode reverseList(ListNode head) {
        ListNode tmp = head;
        ListNode prev = null;
        ListNode future ;
        while (tmp != null) {
            future = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = future;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode result = null;
        int rest = 0;

        int sum = first.val + second.val + rest;
        rest = sum / 10;
        result = new ListNode(sum % 10);
        first = first.next;
        second = second.next;
        ListNode tmp = result;

        while (first != null && second != null) {
            sum = first.val + second.val + rest;
            rest = sum / 10;
            tmp.setNext(new ListNode(sum % 10));
            first = first.next;
            second = second.next;
            tmp = tmp.getNext();
        }

        if (first != null) {
            while (first != null) {
                sum = first.val + rest;
                rest = sum / 10;
                tmp.setNext(new ListNode(sum % 10));
                first = first.next;
                tmp = tmp.getNext();
            }

        }
        if (second != null) {
            while (second != null) {
                sum = second.val + rest;
                rest = sum / 10;
                tmp.setNext(new ListNode(sum % 10));
                second = second.next;
                tmp = tmp.getNext();
            }

        }
        if (rest != 0) {
            tmp.setNext(new ListNode(rest));
        }
        return result;
    }

    public ListNode breakTheList() throws InterruptedException {
        ListNode tmp = this.head;
        ListNode res = new ListNode();
        int point = 0;
        ListNode buffer = new ListNode();
        while (point <= this.size){
            if (point == 3){
                Thread.sleep(1000);
                buffer.setNext(tmp);
                point++;
                tmp = tmp.next;
            }
            if (point == 5){
                Thread.sleep(1000);
                tmp.setNext(buffer);
                point++;
                tmp = tmp.next;
            }
            Thread.sleep(1000);
            if (point == 6){
                res.setNext(tmp);
            }
            point++;
            tmp = tmp.next;
        }
        return res;
    }

    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null){
            first = first.next;
            second= second.next.next;
            if(first == second) return true;
        }
        return false;
    }
}


class Solution {

    public static void main(String[] args) throws InterruptedException {
        MiddleOfTheList list = new MiddleOfTheList();
        MiddleOfTheList list2 = new MiddleOfTheList();
        MiddleOfTheList list3 = new MiddleOfTheList();
        MiddleOfTheList list4 = new MiddleOfTheList();
//        list.add(9);
//        list.add(9);
//        list.add(9);
//        list.add(9);
//        list.add(9);
//        list.add(9);
//        list.add(9);
//
//        list2.add(9);
//        list2.add(9);
//        list2.add(9);
//        list2.add(9);
//        list.print();
//        System.out.println("''''''''''''''");
//        list2.print();
//        System.out.println("----------------------------------");
//        list3.setHead(list.addTwoNumbers(list.getHead(), list2.getHead()));
//        list3.print();
        System.out.println("---Revers Linked List------");
        list4.add(7);
        list4.add(6);
        list4.add(5);
        list4.add(3);
        list4.add(2);
        list4.add(1);
        list4.print();
        System.out.println("--------------------------");
//        list.setHead(list.reverseList(list4.getHead()));
//        System.out.println("--------------------------");
//        MiddleOfTheList.ListNode node = list.getHead();
//        while (node != null){
//            System.out.print(node.val);
//            node = node.getNext();
//        }
//        System.out.println();
        System.out.println("-----Linked List Cycle--------");
        System.out.println("CYCLE list : "+ list.hasCycle(list4.getHead()) );
        MiddleOfTheList.ListNode node1  = list4.breakTheList();
        System.out.print("CYCLE node : "+ list.hasCycle(node1) );
//        list.print();

    }


}