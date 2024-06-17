package org.example.algorithms;

public class RevertString {

    /* Переворот строки */
    public static String revertString(String val) {
        char[] a = val.toCharArray();
        int s = a.length - 1;
        for (int i = 0; i < a.length / 2; i++) {
            char d = a[s];
            a[s] = a[i];
            a[i] = d;
            s--;
        }
        return new String(a);
    }

    public static String revertString1(String val) {
        StringBuffer s = new StringBuffer();
        for (int i = val.length() - 1; i >= 0; i--) {
            s.append(val.charAt(i));
        }
        return s.toString();
    }

    public static void test() {
        System.out.println(revertString("A").equals("A"));
        System.out.println(revertString("AB").equals("BA"));
        System.out.println(revertString("ABC").equals("CBA"));
    }

    public static void main(String[] args) {
        String abc = "asdfg";
        System.out.println(revertString(abc));
        System.out.println(revertString1(abc));
//        test();


    }

}
