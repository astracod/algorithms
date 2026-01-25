package org.example.algorithms;

public class Characters_717 {
    public static boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] == 1; i--) {
            count++;
        }
        return count % 2 == 0;
    }

    public static void main(String[] args) {
        int[] bits1 = new int[]{1, 0, 0}; // true
        int[] bits2 = new int[]{1, 1, 1, 0}; // false
        System.out.println(isOneBitCharacter(bits1));
    }
}
