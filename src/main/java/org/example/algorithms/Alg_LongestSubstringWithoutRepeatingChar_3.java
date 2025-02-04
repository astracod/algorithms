package org.example.algorithms;

public class Alg_LongestSubstringWithoutRepeatingChar_3 {

    /**
     * Мы перебираем строку, перемещая указатель «конца» слева направо.
     * <p>
     * 1) currentChar = s[end]: Мы получаем текущий символ в позиции «конец».
     * <p>
     * 2) start = max(start, lastIndex[currentChar]): Это важный шаг.
     * Мы обновляем наш указатель «старт» до максимального значения его текущего значения и последней видимой
     * позиции текущего символа плюс один.
     * <p>
     *    - Если мы ранее не видели этот символ (или видели, но он находится за пределами нашего текущего окна),
     *   lastIndex[currentChar]будет меньше start, поэтому start останется неизменным.
     *    - Если мы видели этот символ в нашем текущем окне, lastIndex[currentChar]будет больше или равно start.
     *   В этом случае мы перемещаемся start в позицию сразу после того, где мы последний раз видели этот символ.
     * Этот шаг фактически «перемещает» наш начальный указатель в правильное положение,
     * когда мы сталкиваемся с повторением, гарантируя, что наше окно всегда будет содержать уникальные символы.
     * <p>
     * 3) maxLength = max(maxLength, end - start + 1): Мы обновляем, maxLength если наше текущее окно длиннее
     * предыдущей самой длинной  подстроки.
     * <p>
     * 4)  lastIndex[currentChar] = end + 1: Мы обновляем последнюю видимую позицию текущего персонажа.
     * Мы используем end + 1 вместо , end потому что это упрощает нашу логику на шаге 2 — это позволяет нам перейти start
     * непосредственно к правильной позиции без необходимости добавлять 1.
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] lastIndex = new int[128];// Мы используем размер 128, поскольку он охватывает все символы ASCII.

        for (int start = 0, end = 0; end < n; end++) {
            // получаем символ по индексу end
            char currentChar = s.charAt(end);
            // передвигаем левый указатель на символ вправо на 1 от последнего повторения правого указателя
            start = Math.max(start, lastIndex[currentChar]);
            // на каждом шаге проверяем длину отрезка от правого указателя до левого
            maxLength = Math.max(maxLength, end - start + 1);
            // заполняем массив индексами строки отражающими последнее положение каждого символа
            lastIndex[currentChar] = end + 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";
        String s4 = "au";
        String s5 = "dvdf";
        String s6 = "anviaj";
        System.out.println(lengthOfLongestSubstring(s2));
    }
}
