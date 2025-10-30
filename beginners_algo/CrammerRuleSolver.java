package beginners_algo;

public class CrammerRuleSolver {
    public static void main(String[] args) {

        // Coefficients for the system of Linear equations:
        // 3.4x + 50.2y = 44.5
        // 2.1x + 0.55y = 5.9

        double a = 3.4;
        double b = 50.2;
        double c = 2.1;
        double d = 0.55;
        double e = 44.5;
        double f = 5.9;

        double determinant = a * d - b * c;

        if (determinant == 0) {
            System.out.println("The system had no unique solution");
            return;
        }

        double x = (e * d - b * f) / determinant;

        double y = (a * f - b * f) / determinant;

        System.out.println("Solution to the system of linear equations:");
        System.out.printf("x = %.4f%n", x);
        System.out.printf("y = %.4f%n", y);

        // Verify the solution by substituting back into original equations
        System.out.println("\nVerification:");
        System.out.printf("Equation 1: 3.4x + 50.2y = %.4f%n", 3.4 * x + 50.2 * y);
        System.out.printf("Equation 2: 2.1x + 0.55y = %.4f%n", 2.1 * x + 0.55 * y);
    }
}
