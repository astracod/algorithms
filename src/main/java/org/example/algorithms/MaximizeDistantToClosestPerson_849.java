package org.example.algorithms;

public class MaximizeDistantToClosestPerson_849 {

    /**
     * 2 ms Beats 98.72%
     */
    public static int maxDistToClosest(int[] seats) {
        int i = 0, count = 0;
        int max = -1;
        while (i < seats.length) {
            int j = i;

            if (seats[i] == 1) i++;
            else {
                int res = 0;
                while (j < seats.length && seats[j] == 0) {
                    j++;
                    count++;
                }
                if (i == 0 || j == seats.length) {
                    res = count;
                }
                if (i != 0 && j != seats.length) {
                    if (count % 2 == 0) res = count / 2;
                    else res = (count / 2) + 1;
                }
                if (max < res) max = res;
                i = j;
                count = 0;
            }
        }
        return max;
    }
}
