package org.example.algorithms;

public class Alg_AddString_415 {
    public static String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();


        while (len1 >= 0 || len2 >= 0 || carry != 0) {
            int digit1 = (len1 >= 0) ? num1.charAt(len1) - '0' : 0; // Если строка закончилась, считаем цифру = 0
            int digit2 = (len2 >= 0) ? num2.charAt(len2) - '0' : 0;

            int sum = digit1 + digit2 + carry; // Суммируем цифры и перенос
            carry = sum / 10; // Новый перенос
            result.append(sum % 10); // Добавляем последнюю цифру суммы в результат

            len1--;
            len2--;
        }

        return result.reverse().toString();
    }


    public static void main(String[] args) {
        String num1 = "11", num2 = "123"; // 134
        String num3 = "456", num4 = "77"; // 533
        String num5 = "3876620623801494171", num6 = "6529364523802684779";
        String ans = addStrings(num5, num6);
        String rightly = "10405985147604178950";
        System.out.println(ans);
        System.out.println(rightly);

    }
}
