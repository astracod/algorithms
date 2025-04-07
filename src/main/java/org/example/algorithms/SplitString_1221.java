package org.example.algorithms;

public class SplitString_1221 {
    public static int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;
        for (char c : s.toCharArray()) {
            balance += c == 'L' ? 1 : -1;
            if (balance == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String a = "RLRRLLRLRL"; //4
        String b = "RLRRRLLRLL"; //2
        String c = "LLLLRRRR"; //1
        System.out.println(balancedStringSplit(c));
    }
}
