package org.example.my_array;

public class ArrayTasks {

    /**
     * Дан массив целых чисел. Вычислить минимальный элемент (и его позицию),
     * максимальный элемент и поменять их местами в массиве
     */
    public int[] findMaxAndMin(int[] a) {
        int min = a[0];
        int minPOS = 0;
        int max = a[0];
        int maxPos = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                minPOS = i;
            } else {
                max = a[i];
                maxPos = i;
            }
        }
        a[minPOS] = max;
        a[maxPos] = min;
        return a;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = (matrix.length * matrix[0].length) - 1;
        return matrixRec(matrix, target, 0, r);
    }

    private boolean matrixRec(int[][] matrix, int target, int p, int r) {
        int q = p + (r - p) / 2;
        int i = q / matrix[0].length;
        int j = q % matrix[0].length;
        if (p > r) return false;
        if (target == matrix[i][j]) return true;
        else if (target < matrix[i][j]) return matrixRec(matrix, target, p, q - 1);
        else return matrixRec(matrix, target, q + 1, r);
    }

    public int search(int[] nums, int target) {
        int p = 0, r = nums.length - 1, q;
        while (p <= r) {
            q = p + (r - p) / 2;
            if (target == nums[q])
                return q;
            if (nums[p] > nums[q]) {
                if (target < nums[q] || target > nums[q] && target >= nums[p])
                    r = q - 1;
                else
                    p = q + 1;
            } else if (target > nums[q] || target < nums[q] && target < nums[p])
                p = q + 1;
            else
                r = q - 1;
        }
        return -1;
    }

    public boolean search_2(int[] nums, int target) {
        if (nums.length == 0) return true;
        if (nums.length == 1) return nums[0] == target;
        int p = 0, r = nums.length - 1, q;
        while (p <= r) {
            q = p + (r - p) / 2;
            if (target == nums[q]) return true;
            if (nums[q] == nums[p] && nums[q] == nums[r]) {
                p++;
                r--;
            } else if (nums[p] > nums[q]) {
                if (target < nums[q] || target > nums[q] && target >= nums[p]) r = q - 1;
                else p = q + 1;
            } else if (target > nums[q] || target < nums[q] && target < nums[p]) p = q + 1;
            else r = q - 1;

        }
        return false;
    }

    public int findMin(int[] nums) {
        int p = 0, r = nums.length - 1, min = nums[0], q;
        while (p <= r) {
            q = p + (r - p) / 2;

            if (nums[p] > nums[r] && nums[q] > nums[r]) {
                min = nums[r];
                p = q + 1;
            }
            if ((nums[p] > nums[r] && nums[q] < nums[r]) || (nums[p] < nums[r] && nums[q] < nums[r])) {
                if (min > nums[q]) min = nums[q];
                if (r > 0 && q > 0) r = q - 1;
            }
            if (nums[r] < nums[q] && min > nums[r]) min = nums[r];
            if (nums[p] == nums[r] && nums[q] > nums[p]) if (min > nums[p]) min = nums[p];
            if (min == nums[q]) return nums[q];
        }
        return min;
    }

    public int searchToArray(int[] nums, int target) {
        int answer = 0;
        if (nums.length == 0) answer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return answer = i;
            else answer = -1;
        }
        return answer;
    }

}

class Solutions {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int[] nums1 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = new int[]{11, 13, 15, 17};
        int[] nums3 = new int[]{2, 1};
        int[] nums4 = new int[]{1, 2};
        int[] nums5 = new int[]{1, 2, 3, 4, 5};
        int[] nums6 = new int[]{5, 1, 2, 3, 4};
//        int[] nums3 = new int[]{2, 5, 6, 0, 0, 1, 2};
//        int[] nums4 = new int[]{1, 0, 1, 1, 1};
//        int[] nums5 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[][] c = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        ArrayTasks tasks = new ArrayTasks();
        System.out.println(tasks.findMin(nums6));
//        int[] b = tasks.findMaxAndMin(a);
//
//        System.out.println(Arrays.stream(b)
//                .mapToObj(String::valueOf)
//                .collect(Collectors.joining(", "))
//        );

//        System.out.println(tasks.searchMatrix(c, 16));
//        System.out.println(tasks.searchToArray(nums, 3));
//        System.out.println(tasks.findMin(nums1));
//        System.out.println("Before P " + p + " Q " + q + " r " + r);
//        System.out.println("Before val P " + nums[p] + " Q " + nums[q] + " r " + nums[r]+" min "+ min);
    }
}
