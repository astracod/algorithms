package org.example.algorithms;

import org.example.my_list.DoublyLinkedList;

public class Recursion {
    public int binarySearch(int[] a, int p, int r, int x) {
        if (p > r) return -1;
        int q = (p + r) / 2;
        if (x == a[q]) return q;
        if (x > a[q])
            return binarySearch(a, q + 1, r, x);
        else
            return binarySearch(a, p, q - 1, x);
    }

    public int findMax(int[] a, int index, int max) {
        if (a.length == 0) return -1;
        if (index < a.length) {
            max = max > a[index] ? max : a[index];
            return findMax(a, index + 1, max);
        }
        return max;
    }

    public int findToList(DoublyLinkedList.Node head, int find, int res) {
        DoublyLinkedList.Node node = head;
        if (node.getNext() != null && node.getKey() != find)
            return findToList(node.getNext(), find, res);
        else
            return find == node.getKey() ? node.getKey() : -1;
    }

    public int guess(int n) {
        int pick = 1702766719;
        if (n > pick) {
            return -1;
        } else if (n < pick) {
            return 1;
        } else {
            return pick;
        }
    }

    public int guessNumber(int n) {
        return guessRec(0, n);
    }

    public int guessRec(int p, int r) {
        int q = p + (r - p) / 2;
        int res = guess(q);
        if (res == 0) return q;
        if (res == -1) return guessRec(p, q - 1);
        else return guessRec(q + 1, r);
    }


}

class SolutionRecursiveTasks {

    public static void main(String[] args) {
        int[] numbers = {-5, -3, -2, 1, 2, 3, 4, 5};
        Recursion rec = new Recursion();
        System.out.println(rec.guessNumber(2126753390));

//        System.out.println(rec.findMax(numbers, 0, 0));

//        DoublyLinkedList l1 = new DoublyLinkedList();
//        System.out.println("----Method Swap-----------");
//        l1.add(1);
//        l1.add(3);
//        l1.add(5);
//        l1.add(7);
//        l1.print();
//        System.out.println("---------findToList--------");
//        System.out.println(rec.findToList(l1.getHead(), 7, 0));
    }
}
