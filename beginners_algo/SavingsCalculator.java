package beginners_algo;

import java.util.Scanner;

public class SavingsCalculator {
    public static void main(String[] args) {
        // Create Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Constants
        final  double MONTHLY_INTEREST_RATE = 0.0375 / 12; // 3.75% annual rate divided by 12

        // Prompt user for monthly saving amount
        System.out.print("Enter the monthly saving amount: ");
        double monthlySavings = scanner.nextDouble();

        // Initialize the account value
        double accountValue = 0;

        // Calculate and display account value for each month
        for (int month = 1; month <= 6; month++) {
            // Add the monthly savings and calculate interest
            accountValue = (accountValue + monthlySavings) * (1 + MONTHLY_INTEREST_RATE);

            // Display the result for this month
            switch (month) {
                case 1:
                    System.out.printf("After the first month, the account value is %.4f%n", accountValue);
                    break;
                case 2:
                    System.out.printf("After the second month, the account value is %.4f%n", accountValue);
                    break;
                case 3:
                    System.out.printf("After the third month, the account value is %.4f%n", accountValue);
                    break;
                case 4:
                    System.out.printf("After the fourth month, the account value is %.4f%n", accountValue);
                    break;
                case 5:
                    System.out.printf("After the fifth month, the account value is %.4f%n", accountValue);
                    break;
                case 6:
                    System.out.printf("After the sixth month, the account value is %.4f%n", accountValue);
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}