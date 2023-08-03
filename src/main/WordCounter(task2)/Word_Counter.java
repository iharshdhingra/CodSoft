package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Word_Counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter '1' to enter text manually or '2' to provide a file: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String text = "";

        if (choice == 1) {
            System.out.print("Enter the text: ");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice. Exiting the program.");
            System.exit(1);
        }

        // Step 3: Split the string into an array of words using space or punctuation as delimiters.
        String[] words = text.split("[\\s.,;?!\"'()-]+");

        // Step 4: Initialize a counter variable to keep track of the number of words.
        int wordCount = 0;

        // Step 5: Iterate through the array of words and increment the counter for each word encountered.
        for (String word : words) {
            if (!word.isEmpty()) { // Ignore empty strings
                wordCount++;
            }
        }

        // Step 6: Display the total count of words to the user.
        System.out.println("Total number of words: " + wordCount);

        // Close the scanner.
        scanner.close();
    }
}
