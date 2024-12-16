package org.example.algorithms;

public class CheckBalancedString_3340 {

    public static boolean isBalanced(String num) {
        int evenIndex = 0, oddIndex = 0;
        for (int i = 0; i < num.toCharArray().length; i++) {
            if (i % 2 == 0) evenIndex += num.charAt(i) -'0';
            else oddIndex += num.charAt(i) -'0';
        }
        return evenIndex == oddIndex;
    }

    public static void main(String[] args) {
        String num = "1234";
        String num2 = "24123";
        System.out.println(isBalanced(num));
    }
}
