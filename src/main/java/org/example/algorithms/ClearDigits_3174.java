package org.example.algorithms;

public class ClearDigits_3174 {

    /**
     *  Если элемент равен 0 или 9, то удаляем предыдущий.
     *  Иначе просто добавляем, то элемент не равен ни 0 ни 9.
     *  Это работает потому что по условию любому числу предстоит литерал.
     *  В итоге остаются после добавления -> удаления только те литералы которые
     *  находятся без числовой пары.
     */
    public static String clearDigitsForHint(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    /**
     * мое сложное решение. Выше решение из подсказки
     */
    public static String clearDigits(String s) {
        int end = s.length() - 1;
        int lastIndexDigit = 0;
        String postLastDigit = null;
        int amountDigits = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (Character.isDigit(s.charAt(i))) {
                amountDigits++;
                lastIndexDigit = i;
            }
        }

        if (lastIndexDigit < end) postLastDigit = s.substring(lastIndexDigit + 1);
        String w = s.substring(0, lastIndexDigit + 1);
        StringBuilder work = new StringBuilder(w);
        int i = 0;
        while (i < work.length() && amountDigits > 0) {
            if (Character.isDigit(work.charAt(i))) {
                work.deleteCharAt(i);
                work.deleteCharAt(i - 1);
                amountDigits--;
                i = i - 2;
            }
            i++;
        }
        if (work.length() > 0 && postLastDigit != null) return work + postLastDigit;
        else if (work.isEmpty() && postLastDigit != null) return postLastDigit;
        else if (!work.isEmpty() && postLastDigit == null) return work.toString();
        else return "";
    }

    public static void main(String[] args) {
        String s = "cb34";
        String s2 = "acb34";
        String s3 = "a8f";
        String s4 = "li5i56";
        String s5 = "li5i56a";
        System.out.println(clearDigitsForHint(s4));
    }
}
