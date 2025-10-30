import java.util.Scanner;

public class TwoD_Runtime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = s.nextInt();

        int[][] arr = new int[n][];
        int t = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of columns for row " + i + ": ");
            int m = s.nextInt();
            t = m;
            arr[i] = new int[m];

            System.out.println("Enter " + m + " elements for row " + i + ":");
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        int odd = 0, even = 0;

        System.out.println("Rows: " + n + " with " + t + " columns ");
        System.out.println("Elements of Array:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            System.out.println();
        }

        System.out.println("Even: " + even + ", Odd: " + odd);
        s.close();
    }
}
