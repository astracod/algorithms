package org.example.algorithms;

public class MaximumTime_1736 {

    public static String maximumTime(String time) {
        StringBuilder builder = new StringBuilder(time.length());
        for (int i = 0; i < time.toCharArray().length; i++) {
            if (time.charAt(i) == '?') {
                System.out.println("Begin "+ i+ " "+ time.charAt(0));
                if (i == 0 && (time.charAt(1) -'0' < 4 || time.charAt(1) == '?')){
                    System.out.println("here 1");
                    builder.append(2);
                }
                else if (i == 0 && time.charAt(1) -'0' > 3){
                    System.out.println("else 1 " + builder.charAt(i));
                    builder.append(1);
                }
                if (i == 1 && (time.charAt(0) - '0' == 2 || time.charAt(0)  == '?')){
                    System.out.println("here 2");
                    builder.append('3');
                }
                else if (i == 1 && time.charAt(0) -'0' < 2){
                    System.out.println("else 2 "+ (time.charAt(0) -'0'));
                    builder.append('9');
                }
                if (i==3){
                    System.out.println("if 3");
                    builder.append('5');
                }
                if (i==4){
                    System.out.println("if 4");
                    builder.append('9');
                }
            } else builder.append(time.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String time = "2?:?0"; // "23:50"
        String time1 = "0?:3?"; // "09:39"
        String time2 = "1?:22"; // "19:22"
        String time3 = "??:3?"; // "23:39"
        System.out.println(maximumTime(time3));
    }
}
