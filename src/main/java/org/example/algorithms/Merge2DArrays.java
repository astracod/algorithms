package org.example.algorithms;

import java.util.*;

public class Merge2DArrays {

    /**
     *  результат 6 милисекунд
     */
    public static int[][] longArraysMerge(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] ints : nums1) {
            map.put(ints[0], ints[1]);
        }
        for (int[] ints : nums2) {
            map.merge(ints[0], ints[1], Integer::sum);
        }

        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        int[][] resultArray = new int[sortedKeys.size()][2];
        for (int i = 0; i < sortedKeys.size(); i++) {
            int key = sortedKeys.get(i);
            resultArray[i][0] = key;
            resultArray[i][1] = map.get(key);
        }
        return resultArray;
    }

    /**
     * результат 2 милисекунды
     */
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] unionArray = new int[nums1.length + nums2.length][];

        System.arraycopy(nums1, 0, unionArray, 0, nums1.length);

        System.arraycopy(nums2, 0, unionArray, nums1.length, nums2.length);

        int[][] countingArray = new int[1001][];

        int lengthResArray = 0;
        for (int[] ints : unionArray) {
            int index = ints[0];
            int value = ints[1];
            if (countingArray[index] == null){
                countingArray[index] = ints;
                lengthResArray++;
            }
            else {
                 countingArray[index][1] = countingArray[index][1]+value;
            }
        }

        int[][] resultArray = new int[lengthResArray][];
        int j = 0;
        for (int[] ints : countingArray) {
            if (ints != null){
                resultArray[j] = ints;
                j++;
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] nums1 = new int[][]{{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] res = mergeArrays(nums1, nums2);
        System.out.println(Arrays.deepToString(res));
    }
}
