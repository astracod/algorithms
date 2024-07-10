package org.example.my_queue;

public class QueueTask {
    private int[] a;
    private int head, tail;

    public QueueTask(int n) {
        a = new int[n + 1];    //для пользователя размер равен n=10
        head = 0;
        tail = 0;
    }

    public void offer(int x) {
        if (isFull()) {
            System.out.println("Queue overflow");
            return;
        }
        a[tail] = x;
        if (tail == a.length - 1)
            tail = 0;
        else{
            tail++;
        }

    }

    public boolean isFull() {
        return ((head == 0 && tail == a.length - 1) || (tail == head - 1));
    }

    public void poll() {
        if (isEmpty())
            System.out.println("Queue underflow");
        else if (head == a.length - 1) {
            System.out.println(a[head]);
            head = 0;
        } else {
            System.out.println(a[head]);
            head++;
        }
    }

    public void peek() {
        if (this.isEmpty()) System.out.println("Queue is clear");
        else System.out.println(a[head]);
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void clear() {
        a = new int[2];
        head = 0;
        tail = 0;
    }
}

class Solution {
    public static void main(String[] args) {
        QueueTask queueTask = new QueueTask(5);
        queueTask.offer(1);
        queueTask.offer(2);
        queueTask.offer(3);
        queueTask.clear();
        queueTask.offer(4);
        queueTask.peek();
        queueTask.poll();
        System.out.println(queueTask.isEmpty());
    }


}
