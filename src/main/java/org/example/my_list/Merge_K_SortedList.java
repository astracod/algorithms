package org.example.my_list;

public class Merge_K_SortedList {
    public static class ListNode {
        private int key;

        public ListNode() {
        }

        private ListNode next;

        public ListNode(int key, ListNode next) {
            this.key = key;
            this.next = next;
        }

        public ListNode(int key) {
            this.key = key;
            this.next = null;
        }

        public int getKey() {
            return key;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

    }

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    private int size = 0;

    public Merge_K_SortedList() {
        head = null;
        size = 0;
    }

    public void addFirst(int k) {
        head = new ListNode(k, head);
        ++size;
    }

    public void add(int k) {
        if (this.head == null) addFirst(k);
        else {
            ListNode tmp = this.head;
            while (tmp.getNext() != null)
                tmp = tmp.getNext();
            tmp.setNext(new ListNode(k, null));
        }
    }

    public void print() {
        ListNode tmp = this.head;
        while (tmp != null) {
            System.out.print(tmp.getKey() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] ref = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            ref[i] = lists[i];
        }

        ListNode lastList = null;
        ListNode tmp = null;
        int min;
        int pos = 1;

        while (pos != -1) {
            min = 100000;
            pos = -1;
            for (int i = 0; i < ref.length; i++) {
                if (ref[i] != null && min > ref[i].key) {
                    min = ref[i].key;
                    pos = i;
                }
            }
            if (pos == -1) break;

            if (lastList == null) {
                lastList = new ListNode(min, null);
                tmp = lastList;
            } else {
                tmp.setNext(new ListNode(min, null));
                tmp = tmp.getNext();
            }

            ref[pos] = ref[pos].getNext();
        }
        return lastList;
    }

}

class Solutions {

    public static void main(String[] args) {
        // lists = [[1,4,5],[1,3,4],[2,6]]
        Merge_K_SortedList.ListNode[] lists = new Merge_K_SortedList.ListNode[3];
        Merge_K_SortedList list = new Merge_K_SortedList();
        Merge_K_SortedList list2 = new Merge_K_SortedList();
        Merge_K_SortedList list3 = new Merge_K_SortedList();
        list.add(1);
        list.add(4);
        list.add(5);
        list.print();
        list2.add(1);
        list2.add(3);
        list2.add(4);
        list2.print();
        list3.add(2);
        list3.add(6);
        list3.print();
        lists[0] = list.getHead();
        lists[1] = list2.getHead();
        lists[2] = list3.getHead();
        list.mergeKLists(lists);
        System.out.println("-----------Merge-------------------");
        Merge_K_SortedList.ListNode lastList = list.mergeKLists(lists);
        while (lastList != null) {
            System.out.print(lastList.getKey() + " ");
            lastList = lastList.getNext();
        }


    }

}