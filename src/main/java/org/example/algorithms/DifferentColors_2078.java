package org.example.algorithms;

public class DifferentColors_2078 {
    public static int maxDistance(int[] colors) {
        int lastColor = colors[colors.length - 1];
        int left = 0;
        for (int i = 0; i < colors.length; ) {
            if (colors[i] == lastColor) i++;
            else {
                left = (colors.length - 1) - i;
                break;
            }
        }
        int firstColor = colors[0];
        int right = 0;
        for (int i = colors.length - 1; i >=0; ) {
            if (colors[i] == firstColor) i--;
            else {
                right = i;
                break;
            }
        }
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] colors = new int[]{1, 1, 1, 6, 1, 1, 1};// 3
        int[] colors1 = new int[]{1, 8, 3, 8, 3};// 4
        int[] colors2 = new int[]{1, 1, 6, 1, 1, 1, 1};// 4
        System.out.println(maxDistance(colors2));
    }
}
