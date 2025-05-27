package org.example.algorithms;

public class CorrectTime_2224 {
    public static int convertTime(String current, String correct) {

        String[] currentParts = current.split(":");
        String[] correctParts = correct.split(":");
        int currentInMinutes = (Integer.parseInt(currentParts[0]) * 60) + Integer.parseInt(currentParts[1]);
        int correctToMinutes = (Integer.parseInt(correctParts[0]) * 60) + Integer.parseInt(correctParts[1]);
        int calculatedTime = correctToMinutes - currentInMinutes;

        int numberOfOperations = 0;
        numberOfOperations += calculatedTime / 60;
        calculatedTime = calculatedTime % 60;
        numberOfOperations += calculatedTime / 15;
        calculatedTime = calculatedTime % 15;
        numberOfOperations += calculatedTime / 5;
        calculatedTime = calculatedTime % 5;

        return numberOfOperations + calculatedTime;
    }

    public static void main(String[] args) {
        String current = "02:30";
        String correct = "04:35";
        String current1 = "11:00";
        String correct1 = "11:01";
        String current2 = "11:00";
        String correct2 = "11:08";
        System.out.println(convertTime(current2, correct2));
    }
}
