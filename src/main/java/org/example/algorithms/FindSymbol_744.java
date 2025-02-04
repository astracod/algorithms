package org.example.algorithms;

public class FindSymbol_744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter - 'a' > target - 'a') return letter;
        }
        return letters[0];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char[] letters2 = new char[]{'x', 'x', 'y', 'y'};
        System.out.println(nextGreatestLetter(letters2,'z'));
    }
}
