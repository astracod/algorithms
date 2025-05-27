package org.example.algorithms;

public class MinimumHours_2383 {
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hours = 0;
        int length = energy.length;
        for (int i = 0; i < length; i++) {
            if (initialEnergy <= energy[i]) {
                int differenceEnergy = (energy[i] + 1) - initialEnergy;
                hours += differenceEnergy;
                initialEnergy += differenceEnergy;
            }
            if (initialExperience <= experience[i]) {
                int differentExperience = (experience[i] + 1) - initialExperience;
                hours += differentExperience;
                initialExperience += differentExperience;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return hours;
    }

    public static void main(String[] args) {
        int initialEnergy = 5;
        int initialExperience = 3;
        int[] energy = new int[]{1, 4, 3, 2};
        int[] experience = new int[]{2, 6, 3, 1};
        int initialEnergy1 = 1;
        int initialExperience1 = 1;
        int[] energy1 = new int[]{1, 1, 1, 1};
        int[] experience1 = new int[]{1, 1, 1, 50};
        System.out.println(minNumberOfHours(initialEnergy1, initialExperience1, energy1, experience1));
    }
}
