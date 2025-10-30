package beginners_algo;

import java.util.Scanner;

public class QuadraticEquationSolver {

    public static void main(String[] args) {
        // Create a scanner object to read input from user
        Scanner input = new Scanner(System.in);

        // Prompt user to enter values for a, b, and c=
        System.out.print("Enter value for a: ");
        double a = input.nextDouble();

        System.out.print("Enter value for b: ");
        double b = input.nextDouble();

        System.out.print("Enter value for c: ");
        double c = input.nextDouble();

        // Calculate the discriminant
        double discriminant = Math.pow(b, 2) - 4 * a * c;

        // Determine the number of roots and display the result
        if (discriminant > 0) {
            // Two real roots
            double r1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double r2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The equation has two real roots: r1 = " + r1 + " and r2 = " + r2);
        } else if (discriminant == 0) {
            // One real root
            double r1 = -b / (2 * a);
            System.out.println("The equation has one root: r1 = " + r1);
        } else {
            // No real roots
            System.out.println("The equation has no real roots.");
        }

        // Close the scanner
        input.close();
    }
}
