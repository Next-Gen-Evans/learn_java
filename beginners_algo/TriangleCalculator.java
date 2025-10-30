package beginners_algo;

import java.util.Scanner;

public class TriangleCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the side of the equilateral triangle: ");
        double sideLength = scanner.nextDouble();

        double area = (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);

        double volume = area * sideLength;

        System.out.printf("The area of the triangle is: %.2f%n", area);
        System.out.printf("The volume of the triangular prism is: %.2f%n", volume);

        scanner.close();
    }
}
