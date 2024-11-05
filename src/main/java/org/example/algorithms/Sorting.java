package org.example.algorithms;

import java.util.Arrays;

public class Sorting {

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int buff;
                if (arr[i] > arr[j]) {
                    buff = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buff;
                }
            }
        }
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int buff = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > buff) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = buff;
        }
    }

    /**
     * Сортировка Шелла — это улучшенная версия сортировки вставками, которая позволяет сравнивать и перемещать элементы,
     * находящиеся на большом расстоянии друг от друга. Это достигается за счет использования промежуточных шагов,
     * которые уменьшают расстояние между сравниваемыми элементами.
     *
     * @param array
     */
    public void shellSort(int[] array) {
        int n = array.length;

        // Последовательность интервалов Сиуры
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        // Проходим по каждому интервалу
        for (int gap : gaps) {
            // Пропускаем интервалы, которые больше длины массива
            if (gap >= n) {
                continue;
            }

            // Выполняем сортировку вставками для текущего интервала
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                // Сдвигаем элементы array[0..i-gap], которые больше temp,
                // на одну позицию вперед от их текущей позиции
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Sorting selectionSort = new Sorting();
        int[] sort = new int[]{100, 50, 70, 0, -5, -15};
        selectionSort.shellSort(sort);
        System.out.println(Arrays.toString(sort));
    }
}
