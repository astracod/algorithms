package org.example.algorithms;

public class GreatestGoodNumber_2264 {

    public static String returnString(int a) {
        if (a == 0) return "000";
        int iter = 2;
        int res = 0;
        while (iter >= 0) {
            int con = a;
            int period = (int) Math.pow(10, iter);
            con *= period;
            res += con;
            iter--;
        }
        return String.valueOf(res);
    }

    public static String largestGoodInteger(String num) {
        int index = 9;
        String max = "-1";
        while (index >= 0) {
            String res = returnString(index);
            if (num.contains(res)) {
                if (Integer.parseInt(max) < Integer.parseInt(res))  max = res;
            }
            index--;
        }
        if (max.equals("-1")) return "";
        else return max;
    }

    public static void main(String[] args) {
        String num = "6777133339";
        String num1 = "2300019";
        String num2 = "42352338";
        System.out.println(largestGoodInteger(num1));
    }
}
