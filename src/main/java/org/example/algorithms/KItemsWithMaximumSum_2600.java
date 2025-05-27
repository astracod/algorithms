package org.example.algorithms;

public class KItemsWithMaximumSum_2600 {
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = Math.min(numOnes, k);
        k -= sum;

        if (k > 0) {
            k -= Math.min(numZeros, k);
        }

        if (k > 0) {
            sum -= Math.min(numNegOnes, k);
        }

        return sum;
    }

    public static void main(String[] args) {
        int numOnes = 3;
        int numZeros = 2;
        int numNegOnes = 0;
        int k = 2;
        int numOnes1 = 3;
        int numZeros1 = 2;
        int numNegOnes1 = 0;
        int k1 = 4;
        System.out.println(kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k));
    }
}
