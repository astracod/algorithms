package org.example;

import org.example.MyList.SinglyLinkedList;
import org.example.MyList.Student;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        list.printMessage("Добавление элементов");
        list.add(4);
        list.add(5);
        list.add(7);
        list.print();
        list2.printMessage("Добавление элементов во второй лист");
        list2.add(4);
        list2.add(5);
        list2.add(7);
        list2.print();
        System.out.println(list.findLess(list2));
    }
}