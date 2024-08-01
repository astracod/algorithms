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
        else {
            tail++;
        }

    }

    public boolean isFull() {
        return ((head == 0 && tail == a.length - 1) || (tail == head - 1));
    }

    public Integer poll() {
        Integer answer;
        if (isEmpty())
            return null;
        else if (head == a.length - 1) {
            answer = a[head];
            head = 0;
        } else {
            answer = a[head];
            head++;
        }
        return answer;
    }

    public int peek() {
        if (this.isEmpty()) return -1;
        else return a[head];
    }

    public void clear() {
        a = new int[2];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public QueueTask drunkard(QueueTask first, QueueTask second) {
        int counter = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            if (first.peek() < second.peek()) {
                if (second.peek() == 0 && first.peek() > 0) {
                    second.offer(first.poll());
                    counter++;
                }
                second.offer(first.poll());
                counter++;
            } else {
                if (first.peek() == 0 && second.peek() > 0) {
                    first.offer(second.poll());
                    counter++;
                }
                first.offer(second.poll());
                counter++;
            }
        }
        System.out.println("counter " + counter);
        if (first.isFull()) return first;
        else return second;
    }

}

class Solution {
    public static void main(String[] args) {
        QueueTask first = new QueueTask(10);
        QueueTask second = new QueueTask(10);
        first.offer(1);
        first.offer(3);
        first.offer(5);
        first.offer(7);
        first.offer(9);
        second.offer(2);
        second.offer(4);
        second.offer(6);
        second.offer(8);
        second.offer(0);

        QueueTask answer = first.drunkard(first, second);

        while (!answer.isEmpty()) {
            System.out.println("result : " + first.poll());
        }

    }


}
