package week1_assignment;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    // Method to find the longest streak
    static void findLongestStreak(String signalLog) {

        int currentCount = 1;
        int longestCount = 1;
        char longestColor = signalLog.charAt(0);

        // Traverse the signal log
        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            // Check if current streak is the longest
            if (currentCount > longestCount) {
                longestCount = currentCount;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longestCount + " times");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the signal log: ");
        String signalLog = sc.nextLine();

        // Check for empty input
        if (signalLog.length() == 0) {
            System.out.println("Signal log cannot be empty.");
        } else {
            findLongestStreak(signalLog);
        }

        sc.close();
    }
}