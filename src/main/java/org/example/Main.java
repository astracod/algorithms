package org.example;

import org.example.my_list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        list.printMessage("Добавление элементов");
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(2);
        list.add(1);
        list.print();

        list2.add(5);
        list2.add(7);
        list2.add(7);
        list2.add(2);
        list2.print();
//        SinglyLinkedList.Node node = list.removeElements(list.getHead(),6);

        // [1,2,6,3,4,5,6]
//        while (node != null){
//            System.out.print(node.getKey()+ " ");
//            node = node.getNext();
//        }
        System.out.println('\n'+"----------------------------------");

    }
}