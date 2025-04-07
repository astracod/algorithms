package org.example.algorithms;

public class LargestOddNumberInString_1903 {

    public static String largestOddNumber(String num) {
        int index = num.length() - 1;
        while (index > -1) {
            if ((num.charAt(index) - '0') % 2 == 0) index--;
            else return num.substring(0, index + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "52";
        String num1 = "4206";
        String num2 = "35427";
        System.out.println(largestOddNumber(num2));
    }
}
