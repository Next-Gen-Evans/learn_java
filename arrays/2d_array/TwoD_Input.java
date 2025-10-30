import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoD_Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of rows: ");
            int row = sc.nextInt();


        System.out.print("Enter number of columns: ");
        int col = sc.nextInt();

        if (row <= 0 || col <= 0 || row != col) {
            System.out.println("Error: Number of rows and columns must be correct");
            return;
        }
        int[][] arr = new int[row][col];

        System.out.println("Enter elements of array:");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Elements of array are:");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        } catch (NegativeArraySizeException e) {
            System.out.println("Error: Array dimensions cannot be negative.");
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getLocalizedMessage());
        } finally {
            sc.close();
        }

    }
}
