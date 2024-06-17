package org.example;

import org.example.MyList.SinglyLinkedList;
import org.example.MyList.Student;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.printMessage("Добавление элементов");
        list.add(6);
        list.add(4);
        list.print();
        list.printMessage("Вставка по значению элементов 3, 9, 5");
        list.insertionByValue(3);
        list.insertionByValue(9);
        list.insertionByValue(5);
        list.print();
        list.printMessage("Длина листа : "+ list.getSize());
        list.printMessage("Содержит ли список элемент");
        System.out.println(list.contain(6));
        System.out.println(list.contain(2));
        list.printMessage("Удаление первого элемента");
        list.removeFirst();
        list.printMessage("Длина листа : "+ list.getSize());
        list.print();
        list.printMessage("Добавление элемента: -1 по индексу: 3 ");
        list.addByIndex(3, -1);
        list.print();
        list.printMessage("Длина листа : "+ list.getSize());

    }
}