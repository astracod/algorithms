package org.example.algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MoveZeroes_283 {
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int lastIndex = 0;
        for (int left = 0, right = 0; left < nums.length && right < nums.length; right++) {

            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            if (right < nums.length) {
                nums[left] = nums[right];
                left++;
            }
            lastIndex = left;
        }
        while (lastIndex < nums.length) {
            nums[lastIndex++] = 0;
        }

    }

    /**
     * Third Maximum Number № 414
     * мое решение 5 ms 34,25%
     */
    public static int thirdMaxMyMethod(int[] nums) {
        Arrays.sort(nums);
        long temp = Long.MIN_VALUE, count = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != temp) {
                if (count == 3) return nums[i];
                count++;
            }
            System.out.println(nums[i] + " " + temp + " " + count);
            temp = nums[i];
        }
        return nums[nums.length - 1];
    }

    /**
     * лучшее решение 0 ms. Обратить внимание на переинициляцию переменных в условиях цикла
     */
    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && first != num) {
                third = second;
                second = num;
            } else if (num > third && second != num && first != num) {
                third = num;
            }
        }
        if (nums.length <= 2 || third == Long.MIN_VALUE) return (int) first;

        return (int) third;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{2, 2, 3, 1};
        int[] nums3 = new int[]{-3, -2, -1, 0};
        System.out.println(thirdMax(nums3));
    }
}
