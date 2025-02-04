package org.example.algorithms;

public class Alg_FindMaxNumber_2259 {

    /**
     * digit < number.charAt(i+1) условие которое определяет, что если следующий символ
     * больше чем удаляемый, то это гарантирует максимальное число по результату удаления.
     * Пример 3439, удаляем 3 и получаем 2 числа 439 и 349.
     */
    public static String removeDigit(String number, char digit) {
        int index = 0,n=number.length();
        for(int i=0;i<n;i++){
            if(number.charAt(i)==digit){
                index = i;
                if(i<n-1 && digit < number.charAt(i+1)) break;
            }
        }
        number = number.substring(0, index) + number.substring(index+1);
        return number;
    }

    public static void main(String[] args) {
        String number = "123";
        char digit = '3';
        String number1 = "1231";
        char digit1 = '1';
        String number2 = "551";
        char digit2 = '5';
        System.out.println(removeDigit(number2,digit2));
    }
}
