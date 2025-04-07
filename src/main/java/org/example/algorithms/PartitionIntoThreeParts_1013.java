package org.example.algorithms;

public class PartitionIntoThreeParts_1013 {
    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        int zero = 0;
        for (int i : arr) {
            if (i == 0) zero++;
            sum += i;
        }
        if (zero == arr.length) return true;
        if (sum % 3 != 0) return false;
        int targetSum = sum / 3;
        int countPart = 0;
        int currentSum = 0;
        for (int j : arr) {
            currentSum += j;
            if (currentSum == targetSum) {
                countPart++;
                currentSum = 0;
            }
        }
        return countPart >= 3;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int[] arr1 = new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        int[] arr2 = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        int[] arr3 = new int[]{1,-1,1,-1};
        int[] arr4 = new int[]{10,-10,10,-10,10,-10,10,-10};
        System.out.println(canThreePartsEqualSum(arr4));
    }
}
