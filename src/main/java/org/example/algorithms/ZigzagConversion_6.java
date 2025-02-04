package org.example.algorithms;

public class ZigzagConversion_6 {
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }
        char[] charArray = s.toCharArray();
        int zigzag = numRows - 1;
        for (int i = 0, index = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (index < numRows) {
                arr[index].append(c);
                index++;
            } else if (index == numRows && zigzag > 1) {
                    arr[zigzag-1].append(c);
                    zigzag--;
            }
            if (zigzag == 1 && index == numRows) {
                zigzag = numRows - 1;
                index = 0;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : arr) {
            res.append(builder);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String s1 = "PAYPALISHIRING";
        int numRows1 = 4;
//        System.out.println(convert(s, numRows));
        System.out.println(convert("A", 1));
    }
}
