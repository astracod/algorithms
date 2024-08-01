package org.example.my_hashset;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.util.stream.Collectors;

class MyHashSet {
    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int v, ListNode n) {
            val = v;
            next = n;
        }
    }

    public ListNode[] T;
    int size = 1001;

    public MyHashSet() {
        T = new ListNode[size];
    }

    int hash(int key) {
        if (key >= 0) return key % size;   // 704 % 7 = 4
        else return (key * (-1)) % size;
    }

    public void add(int key) {
        if (contains(key)) return;
        int index = hash(key);    // 25%7 = 4
        T[index] = new ListNode(key, T[index]);
    }

    public void remove(int key) {
        int index = hash(key);
        if (T[index] == null) return;
        if (T[index].val == key)
            T[index] = T[index].next;
        else {
            ListNode tmp = T[index];    //со второго
            while (tmp.next != null && tmp.next.val != key)
                tmp = tmp.next;
            if (tmp.next != null)
                tmp.next = tmp.next.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        if (T[index] == null) return false;
        ListNode tmp = T[index];
        while (tmp != null) {
            if (tmp.val == key)
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public int printSet() {
        int answer = -1000;
        for (ListNode listNode : T) {
            if (listNode != null) {
                ListNode node = listNode;
                while (node != null) {
                    answer = node.val;
                    node = node.next;
                }
            }
        }
        return answer;
    }

}

class Solutions {

    public int singleNumber(int[] nums) {
        MyHashSet set = new MyHashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) set.add(nums[i]);
            else if (set.contains(nums[i])) set.remove(nums[i]);
        }
        return set.printSet();
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        if (str1.length() == 0 && str2.length() == 0) return true;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> states = new HashMap<>();
        for (String str : strs) {
            char[] copy = str.toCharArray();
            Arrays.sort(copy);
            String result = new String(copy);
            boolean flag = false;
            if (states.containsKey(result)) {
                List<String> stringList = states.get(result);
                for (String s : stringList) {
                    if (isAnagram(s, str)) {
                        flag = true;
                    }
                }
                if (flag) states.get(result).add(str);
                else {
                    List<String> differentMeaning = new ArrayList<>();
                    differentMeaning.add(str);
                    states.put(result, differentMeaning);
                }
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                states.put(result, list);
            }
        }
        return new ArrayList<>(states.values());
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        if (s.length() < p.length()) return answer;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < p.toCharArray().length; i++) {
            sum1 += s.charAt(i);
            sum2 += p.charAt(i);
        }
        if (sum1 == sum2) {
            if (isAnagram(s.substring(0, p.length()), p)) answer.add(0);
        }
        for (int i2 = 1; i2 < ((s.length() - p.length()) + 1); i2++) {
            sum1 = sum1 - ((int) s.charAt(i2 - 1)) + ((int) s.charAt(i2 + p.length() - 1));
            if (sum1 == sum2) {
                if (isAnagram(s.substring(i2, (i2 + p.length())), p)) {
                    answer.add(i2);
                }
            }
        }
        return answer;
    }

    private void myMerge(int[] a, int p, int q, int r) {
        int[] c = new int[(r - p) + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = a[j++];
            }
            k++;
        }
        if (i > q)
            while (j <= r) {
                c[k] = a[j];
                j++;
                k++;
            }
        else
            while (i <= q) {
                c[k] = a[i];
                i++;
                k++;
            }
        for (i = p, k = 0; i <= r; i++, k++)
            a[i] = c[k];
    }

    public void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            myMerge(a, p, q, r);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement) && indexMap.get(complement) != i) {
                arr[0] = i;
                arr[1] = indexMap.get(complement);
                break;
            }
        }
        return arr;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> postAnswer = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int i1 = i + 1; i1 < nums.length - 2; i1++) {
                if (i1 > i + 1 && nums[i1] == nums[i1 - 1]) continue;
                for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                    if (i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) continue;
                    for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                        if (((long) nums[i] + (long) nums[i1] + (long) nums[i2] + (long) nums[i3]) == target) {
                            List<Integer> result = List.of(nums[i], nums[i1], nums[i2], nums[i3]);
                            postAnswer.add(result);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(postAnswer);
    }

    public static void main(String[] args) {
        Solutions solutions = new Solutions();

//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums2 = new int[]{2, 7, 11, 15};

        int[] res = solutions.twoSum(nums2, 9);
        for (int re : res) {
            System.out.println(re);
        }

    }
}