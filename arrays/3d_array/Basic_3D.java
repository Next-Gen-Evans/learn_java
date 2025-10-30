
public class Basic_3D {
    public static void main(String[] args) {
        int[][][] arr = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

        //Defining the x, y, z in multi dimensional array

        int n = arr.length;
        int m = arr[0].length;
        int o = arr[0][0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < o; k++) {
                    System.out.println("arr[" + i + "][" + j + "][" + k + "] = " + arr[i][j][k]);

                }
            }
        }
    }
}
