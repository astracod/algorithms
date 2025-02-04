package org.example.algorithms;

public class CheckPrefixToArray_1961 {
    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(word);
            if (res.length() == s.length()){
               return res.toString().equals(s);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] words = new String[]{"i", "love", "leetcode", "apples"};
        String s1 = "iloveleetcode";
        String[] words1 = new String[]{"apples", "i", "love", "leetcode"};
        String s2 = "z";
        String[] words2 = new String[]{"z"};
        System.out.println(isPrefixString(s2,words2));
    }
}
