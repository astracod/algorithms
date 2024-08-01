package org.example.informatics;

import java.util.Scanner;

public class SortByMaximumSelection {

    public static void maxSort(int[] a) {
        int index= 0;
        int max =a[0];
        for (int i = 1; i < a.length; i++) {
           if (a[i] > max){
               max = a[i]; index = i;
           }
        }
        a[index] = a[0]; a[0] = max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                numbers[i] = scanner.nextInt();
            }
        }
        maxSort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }
}
