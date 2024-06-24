package org.example;

import org.example.MyList.SinglyLinkedList;
import org.example.MyList.Student;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        list.printMessage("Добавление элементов");
        list.add(6);
        list.add(4);
        list.add(2);
        list.add(1);
        list.print();
        list2.printMessage("Добавление элементов во второй лист");
        list2.add(5);
        list2.add(4);
        list2.add(3);
        list2.add(1);
        list2.print();
        SinglyLinkedList s = list.mergeSortingLists(list2);
        s.print();
        System.out.println("list size : "+ s.getSize());
        System.out.println("Копирующий конструктор");
    }
}