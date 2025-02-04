package org.example.algorithms;

public class Alg_MedianOfTwoSortedArray_4 {

    /**
     * Находит медиану двух отсортированных массивов с использованием бинарного поиска.
     * Алгоритм оптимизирует поиск, работая только с меньшим массивом, что ускоряет процесс.
     * <p>
     * Алгоритм делит оба массива на две части, проверяя, что все элементы слева от разбиений
     * меньше или равны элементам справа от разбиений. Когда это условие выполняется, медиана
     * вычисляется в зависимости от общего количества элементов (четное или нечетное).
     * <p>
     * Переменные:
     * - low: Нижняя граница текущего диапазона для бинарного поиска на первом массиве.
     * - high: Верхняя граница текущего диапазона для бинарного поиска на первом массиве.
     * - partition1: Индекс разбиения первого массива (nums1), который делит его на две части.
     * - partition2: Индекс разбиения второго массива (nums2), который делит его на две части.
     * - maxLeft1: Максимальное значение слева от разбиения в первом массиве (nums1).
     * - minRight1: Минимальное значение справа от разбиения в первом массиве (nums1).
     * - maxLeft2: Максимальное значение слева от разбиения во втором массиве (nums2).
     * - minRight2: Минимальное значение справа от разбиения во втором массиве (nums2).
     * - totalLength: Общее количество элементов в обоих массивах.
     * - median: Результат, медиана двух массивов, который вычисляется по условиям.
     * <p>
     * Формулы:
     * - partition1 = (low + high) / 2;
     * Разбиение первого массива выбирается через бинарный поиск, который делит массив на две части.
     * <p>
     * - partition2 = (totalLength + 1) / 2 - partition1;
     * Разбиение второго массива выбирается так, чтобы суммарное количество элементов слева от разбиений
     * было равно или на 1 больше, чем справа.
     * <p>
     * Условия:
     * - if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1):
     * Это условие проверяет, что все элементы слева от разбиений (maxLeft1 и maxLeft2) меньше или равны
     * элементам справа от разбиений (minRight1 и minRight2). Если это условие выполняется, значит,
     * мы нашли правильное разбиение, и можно вычислить медиану.
     * <p>
     * Если условие не выполняется:
     * - if (maxLeft1 > minRight2):
     * Это означает, что разбиение в первом массиве слишком большое, и мы сдвигаем границу поиска влево,
     * уменьшая partition1.
     * <p>
     * - else (maxLeft2 > minRight1):
     * Это означает, что разбиение во втором массиве слишком большое, и мы сдвигаем границу поиска вправо,
     * увеличивая partition1.
     * <p>
     * Пример:
     * Для массивов:
     * - nums1 = [1, 3, 8]
     * - nums2 = [7, 9, 10, 12]
     * totalLength = 7 (общее количество элементов)
     * После выполнения бинарного поиска на меньшем массиве (nums1), разбиение будет следующим:
     * - partition1 = 1 (первый массив делится на [1] и [3, 8])
     * - partition2 = 3 (второй массив делится на [7, 9] и [10, 12])
     * <p>
     * maxLeft1 = nums1[partition1 - 1] = 1
     * minRight1 = nums1[partition1] = 3
     * maxLeft2 = nums2[partition2 - 1] = 9
     * minRight2 = nums2[partition2] = 10
     * <p>
     * Условие maxLeft1 <= minRight2 && maxLeft2 <= minRight1 выполняется:
     * - 1 <= 10 и 9 <= 3. Это условие выполняется, и медиана вычисляется.
     * <p>
     * В случае, если условие не выполняется, мы корректируем разбиение:
     * - Если maxLeft1 > minRight2, мы сдвигаем high влево, уменьшая partition1.
     * - Если maxLeft2 > minRight1, мы сдвигаем low вправо, увеличивая partition1.
     * <p>
     * Важно:
     * - Мы всегда работаем с меньшим массивом, чтобы минимизировать количество итераций бинарного поиска.
     * - Алгоритм эффективно находит медиану за время O(log(min(n1, n2))), где n1 и n2 — длины двух массивов.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = nums1.length;
        int totalLength = nums1.length + nums2.length;
        double median = 0.0;
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (totalLength + 1) / 2 - partition1;

            // Проверяем границы массивов
            int maxLeft1 = (partition1 > 0) ? nums1[partition1 - 1] : Integer.MIN_VALUE;
            int minRight1 = (partition1 < nums1.length) ? nums1[partition1] : Integer.MAX_VALUE;

            int maxLeft2 = (partition2 > 0) ? nums2[partition2 - 1] : Integer.MIN_VALUE;
            int minRight2 = (partition2 < nums2.length) ? nums2[partition2] : Integer.MAX_VALUE;

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if (totalLength % 2 == 0) {
                    median = (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    median = Math.max(maxLeft1, maxLeft2);
                }
                break;
            } else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        return median;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        int[] nums3 = new int[]{1, 3};
        int[] nums4 = new int[]{2};
        int[] nums5 = new int[]{1, 3, 8};
        int[] nums6 = new int[]{7, 9, 10, 12};
        System.out.println(findMedianSortedArrays(nums3, nums4));

    }
}
