package org.example.algorithms;

public class SearchInsertPosition_35 {

    public static int searchRec(int[] nums, int target, int start, int end, int indexIfNotExist) {
        if (start > end) return indexIfNotExist;
        int q = start + (end - start) / 2;
        int res = nums[q];
        if (res == target) return q;
        if (res > target) return searchRec(nums, target, start, end - 1, q);
        else return searchRec(nums, target, start + 1, end, q + 1);

    }

    public static int searchInsert(int[] nums, int target) {
        return searchRec(nums, target, 0, nums.length - 1, 0);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        int target1 = 2;
        int target2 = 7;
        System.out.println(searchInsert(nums, target2));
    }
}
