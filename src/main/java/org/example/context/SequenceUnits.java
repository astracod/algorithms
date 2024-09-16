package org.example.context;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class WooHoo {
    public static int sequence(int[] arr) {
        int max = 0;
        int units = 0;
        for (int i : arr) {
            if (i == 1) units++;
            else {
                if (max < units) max = units;
                units = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(r.readLine());

        int[] array = new int[length];


        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(r.readLine());
        }
        int max = sequence(array);

        System.out.println(max);
    }
}