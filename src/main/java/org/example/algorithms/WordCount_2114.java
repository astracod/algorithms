package org.example.algorithms;

public class WordCount_2114 {
    public static int mostWordsFound(String[] sentences) {
        int space = 1;
        for (String sentence : sentences) {
            int res = 1;
            for (char c : sentence.toCharArray()) {
                if (c == ' ') res++;
            }
            if (space < res) space = res;
        }
        return space;
    }

    public static void main(String[] args) {
        String[] sentences = new String[]{"alice and bob love leetcode",
                "i think so too", "this is great thanks very much"};
        String[] sentences1 = new String[]{"please wait", "continue to fight", "continue to win"};
        String[] sentences2 = new String[]{"please"};
        System.out.println(mostWordsFound(sentences2));
    }
}
