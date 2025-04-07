package org.example.algorithms;

import java.util.Arrays;

public class MinimumNumber_2037 {
    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int movies =0;
        for (int i = 0; i < seats.length; i++) {
            movies += Math.abs(seats[i] - students[i]);
        }
        return movies;
    }

    public static void main(String[] args) {
        int[] seats = new int[]{3,1,5};
        int[] students = new int[]{2,7,4};//4
        int[] seats1 = new int[]{4,1,5,9};
        int[] students1 = new int[]{1,3,2,6};// 7
        int[] seats2 = new int[]{2,2,6,6};
        int[] students2 = new int[]{1,3,2,6};// 4
        int[] seats3 = new int[]{12,14,19,19,12};
        int[] students3 = new int[]{19,2,17,20,7};// 19
        System.out.println(minMovesToSeat(seats2,students2));
    }
}
