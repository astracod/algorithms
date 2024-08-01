package org.example.my_array;

import java.util.*;

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

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        List<int[]> listOfArrays = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int first = intervals[0][0];
        int second = intervals[0][1];
        for (int i = 0; i <= intervals.length - 1; i++) {
            if (second < intervals[i][0]) {
                listOfArrays.add(new int[]{first, second});
                first = intervals[i][0];
                second = intervals[i][1];
            }
            if (second >= intervals[i][0] && second < intervals[i][1]) second = intervals[i][1];

            if (i == intervals.length - 1) listOfArrays.add(new int[]{first, second});

        }
        int[][] answer = new int[listOfArrays.size()][];
        for (int i = 0; i < listOfArrays.size(); i++) {
            answer[i] = listOfArrays.get(i);
        }
        return answer;
    }

    public int[] myCountingSort(int[] a) {
        int min = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) min = a[i];
            if (max < a[i]) max = a[i];
        }
        int[] c = new int[(max - min) + 1];
        int[] b = new int[a.length];
        for (int k = 0; k < c.length; k++) {
            c[k] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            c[a[i] - min]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];

        }
        for (int i = a.length - 1; i >= 0; i--) {
            c[a[i] - min]--;
            b[c[a[i] - min]] = a[i];
        }
        return b;
    }

    public int heightChecker(int[] heights) {
        int[] sort = myCountingSort(heights);
        int difference = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sort[i]) difference++;
        }
        return difference;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        LinkedHashMap<Integer, Integer> amount = new LinkedHashMap<>();
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            amount.put(arr2[i], 0);
        }
        for (int elem : arr1) {
            if (amount.containsKey(elem)) amount.put(elem, amount.get(elem) + 1);
            else amount.put(elem, 1);
        }

        int index = 0;
        for (int num : arr2) {
            int count = amount.get(num);
            for (int i = 0; i < count; i++) {
                res[index++] = num;
            }
            amount.remove(num);
        }

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(amount);
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                res[index++] = num;
            }
        }
        return res;
    }

    /**
     * повторяет метод int[] myCountingSort(int[] a), третий выше.
     *
     * @param nums
     * @return
     */
    public int[] sort2(int[] nums) {
        int min = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) min = nums[i];
            if (max < nums[i]) max = nums[i];
        }
        int[] c = new int[(max - min) + 1];
        int[] b = new int[nums.length];

        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            c[nums[i] - min]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            c[nums[i] - min]--;
            b[c[nums[i] - min]] = nums[i];
        }
        return b;
    }

    public void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    /**
     * LeetCode 561. Array Partition
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        int[] sortArr = sort2(nums);
        int sum = 0;
        for (int i = 0; i < sortArr.length; ) {
            sum += sortArr[i];
            i = i + 2;
        }
        return sum;
    }

    public int[] numberGame(int[] nums) {
        ArrayDeque<Integer> alice = new ArrayDeque<>();
        ArrayDeque<Integer> bob = new ArrayDeque<>();
        int[] result = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) alice.addFirst(nums[i]);
            else bob.addFirst(nums[i]);
        }
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) result[i] = bob.removeLast();
            else result[i] = alice.removeLast();
            ;
        }
        return result;
    }

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public int deleteGreatestValue(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
        List<PriorityQueue<Integer>> buf = new ArrayList<>();
        for (int[] arr : grid) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            for (int number : arr) {
                queue.offer(number);
            }
            buf.add(queue);
        }
        int maxSum = 0;
        boolean queuesNotEmpty = true;
        while (queuesNotEmpty) {
            queuesNotEmpty = false;
            Integer maxElement = null;
            for (PriorityQueue<Integer> queue : buf) {
                if (!queue.isEmpty()) {
                    int element = queue.poll();
                    if (maxElement == null || element > maxElement) maxElement = element;
                    queuesNotEmpty = true;
                }
            }
            if (maxElement != null) maxSum += maxElement;
        }
        return maxSum;
    }

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff = new int[100_001];
        long total = 0;
        int currentValue;
        int maxIndex = 0;
        long result = 0;
        long bonus = k1 + k2;

        for (int i = 0; i < nums1.length; i++) {
            currentValue = Math.abs(nums1[i] - nums2[i]);
            if (currentValue > 0) {
                diff[currentValue]++;
                total += currentValue;
                maxIndex = Math.max(maxIndex, currentValue);
            }
        }

        if (total <= bonus) return 0;

        for (int i = maxIndex; i > 0 && bonus > 0; i--) {
            if (diff[i] > 0) {
                if (diff[i] > bonus) {
                    diff[i] -= bonus;
                    diff[i - 1] += bonus;
                    bonus = 0;
                } else {
                    diff[i - 1] += diff[i];
                    bonus -= diff[i];
                    diff[i] = 0;
                }
            }
        }

        for (int i = 0; i <= maxIndex; i++) {
            if (diff[i] > 0) {
                result += (long) (Math.pow((long) i, 2)) * diff[i];
            }
        }
        return result;
    }

    private int partition(int[] a, int p, int r) {
        int buf, i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] < a[r]) {
                i++;
                buf = a[j];
                a[j] = a[i];
                a[i] = buf;
            }
        }
        buf = a[i + 1];
        a[i + 1] = a[r];
        a[r] = buf;
        return (i + 1);
    }

    private void recQuickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            recQuickSort(a, p, q - 1);
            recQuickSort(a, q + 1, r);
        }
    }

    public void myQuickSort(int[] arr) {
        recQuickSort(arr, 0, arr.length - 1);
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<Integer, List<String>> integerSortMap = new TreeMap<>(Collections.reverseOrder());

        List<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();

        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            List<String> list1 = integerSortMap.get(entry.getValue());
            if (list1 != null) list1.add(entry.getKey());
            else {
                list1 = new ArrayList<>();
                list1.add(entry.getKey());
                integerSortMap.put(entry.getValue(), list1);
            }
        }
        for (Map.Entry<Integer, List<String>> integerListEntry : integerSortMap.entrySet()) {
            List<String> values = integerListEntry.getValue();
            Collections.sort(values);
            list.addAll(values);
        }
        for (int i = 0; i < list.size() && k > 0; i++) {
            res.add(list.get(i));
            k--;
        }

        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1 && k == 1) return new int[]{nums[0]};

        Map<Integer, Integer> countingMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countingMap.merge(nums[i], 1, Integer::sum);
        }

        if (nums.length == countingMap.size()) return nums;

        List<Integer> resultList = new ArrayList<>();

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : countingMap.entrySet()) {
            Integer key = entry.getValue();
            Integer value = entry.getKey();
            treeMap.computeIfAbsent(key, k1 -> new ArrayList<>()).add(value);
        }

        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            resultList.addAll(entry.getValue());
        }

        return resultList.stream()
                .limit(k)
                .mapToInt(i -> i)
                .toArray();
    }

    public class KNode {
        public String word;
        public int amount;

        public KNode(String word, int amount) {
            this.word = word;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return word + " : " + amount;
        }
    }

    public List<String> topKFrequentStringWithQueue(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (entry1, entry2) -> {
                    int valueResult = Integer.compare(entry2.getValue(), entry1.getValue());
                    if (valueResult != 0) {
                        return valueResult;
                    } else {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                }
        );
        queue.addAll(map.entrySet());
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            if (k > 0) {
                list.add(entry.getKey());
                k--;
            }
        }
        return list;
    }

    public int[] topKFrequentIntegerWithQueue(int[] nums, int k) {
        if (nums.length == 1 && k == 1) return new int[]{nums[0]};

        Map<Integer, Integer> countingMap = new HashMap<>();
        for (int num : nums) {
            countingMap.merge(num, 1, Integer::sum);
        }

        if (nums.length == countingMap.size()) return nums;

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()));

        queue.addAll(countingMap.entrySet());
        int[] resultArr = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            if (k > 0) {
                resultArr[i] = entry.getKey();
                i++;
                k--;
            }
        }
        return resultArr;
    }
}


class Solutions {
    public static void main(String[] args) {

        ArrayTasks tasks = new ArrayTasks();
//        int[] nums1 = new int[]{1, 4, 10, 12}; // 10, 5 | 1,1
//        int[] nums2 = new int[]{5, 8, 6, 9};
//        int[] nums1 = new int[]{1,2,3,4};
//        int[] nums2 = new int[]{2,10,20,19};
//        int[] nums1 = new int[]{7,11,4,19,11,5,6,1,8};
//        int[] nums2 = new int[]{4,7,6,16,12,9,10,2,10};
//        int[] nums1 = new int[]{18, 4, 8, 19, 13, 8};
//        int[] nums2 = new int[]{18, 11, 8, 2, 13, 15};
//        System.out.println(tasks.minSumSquareDiff(nums1, nums2, 1, 1));

//        int[] arr = new int[]{100, 5, 0, -2, 7, -5};
//        tasks.myQuickSort(arr);
//        System.out.println(Arrays.toString(arr));
        String[] strings = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
//        List<String> strings1 = tasks.topKFrequentStringWithQueue(strings, 2);
//        System.out.println(strings1);
        int[] inside = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(tasks.topKFrequentIntegerWithQueue(inside, 2)));

    }
}
