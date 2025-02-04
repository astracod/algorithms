package org.example.algorithms;

import java.util.Arrays;

public class Alg_FirstMissingPositive_41 {

    // лучшее решение с манипуляцие знаками и индексами
    public static int firstMissingPositiveSolution(int[] nums) {
        int noOfOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                noOfOnes++; // Считаем количество единиц
            } else if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1; // Заменяем все отрицательные числа и числа, которые больше длины массива, на 1
            }
        }

        if (noOfOnes == 0) {
            return 1; // если нет ни одной единицы, то пропущенное число точно 1
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Индекс, соответствующий значению числа
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Отмечаем число как посещенное, делая его отрицательным
            }
        }

        // После того как мы прошли по массиву и пометили все числа, которые встречаются,
        // мы проходим еще раз по массиву и ищем первое место, где число положительное.
        // Это будет означать, что это число не встречалось в массиве,
        // и оно является первым пропущенным положительным числом.
        // результат после прошлого шага [-3, 4, -1, -1]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1; // Если мы нашли положительное число, это и есть первый пропущенный элемент
            }
        }

        // Otherwise,return arr length+1
        return nums.length + 1; // Если не найдено отсутствующее число, значит, это число будет nums.length + 1
    }

    public static int firstMissingPositive(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else i++;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        int[] nums1 = new int[]{-1, 4, 2, 1, 9, 10};
        System.out.println(firstMissingPositiveSolution(nums));
    }
}
