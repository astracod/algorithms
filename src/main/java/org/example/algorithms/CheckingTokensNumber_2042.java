package org.example.algorithms;

public class CheckingTokensNumber_2042 {
    public static boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int number = 0;
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))){
                if (number >= Integer.parseInt(token)) return false;
                else number = Integer.parseInt(token);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        String s1 = "hello world 5 x 5";
        String s2 = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        System.out.println(areNumbersAscending(s));
    }
}
