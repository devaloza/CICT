package chapter_1;
import CtCILibrary.AssortedMethods;

public class zeroMatrixTwo {
    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
        AssortedMethods.printMatrix(matrix);
        createZeroMatrix(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
    public static void createZeroMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowHasZero = false;
        boolean colHasZero = false;
        //Check first row has zero
        for (int j=0; j<cols; j++) {
            if (matrix[0][j] ==0){
                rowHasZero = true;
                break;
            }
        }
        for (int i=0; i<rows; i++) {
            if (matrix[i][0] ==0){
                colHasZero = true;
                break;
            }
        }
        for (int i = 1; i< rows; i++){
            for (int j=1; j< cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i< rows; i++) {
            if (matrix[i][0]== 0){
                nullifyRowMatrix(matrix, i);
            }
        }
        for (int j=1; j< cols; j++) {
            if (matrix[0][j] == 0){
                nullifyColumnMatrix(matrix, j);
            }
        }
    }
    public static void nullifyRowMatrix(int[][] matrix, int i){
        for (int j = 0; j< matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }
    public static void nullifyColumnMatrix(int[][] matrix, int i){
        for (int j = 0; j< matrix.length; j++) {
            matrix[j][i] = 0;
        }
    }
}
