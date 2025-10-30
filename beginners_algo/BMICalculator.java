package beginners_algo;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        // constants for conversion
        final double KILOS_PER_POUND = 0.45359237;
        final double METER_PER_INCH = 0.0254;

        // create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt for weight
        System.out.print("Enter weight in pounds: ");
        double weightInPounds = scanner.nextDouble();

        // Prompt for height
        System.out.print("Enter height in inches: ");
        double heightInInches = scanner.nextDouble();

        // converting weight into kilograms
        double weightInKgs = weightInPounds * KILOS_PER_POUND;

        // converting height into meters
        double heightInMeters = heightInInches * METER_PER_INCH;

        // Calculate BMI
        double bmi = weightInKgs / (heightInMeters * heightInMeters);
        // display result
        System.out.printf("BMI is %.4f%n", bmi);
        scanner.close();
    }
}
