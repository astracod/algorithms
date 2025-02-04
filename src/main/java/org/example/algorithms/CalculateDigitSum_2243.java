package org.example.algorithms;

public class CalculateDigitSum_2243 {

    private static String workOnString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (i + k - 1 < s.length()) {
                int left = i;
                int right = k + left;
                while (left < right) {
                    sum += s.charAt(left) - '0';
                    if (left == right - 1) {
                        sb.append(sum);
                        sum = 0;
                        i = right - 1;
                    }
                    left++;
                }
            } else {
                sum += s.charAt(i) - '0';
                if (i == s.length() - 1) sb.append(sum);
            }
        }
        return sb.toString();
    }

    public static String digitSum(String s, int k) {
        String resultString = s;
        while (resultString.length() > k) {
            resultString = workOnString(resultString, k);
            System.out.println(resultString);
        }
        return resultString;
    }

    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        String s2 = "00000000";
        String s3 = "1234";
        System.out.println(digitSum(s, 3));
    }
}
