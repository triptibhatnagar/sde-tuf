import java.util.Arrays;

public class A_SetMatrixZeroes {

    // T: O(MN^2+ NM^2 + N*M), S: O(1)
    static void fillRow(int row, int matrix[][]) {
        for(int j=0; j<matrix[row].length; j++) {
            if(matrix[row][j] != 0) matrix[row][j] = Integer.MIN_VALUE;
        }
    }
    static void fillCol(int col, int matrix[][]) {
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][col] != 0) matrix[i][col] = Integer.MIN_VALUE;
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
                if(matrix[i][j] == Integer.MIN_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // T: O(N*M + N*M), S: O(N+M)
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

    // T: O((N*M) + (N-1 * M-1) + N + M), S: O(1)
    static void setZeroes_opt(int matrix[][]) {
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if(j == 0) {
                        col0 = 0;
                    }else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String args[]) {
        int matrix[][] = {
            {0,1,2,0},
            {3,4,-1,2},
            {1,3,1,5}
        };
        setZeroes_brute(matrix);
        // setZeroes_better(matrix);
        // setZeroes_opt(matrix);
        for(int[] x: matrix) {
            System.out.println(Arrays.toString(x));
        }
    }
}