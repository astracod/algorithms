package org.example;

import org.example.MyList.SinglyLinkedList;
import org.example.MyList.Student;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(6);
        System.out.println(list.getHead().getKey());
        list.add(4);
        System.out.println(list.getHead().getKey());

        list.print();
        System.out.println("Получение длины листа");
        System.out.println(list.getSize());
        System.out.println("Содержит ли список элемент");
        System.out.println(list.contain(6));
        System.out.println(list.contain(2));
        System.out.println("Удаление первого элемента");
        list.removeFirst();
        System.out.println("Вывод длины списка после удаления и его содержание");
        System.out.println(list.getSize());
        list.print();
        System.out.println("Повтор удаления и вывод длины листа");
        list.removeFirst();
        System.out.println(list.getSize());

        Student student = new Student();
        student.setName("Dan");
        student.setId(102L);
        student.setGrades(new int[]{4,4,4,4});
        System.out.println(student);
    }
}