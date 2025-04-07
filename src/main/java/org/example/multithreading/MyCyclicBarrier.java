package org.example.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCyclicBarrier {
    /**
     * CyclicBarrier позволяет выполнять код, выдерживая определенный порядок выполнения в группе потоков.
     * То есть он не гарантирует поочередность выполнения внутри барьера согласно запуску потоков,
     * но барьер позволяет реализовать цикличность выполнения кода разными потоками, пока каждый из потоков не будет
     * соответствовать условию барьера.
     */
    private static class Resource {
        private int resource;
        private int id;
        private Lock lock = new ReentrantLock();

        public Resource(int id) {
            this.id = id;
        }

        public void add() {
            lock.lock();
            try {
                resource = +2;
                System.out.println("Поток " + id + " выполнил сложение с результатом " + resource);
            } finally {
                lock.unlock();
            }
        }

        public void subtraction() {
            lock.lock();
            try {
                resource -= 1;
                System.out.println("Поток " + id + " выполнил вычитание с результатом " + resource);
            } finally {
                lock.unlock();
            }
        }

        public void multiplication() {
            lock.lock();
            try {
                resource *= 3;
                System.out.println("Поток " + id + " выполнил умножение с результатом " + resource);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final CyclicBarrier barrier1 = new CyclicBarrier(3);
        final CyclicBarrier barrier2 = new CyclicBarrier(3);
        final CyclicBarrier barrier3 = new CyclicBarrier(3);
        Resource[] resources = new Resource[3];
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            resources[i] = new Resource(i + 1);
        }
        for (int i = 0; i < 3; i++) {
            final Resource number = resources[i];
            threads[i] = new Thread(()->{
                try {
                    number.add();
                    barrier1.await();

                    number.subtraction();
                    barrier2.await();

                    number.multiplication();
                    barrier3.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        for (int i = 0; i < 3; i++) {
            threads[i].start();
        }
    }
}
