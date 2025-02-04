package org.example.algorithms;

public class ShortestCompletingWord_748 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] license = new int[26];
        String res = null;
        for (char c : licensePlate.toCharArray()) {
            char cur = Character.toLowerCase(c);
            if (Character.isLetter(cur)) license[cur - 'a']++;
        }
        for (String word : words) {
            int[] wordArr = new int[26];
            for (char c : word.toCharArray()) {
                wordArr[c - 'a']++;
            }
            boolean bool = true;
            for (int i = 0; i < license.length; i++) {
                if (license[i] != 0 && license[i] > wordArr[i]){
                        bool = false;
                        break;
                }
            }
            if (bool && (res == null || word.length() < res.length())) {
                res = word;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"step", "steps", "stripe", "stepple"};
        String[] words2 = new String[]{"looks", "pest", "stew", "show"};
        System.out.println(shortestCompletingWord("1s3 456", words2));
    }
}
