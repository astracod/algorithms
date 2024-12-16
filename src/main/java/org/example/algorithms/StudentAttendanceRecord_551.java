package org.example.algorithms;

public class StudentAttendanceRecord_551 {

    public static boolean checkRecord(String s) {
        int A = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') A++;
        }
        return A < 2 && !s.contains("LLL");
    }

    public static void main(String[] args) {
        String s = "LALL";
        System.out.println(checkRecord(s));
    }
}
