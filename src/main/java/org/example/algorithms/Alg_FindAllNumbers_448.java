package org.example.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Alg_FindAllNumbers_448 {

    /**
     *  Поиск отсутствующих чисел заключается в том, что бы получая значения,
     *  использовать их как индексы, изменяя значение на отрицательное.
     *  Вторым проходом записать все индексы у которых значения больше нуля.
     *  По условию задачи длина массива соответствует самому большому числу в нем.
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) resultList.add(i + 1);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums1 = new int[]{1, 1};
        findDisappearedNumbers(nums1);
    }
}
