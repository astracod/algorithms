package org.example.multithreading;

import java.util.ArrayList;
import java.util.List;

public class MySynchronization {

    /**
     * Здесь показана работа ключего слова synchronized и методов wait() и notify().
     */
    public static void main(String[] args) {
        SharedResources sharedResources = new SharedResources();
        Writer writer = new Writer(sharedResources);
        Reader reader = new Reader(sharedResources);
        Thread threadWriter = new Thread(writer);
        Thread threadReader = new Thread(reader);
        threadWriter.start();
        threadReader.start();
    }
}

class SharedResources {
    private final List<Integer> commonResources = new ArrayList<>();
    private boolean isEmpty = true;

    public synchronized void read() throws InterruptedException {
        System.out.println("Чтение начато");
        while (isEmpty) {
            wait();
        }
        System.out.println(commonResources);
        commonResources.clear();
        isEmpty = true;
        notify();
        System.out.println("Чтение закончено");
    }

    public synchronized void write() {
        System.out.println("Запись начата");
        int i = 0;
        while (i < 10) {
            commonResources.add(i);
            i++;
        }
        isEmpty = false;
        notify();
        System.out.println("Запись закончена");
    }

    public synchronized boolean isEmpty() {
        return isEmpty;
    }

}

class Reader implements Runnable {
    SharedResources sharedResources;

    public Reader(SharedResources sharedResources) {
        this.sharedResources = sharedResources;
    }

    @Override
    public void run() {
        try {
            sharedResources.read();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

record Writer(SharedResources sharedResources) implements Runnable {
    @Override
    public void run() {
        try {
            // Без этой синхронизации, писатель и читатель могли бы пытаться изменить список commonResources одновременно,
            // что привело бы к ошибкам.
            synchronized (sharedResources) {
                while (!sharedResources.isEmpty()) {
                    sharedResources.wait(); // Ждем, пока reader не очистит список
                }
                sharedResources.write();
                sharedResources.notify(); // Уведомляем reader о завершении записи
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}