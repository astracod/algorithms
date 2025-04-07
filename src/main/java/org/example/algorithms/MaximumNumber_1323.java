package org.example.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumber_1323 {
    public static int maximum69Number(int num) {
        List<Integer> arr = new ArrayList<>();
        int res = 0;
        boolean flag = false;
        while (num > 0) {
            arr.add(num % 10);
            num = num / 10;
        }
        int factor = (int) Math.pow(10, arr.size() - 1);
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) == 6 && !flag) {
                arr.set(i, 9);
                flag = true;
            }
            res += arr.get(i) * factor;
            factor = factor / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 9669;
        int num1 = 9996;
        int num2 = 696;
        System.out.println(maximum69Number(num2));
    }
}
