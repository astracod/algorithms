package org.example.algorithms;

public class FirstUniqueChar_387 {

    public static int firstUniqChar(String s) {
        int[] sChars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) -'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
