
public class Basic_TwoD {
    public static void main(String[] args) {
       
        int n = 2;
        int m = 2;

        int[][] arr = new int[n][m];

        int it = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = it;
                it++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
            System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
