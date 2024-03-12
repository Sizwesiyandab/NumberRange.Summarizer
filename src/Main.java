import numberrangesummarizer.INumberRangeSummarizer;
import numberrangesummarizer.NumberRangeSummarizer;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter something
        System.out.print("Enter Input: ");

        // Read the input from the console
        String userInput = scanner.nextLine();

        NumberRangeSummarizer numberRange = new NumberRangeSummarizer();

        // Collect input
        var numbers = numberRange.collect(userInput);

        // Printout
        System.out.println(numberRange.summarizeCollection(numbers));
    }
}