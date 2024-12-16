package org.example.algorithms;

public class LexicographicallySmallestString_3216 {

    private static boolean matchingPair(int a, int b) {
        return (a % 2 == 0 && b % 2 == 0) || (a % 2 != 0 && b % 2 != 0);
    }

    public static String getSmallestString(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1 < s.length())
                    && matchingPair(s.charAt(i) - '0', s.charAt(i + 1) - '0')
                    && (s.charAt(i) - '0') > (s.charAt(i + 1) - '0')) {
                char buf = s.charAt(i + 1);
                charArray[i + 1] = charArray[i];
                charArray[i] = buf;
                break;
            }

        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String s = "45320";
        String s2 = "001";
        String s3 = "20";
        System.out.println(getSmallestString(s));
    }
}
