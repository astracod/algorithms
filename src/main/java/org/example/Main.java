package org.example;

import org.example.my_list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        list.printMessage("Добавление элементов");
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(1);
        list.print();
        list2.printMessage("Добавление элементов во второй лист");
        list2.add(6);
        list2.add(4);
        list2.add(2);
        list2.print();
        System.out.println("--------Поочередное Слияние---------------------");
        SinglyLinkedList s = list.alternateMerger(list, list2);
        s.print();
        System.out.println("list size : "+ s.getSize());
    }
}