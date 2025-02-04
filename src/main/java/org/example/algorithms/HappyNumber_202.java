package org.example.algorithms;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    public static int rec(int n) {
        if (n > 0) {
            int sum = (int) Math.pow(n % 10, 2);
            return sum + rec(n / 10);
        }
        return 0;
    }

    public static boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        int result = n;
        while (result != 1 ) {
            result = rec(result);
            System.out.println(result);
            if (set.contains(result)) return false;
            else set.add(result);
        }
        return true;
    }

    /**
     * итеративный подход в замен более медленной рекурсии
     */
    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    /**
     1 Метод использует технику "черепахи и зайца" (также известную как алгоритм Флойда для обнаружения цикла).
     2 Мы создаем две переменные: slow и fast, обе начинаются с числа n.
     3 В цикле:
        - slow двигается на один шаг (применяем sumOfSquares один раз)
        - fast двигается на два шага (применяем sumOfSquares дважды)
     4 Если число счастливое, то fast достигнет 1 быстрее, чем slow.
     5 Если число несчастливое, то fast и slow встретятся в какой-то точке цикла.
     6 Цикл продолжается, пока slow и fast не станут равны.
     7 После выхода из цикла, если slow (или fast, они равны) равно 1, число счастливое. Иначе - несчастливое.
     */
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);
        return slow == 1;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
