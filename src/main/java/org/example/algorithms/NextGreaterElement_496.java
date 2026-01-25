package org.example.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_496 {


    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] resultArr = new int[nums1.length];
        if (nums2.length == 1) return new int[]{-1};

        Stack<Integer> a = new Stack<>();
        int index = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            int currentElement = nums2[i];
            int headOfStack = (a.empty()) ? a.push(nums2[i]) : a.peek();

            if (currentElement < headOfStack) {
                a.push(currentElement);
            } else if (currentElement > headOfStack) {
                while ((currentElement > headOfStack) && !a.empty()) {
                    count.put(headOfStack, currentElement);
                    a.pop();
                }
                a.push(currentElement);
            }
        }

        for (int i : nums1) {
            Integer entry = count.get(i);
            resultArr[index] = (entry != null) ? entry : -1;
            index++;
        }
        return resultArr;
    }

    /**
     * Метод оптимизированный ИИ
     * Monotonic Stack (Монотонный стек) — это структура данных,
     * в которой элементы поддерживаются в монотонно возрастающем или убывающем порядке относительно друг друга.
     * Используется для решения задач, где нужно находить первый больший/меньший элемент справа или слева.
     * Суть метода:
     * При обходе массива поддерживается стек, элементы которого упорядочены (чаще всего убывают от низа к вершине).
     * Новый элемент "выбивает" из стека все элементы, для которых он является ответом.
     * Остающиеся в стеке элементы — те, для которых ответ ещё не найден.
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Для оставшихся в стеке элементов следующего большего нет
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 4};
        int[] nums2 = new int[]{2, 1, 5, 3, 4}; // [5, 4, -1]
        int[] nums3 = new int[]{4, 1, 2};
        int[] nums4 = new int[]{1, 3, 4, 2}; // [-1,3,-1]
        int[] nums5 = new int[]{2, 4};
        int[] nums6 = new int[]{1, 2, 3, 4}; // [3,-1]
        System.out.println(Arrays.toString(nextGreaterElement(nums5, nums6)));
    }
}
