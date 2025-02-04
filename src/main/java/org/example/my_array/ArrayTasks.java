package org.example.my_array;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        for (int k : a) {
            if (min > k) min = k;
            if (max < k) max = k;
        }
        int[] c = new int[(max - min) + 1];
        int[] b = new int[a.length];

        for (int j : a) {
            c[j - min]++;
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
        for (int num : nums) {
            if (min > num) min = num;
            if (max < num) max = num;
        }
        int[] c = new int[(max - min) + 1];
        int[] b = new int[nums.length];

        for (int num : nums) {
            c[num - min]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        int i = 0;
        while (i < nums.length) {
            c[nums[i] - min]--;
            b[c[nums[i] - min]] = nums[i];
            i++;
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

    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, map.get(s.charAt(i)));
            if (i == right) {
                answer.add(right - left + 1);
                left = right + 1;
            }
        }

        return answer;
    }

    public int countPairs(List<Integer> nums, int target) {
        List<List<Integer>> listOfPair = new ArrayList<>();
        for (int first = 0; first < nums.size() - 1; first++) {
            for (int last = first + 1; last < nums.size(); last++) {
                if (nums.get(first) + nums.get(last) < target)
                    listOfPair.add(List.of(nums.get(first), nums.get(last)));
            }
        }
        return listOfPair.size();
    }

    public String reversePrefix(String word, char ch) {
        char[] charArr = word.toCharArray();
        int right = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ch) {
                right = i;
                break;
            }
        }
        char buf;
        for (int left = 0; left < right; left++, right--) {
            buf = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = buf;
        }
        return String.valueOf(charArr);
    }

    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int first = 0; first < nums.length; first++) {
            for (int last = first; last < nums.length; last++) {
                int dif = Math.abs(nums[first] - nums[last]);
                int min = Math.min(nums[first], nums[last]);
                if (dif <= min) {
                    if ((nums[first] ^ nums[last]) > max) max = nums[first] ^ nums[last];
                }
            }
        }
        return max;
    }

    public int countKConstraintSubstrings(String s, int k) {
        int max = 0, one = 0, two = 0;
        for (int first = 0; first < s.length(); first++) {
            for (int last = first; last < s.length(); last++) {
                if (s.charAt(last) == '0') one++;
                else two++;
                if ((one <= k || two <= k)) {
                    max++;
                }
            }
            one = 0;
            two = 0;
        }
        return max;
    }

    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int a = 0, b = 1, c = 2; c < s.toCharArray().length; a++, b++, c++) {
            if (s.charAt(a) != s.charAt(b) && s.charAt(b) != s.charAt(c) && s.charAt(a) != s.charAt(c)) count++;
        }
        return count;
    }

    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int zeroPoint = colors[0];
        int firstpoint = colors[1];
        int[] newArr = new int[colors.length + 2];
        for (int i = 0; i < colors.length; i++) {
            newArr[i] = colors[i];
        }
        newArr[colors.length] = zeroPoint;
        newArr[colors.length + 1] = firstpoint;
        for (int a = 0, b = 1, c = 2; c < newArr.length; a++, b++, c++) {
            if (newArr[a] != newArr[b] && newArr[b] != newArr[c]) count++;
        }
        return count;
    }

    public int findCenter(int[][] edges) {
        int center = 0;
        int i2 = 1;
        for (int i = 0; i < edges[0].length; i++) {
            for (int i1 = 0; i1 < edges[i2].length; i1++) {
                if (edges[0][i] == edges[i2][i1]) {
                    center = edges[i2][i1];
                    if (i2 + 1 <= edges.length - 1) i2++;
                }
            }
        }
        return center;
    }

    public int minSwaps(int[] nums) {
        int lengthWindow = Arrays.stream(nums).sum();// считаем количество 1 в массиве
        int amountOne = 0; // переменная для подсчета единиц в скользящем окне

        for (int i = 0; i < lengthWindow; i++) {
            amountOne += nums[i]; // подсчет количества 1 в первом скользящем окне
        }
        int maxSwap = amountOne; // инициализация количества 1 в каждом скользящем последущем окне

        for (int i = 0; i < nums.length; i++) {
            if (nums[(lengthWindow + i) % nums.length] == 1)
                amountOne++; // прибавляем в новом правом индексе если значение 1
            if (nums[i] == 1) amountOne--; // удаляем из левого индекса скользящего окна если значение == 1
            maxSwap = Math.max(maxSwap, amountOne); // обновляем состояние переменной единиц в скользящем окне
        }
        return lengthWindow - maxSwap; // вычитаем из длины скользящего окна максимальное количество единиц
    }

    boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        int middle = (end - start) / 2;
        while (start < middle) {
            if (s.charAt(start) != s.charAt(end)) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int amountPivot = 0;
        List<Integer> after = new LinkedList<>();
        int[] result = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num == pivot) amountPivot++;
            if (num < pivot) result[i++] = num;
            if (num > pivot) after.add(num);
        }

        for (int i1 = 0; i1 < amountPivot; i1++) {
            result[i++] = pivot;
        }

        for (Integer integer : after) {
            result[i++] = integer;
        }
        return result;
    }

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double minResult = 1000000000000F;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            double min = ((double) nums[i] + nums[j]) / 2;
            if (minResult > min) minResult = min;
        }
        return minResult;
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int amountTriplets = 0;
        HashSet<Integer> allNumbers = new HashSet<>();
        for (int num : nums) {
            allNumbers.add(num);
        }
        for (int i = 0, j = i + 1; j < nums.length; ) {
            int d = nums[j] - nums[i];
            if (d == diff) {
                int searchValue = nums[j] + d;
                boolean res = allNumbers.contains(searchValue);
                if (res) amountTriplets++;
            }
            if (d < diff) j++;
            else i++;
        }
        return amountTriplets;
    }

    public String firstPalindrome(String[] words) {
        boolean isPalindrome = true;
        for (String word : words) {
            if (word.length() == 1) return word;
            for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
                if (word.charAt(i) != word.charAt(j)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) return word;
            isPalindrome = true;
        }
        return "";
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for (String s1 : arr) {
            char[] a = s1.toCharArray();
            for (int i = 0, j = a.length - 1; i < a.length / 2; i++, j--) {
                char buf = a[i];
                a[i] = a[j];
                a[j] = buf;
            }
            answer.append(a);
            if (s.length() > answer.length()) answer.append(" ");
        }
        return answer.toString();
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int[][] answer = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
            for (int i1 = image[i].length - 1, j = 0; i1 >= 0; i1--, j++) {
                if (image[i][i1] == 0) answer[i][j] = 1;
                else answer[i][j] = 0;
            }
        }
        return answer;
    }

    public int[] decrypt(int[] code, int k) {
        int[] answer = new int[code.length];
        int[] workArr = new int[0];
        if (k == 0) return answer;
        if (k > 0) {
            workArr = new int[code.length + Math.abs(k - 1)];
            System.arraycopy(code, 1, workArr, 0, code.length - 1);
            System.arraycopy(code, 0, workArr, code.length - 1, k);
        }
        if (k < 0) {
            workArr = new int[code.length + Math.abs(k)];
            System.arraycopy(code, code.length - (Math.abs(k)), workArr, 0, Math.abs(k));
            System.arraycopy(code, 0, workArr, Math.abs(k), code.length);
        }
        int sumOfWindow = 0;
        int index = 0;
        for (int i = 0; i < workArr.length - (Math.abs(k) - 1); i++, index++) {
            for (int j = i; j < (Math.abs(k) + i) && j < workArr.length; j++) {
                sumOfWindow += workArr[j];
            }
            if (index < code.length) answer[index] = sumOfWindow;
            sumOfWindow = 0;
        }
        return answer;
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int res = (Math.min(height[left], height[right]) * (right - left));
            max = Math.max(max, res);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        int maxInCount = 0, maxWindow = 0, lenWindow, count;
        int[] c = new int[26];//  длина размером латинского алфавита
        for (int first = 0, last = 0; last < s.length(); last++) {
            c[s.charAt(last) - 'A']++;
            count = c[s.charAt(last) - 'A'];
            maxInCount = Math.max(maxInCount, count);
            lenWindow = last - first + 1;

            if ((lenWindow - maxInCount) > k) {
                c[s.charAt(first) - 'A']--;
                first++;
            }

            maxWindow = Math.max(maxWindow, last - first + 1);
        }
        return maxWindow;
    }

    public int maximumLengthSubstring(String s) {
        int[] c = new int[26];
        int max = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            c[s.charAt(right) - 'a']++;
            while (c[s.charAt(right) - 'a'] > 2) {
                c[s.charAt(left) - 'a']--;
                left++;
            }
            max = Math.max(max, (right - left + 1));
        }
        return max;
    }

    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        if (trust.length == 0) return -1;

        int judge = -1, foundKey = 0, maxValue = 0;
        Set<Integer> first = new HashSet<>();
        Map<Integer, Integer> second = new HashMap<>();

        for (int[] ints : trust) {
            first.add(ints[0]);
            for (int i1 = 1; i1 < ints.length; i1++) {
                second.merge(ints[i1], 1, Integer::sum);
            }
        }

        if (first.size() == n) return -1;

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                foundKey = entry.getKey();
            }
        }

        boolean res = first.contains(foundKey);
        if (!res && first.size() == n - 1) judge = foundKey;
        return judge;
    }

    static class Pair implements Comparable<Pair> {
        int val;
        int ids;

        public Pair(int val, int ids) {
            this.val = val;
            this.ids = ids;
        }

        @Override
        public int compareTo(Pair pair) {
            return pair.val - this.val;
        }
    }

    /**
     * используем класс Pair с реализованным компоратором, где сортируется по убыванию.
     * получаем первый элемент после прохождения в первом цикле и кладем его в очередь
     * создаем основной цикл, который начинается с K и идет до конца. While используется что бы проходя циклом по очереди
     * удалить первый элемент (i-k).
     * Дальше добавляется новый элемент и происходит моментальная сортировка в очереди благодаря методу
     * compareTo(Pair pair) в классе Pair, так как очередь элементов класса Pair
     * и следующим шагом добавляется в результирующий массив.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(new Pair(nums[i], i));
        }
        res[0] = queue.peek().val;
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek().ids <= i - k) {
                queue.remove();
            }
            queue.add(new Pair(nums[i], i));
            res[i - k + 1] = queue.peek().val;
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int resIndex = 0, dif = k - 1;
        int[] res = new int[nums.length - dif];
        for (int i = 0; i < nums.length - dif; i++) {
            int max = nums[i];
            for (int j = i + 1; j < k + i; j++) {
                if (nums[j] > max) max = nums[j];
            }
            res[resIndex] = max;
            resIndex++;
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int[] b = new int[prices.length];
        b[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            b[i] = Math.max(b[i - 1], prices[i] - min);
            if (prices[i] < min)
                min = prices[i];
        }
        return b[b.length - 1];
    }

    public int maxProfit(int[] prices) {
        int[] b = new int[prices.length];
        b[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            b[i] = Math.max(b[i - 1], b[i - 1] + prices[i] - prices[i - 1]);
        }
        return b[b.length - 1];
    }

    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }

    public int climbStairs(int n) {
        int[] res = new int[n + 2];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[res.length - 1];
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> resOne = new ArrayList<>();
            List<Integer> one = new ArrayList<>();
            one.add(1);
            resOne.add(one);
            return resOne;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        b.add(1);
        b.add(1);
        res.add(a);
        res.add(b);
        for (int i = 1; i < numRows - 1; i++) {
            List<Integer> step = new ArrayList<>();
            step.add(1);
            for (int i1 = 1; i1 < res.get(i).size(); i1++) {
                step.add(res.get(i).get(i1) + res.get(i).get(i1 - 1));
            }
            step.add(1);
            res.add(step);
        }
        return res;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (s.length() > t.length() || s.length() == 0) return false;
        int lastIndex = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            List<Integer> ids = map.get(t.charAt(i));
            if (ids != null) {
                ids.add(i);
                map.put(t.charAt(i), ids);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                map.put(t.charAt(i), indexes);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            List<Integer> ids = map.get(s.charAt(i));
            if (ids == null || ids.size() == 0) {

                return false;
            } else {
                int currentIndex = ids.get(0);
                if (lastIndex > currentIndex && ids.size() > 1) {
                    int a = 1;
                    while (a < ids.size() && lastIndex > currentIndex) {
                        int checkIds = ids.get(a);
                        if (checkIds > lastIndex) currentIndex = checkIds;
                        a++;
                    }
                }
                if (lastIndex <= currentIndex) {
                    lastIndex = currentIndex;
                    ids.remove(0);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int fib(int n) {
        int[] res = new int[n + 1];
        if (n == 0) return res[0];
        if (n == 1) return res[1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[res.length - 1];
    }

    public int maxRepeating(String sequence, String word) {
        int k = 0;
        String repeatedWord = word; // Начинаем с одного повторения

        // Проверяем, пока повторенное слово содержится в последовательности
        while (sequence.contains(repeatedWord)) {
            k++;
            repeatedWord += word; // Увеличиваем количество повторений
        }
        return k;
    }

    public int longestPalindrome(String s) {
        int[] count = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) count[s.charAt(i) - 'a']++;
            else count[ch - 'A' + 26]++;
        }

        int max = 0;
        int sumOfEven = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 0) {
                sumOfEven += count[i];
            } else {
                sumOfEven += count[i] - 1;
                max = Math.max(max, count[i]);
            }
        }

        if (max > 0) {
            return sumOfEven + 1; // Длина палиндрома
        } else {
            return sumOfEven;
        }
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        String longest = ""; // Инициализируем переменную для хранения самой длинной палиндромной подстроки

        for (int i = 0; i < s.length(); i++) {
            // Проверяем палиндром с одним центром (для нечетной длины)
            String oddPal = expandAroundCenter(s, i, i);
            // Проверяем палиндром с двумя центрами (для четной длины)
            String evenPal = expandAroundCenter(s, i, i + 1);

            // Сравниваем длины и обновляем самую длинную палиндромную подстроку
            if (oddPal.length() > longest.length()) {
                longest = oddPal;
            }
            if (evenPal.length() > longest.length()) {
                longest = evenPal;
            }
        }

        return longest; // Возвращаем самую длинную палиндромную подстроку
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // Возвращаем палиндром
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            Character valFromMapS = mapS.get(charS);
            if (valFromMapS == null) mapS.put(charS, charT);
            else if (valFromMapS != charT) return false;

            Character valFromMapT = mapT.get(charT);
            if (valFromMapT == null) mapT.put(charT, charS);
            else if (valFromMapT != charS) return false;
        }
        return true;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            } else nums[right] = 0;
        }
        return left;
    }

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (sum < target) left++;
                else right--;
            }
        }
        return closestSum;
    }

    private Map<Character, Integer> getRomanNums() {
        Map<Character, Integer> romanNumeric = new HashMap<>();
        romanNumeric.put('I', 1);
        romanNumeric.put('V', 5);
        romanNumeric.put('X', 10);
        romanNumeric.put('L', 50);
        romanNumeric.put('C', 100);
        romanNumeric.put('D', 500);
        romanNumeric.put('M', 1000);
        return romanNumeric;
    }

    public int romanToInt(String s) {
        int total = 0;
        Map<Character, Integer> romanNumeric = getRomanNums();

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanNumeric.get(s.charAt(i));

            // Проверяем следующее значение (если оно существует)
            if (i < s.length() - 1) {
                int nextValue = romanNumeric.get(s.charAt(i + 1));
                if (currentValue < nextValue) {
                    total -= currentValue; // Вычитаем, если текущее меньше следующего
                } else {
                    total += currentValue; // Добавляем, если текущее больше или равно следующему
                }
            } else {
                total += currentValue; // Добавляем первое(V == s.length-1) значение
            }
        }
        return total;
    }

    private boolean isCompare(String first, String second) {
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) return false;
        }
        return true;
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String checkedString = haystack.substring(i, i + needle.length());
            if (isCompare(checkedString, needle)) return i;
        }
        return -1;
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.length() >= pref.length() && word.startsWith(pref)) count++;
        }
        return count;
    }

    public int minimumChairs(String s) {
        int chairs = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') chairs++;
            else chairs--;
            if (max < chairs) max = chairs;
        }
        if (chairs == s.length() && s.charAt(0) == 'E') return s.length();
        else if (chairs == -s.length() && s.charAt(0) == 'L') return 0;
        else return max;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // Список для хранения всех перестановок
        backtrack(result, new ArrayList<>(), nums); // Запуск рекурсивного метода
        return result; // Возврат всех найденных перестановок
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) { // Проверка, достигнута ли длина перестановки
            result.add(new ArrayList<>(tempList)); // Добавление текущей перестановки в результат
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue; // Пропуск уже использованных элементов
                tempList.add(num); // Добавление элемента в текущую перестановку
                backtrack(result, tempList, nums); // Рекурсивный вызов для следующего уровня
                tempList.remove(tempList.size() - 1); // Удаление последнего добавленного элемента (возврат)
            }
        }
    }

    public void nextPermutation(int[] nums) {
        int minIndex = nums.length - 1;
        int minValue = nums[nums.length - 1];
        int buf = 0;
        for (int right = nums.length - 1, left = right - 1; left >= 0; left--) {
            if (nums[left] < nums[right]) {
                while (left < right) {
                    if (nums[right] < minValue){
                        minValue = nums[right];
                        minIndex = right;
                    }
                    right--;
                }
            }
            buf = nums[left];
            nums[left] = minValue;
            nums[minIndex] = buf;
        }
    }


}

class Solutions {
    public static void main(String[] args) {
// [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        ArrayTasks tasks = new ArrayTasks();

//        int[] prices = new int[]{-1, 2, 1, -4};
//        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
//        int[] prices = new int[]{98, 54, 6, 34, 66, 63, 52, 39};
//        System.out.println(tasks.buyChoco(prices, 62));
//        System.out.println(tasks.threeSumClosest(prices, 1));
//        String s = "ELEELEELLL";
//        String b = "sad";
//        System.out.println(tasks.minimumChairs(s));
//        String word = "hello"; // Слово для преобразования
//        byte[] bytes = word.getBytes(); // Преобразуем строку в массив байтов
//
//        System.out.println("Слово: " + word);
//        System.out.println("Битовое представление:");
//
//        for (byte b : bytes) {
//            String bits = byteToBits(b); // Преобразуем каждый байт в битовое представление
//            System.out.print(bits+" "); // Выводим битовое представление
//        }
//    }
//
//    public static String byteToBits(byte b) {
//        StringBuilder result = new StringBuilder();
//        for (int i = 7; i >= 0; i--) {
//            result.append((b >> i) & 0x01); // Получаем i-й бит
//        }
//        return result.toString(); // Возвращаем строку с битами
//    }

        int[] nums = new int[]{3, 1, 4, 2, 5};
        System.out.println(Arrays.toString(nums));
        tasks.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}