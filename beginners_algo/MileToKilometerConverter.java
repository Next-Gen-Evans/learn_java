package beginners_algo;

import java.util.Scanner;

public class MileToKilometerConverter {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter distance in miles: ");

        // Read the double value from the user
        double miles = scanner.nextDouble();

        // Convert miles to kilometers
        double kilometers = miles * 1.6;

        // Display the result
        System.out.println(miles + " miles is equal to " + kilometers + " kilometers");

        // Close the scanner
        scanner.close();
    }
}