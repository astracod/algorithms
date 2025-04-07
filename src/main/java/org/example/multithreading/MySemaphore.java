package org.example.multithreading;

import java.util.concurrent.Semaphore;

public class MySemaphore {
    private static class Resource {
        Semaphore semaphore = new Semaphore(2, true);

        public void useResource(String name) throws InterruptedException {
            try {
                semaphore.acquire();
                System.out.println("Ресурс " + name + " исполняется в потоке: " + Thread.currentThread().getName());
            } finally {
                System.out.println("Ресурс " + name + " освобожден в потоке: " + Thread.currentThread().getName());
                semaphore.release();
            }
        }
    }

    private static class MyThread extends Thread {
        private final Resource resource;
        private final String name;

        public MyThread(Resource resource, String name) {
            this.resource = resource;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                resource.useResource(name);
            } catch (InterruptedException e) {
                System.out.println("Поток " + name + " был прерван.");
            }

        }
    }

    /**
     * Механизмы Semaphore сами по себе не предназначены для того, чтобы задавать жесткий порядок выполнения потоков,
     * соответствующий порядку их объявления или запуска в коде.
     * Semaphore служит для контроля количества потоков, имеющих одновременный доступ к ресурсу,
     * и (в случае справедливого семафора) для предотвращения "голодания" потоков.
     * --- Что можно сделать, если нужен строгий порядок? ---
     * Можно запускать потоки последовательно и использовать метод join()
     * для ожидания завершения каждого потока перед запуском следующего.
     * Но, это превратит многопоточное выполнение в последовательное,
     * что может свести на нет все преимущества многопоточности.
     */
    public static void main(String[] args) {
        Resource resource = new Resource();

        MyThread thread1 = new MyThread(resource, "Поток 1");
        MyThread thread2 = new MyThread(resource, "Поток 2");
        MyThread thread3 = new MyThread(resource, "Поток 3");
        MyThread thread4 = new MyThread(resource, "Поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
