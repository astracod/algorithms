package org.example.algorithms;

import java.util.Arrays;

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

    public int guess(int n) {
        int pick = 6;
        if (n > pick) {
            return -1;
        } else if (n < pick) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     *  LeetCode
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        if (guess(n) != 0) {
            n = guess(n) > 0 ? n + 1 : n - 1;
            System.out.println("number : "+ n);
            return guessNumber(n);
        }
        return n;
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


}

class SolutionRecursiveTasks {

    public static void main(String[] args) {
        int[] numbers = {-5, -3, -2, 1, 2, 3, 4, 5};
        Recursion rec = new Recursion();
        System.out.println(rec.guessNumber(-10));

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
