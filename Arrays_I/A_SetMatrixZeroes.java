import java.util.Arrays;

public class A_SetMatrixZeroes {

    // T: O(N^3 + N^2), S: O(1)
    static void fillRow(int row, int matrix[][]) {
        for(int j=0; j<matrix[row].length; j++) {
            if(matrix[row][j] != 0) matrix[row][j] = -1;
        }
    }
    static void fillCol(int col, int matrix[][]) {
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][col] != 0) matrix[i][col] = -1;
        }
    }
    static void setZeroes_brute(int matrix[][]) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    fillRow(i, matrix);
                    fillCol(j, matrix);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void setZeroes_better(int matrix[][]) {
        int rows[] = new int[matrix.length];
        int cols[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(rows[i] != 0) {
                    matrix[i][j] = 0;
                }
                if(cols[j] != 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void main(String args[]) {
        int matrix[][] = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        // setZeroes_brute(matrix);
        setZeroes_better(matrix);
        for(int[] x: matrix) {
            System.out.println(Arrays.toString(x));
        }
    }
}