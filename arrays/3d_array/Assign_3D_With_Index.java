public class Assign_3D_With_Index {
    public static void main(String[] args) {
        int[][][] arr = new int[2][2][2];

        int n=arr.length;
        int m=arr[0].length;
        int o=arr[0][0].length;

        int it=1;

        //Assigning the values to Array
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                for (int k = 0; k<o; k++) {
                    arr[i][j][k] = it;
                    it++;
                }
            }
        }
    
        // Printing the Array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < o; k++) 
                    System.out.print(arr[i][j][k] + " ");
                    System.out.println();
                }
                System.out.println();
            }
        }
    }

