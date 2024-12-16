package org.example.algorithms;

public class FindConcatenationArrayValue_2562 {

    /**
     * 3 ms Beats 87.30%
     */
    public static long findTheArrayConcVal(int[] nums) {
        long answer = 0L;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            sb.append(nums[i]);
            sb.append(nums[j]);
            answer = answer+Long.parseLong(sb.toString());
            sb.setLength(0);
        }
        if (nums.length%2 != 0) answer = answer+nums[nums.length/2];
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 52, 2, 4};
        int[] nums2 = new int[]{5,14,13,8,12};
        System.out.println(findTheArrayConcVal(nums));
    }
}
