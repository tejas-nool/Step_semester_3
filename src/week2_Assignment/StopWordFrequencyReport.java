package week2_Assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StopWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        String cleanedText = feedback.toLowerCase();

        // Remove punctuation
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        // Split into words
        String[] words = cleanedText.split("\\s+");

        // Stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // HashMap to store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        // Process each word
        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            boolean isStopWord = false;

            // Check whether word is a stop word
            for (int j = 0; j < stopWords.length; j++) {

                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (!isStopWord) {

                if (frequency.containsKey(word)) {
                    frequency.put(word, frequency.get(word) + 1);
                } else {
                    frequency.put(word, 1);
                }
            }
        }

        // Convert HashMap entries to ArrayList
        ArrayList<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by frequency in descending order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> a,
                               Map.Entry<String, Integer> b) {

                return b.getValue() - a.getValue();
            }
        });

        // Print result
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}