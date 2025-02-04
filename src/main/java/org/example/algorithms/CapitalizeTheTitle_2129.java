package org.example.algorithms;

public class CapitalizeTheTitle_2129 {
    public static String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            if (s.length() < 3){
                result.append(s.toLowerCase());
                result.append(' ');
            }
            else {
                result.append(Character.toUpperCase(s.charAt(0)));
                result.append(s.substring(1).toLowerCase());
                result.append(' ');
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String title = "capiTalIze tHe titLe";
        String title1 = "First leTTeR of EACH Word";
        String title2 = "i lOve leetcode";
        System.out.println("i Love Leetcode");
        System.out.println(capitalizeTitle(title2));
    }
}
