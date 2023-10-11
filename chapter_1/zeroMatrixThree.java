package chapter_1;
import CtCILibrary.AssortedMethods;

public class zeroMatrixThree {
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

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if(matrix[i][j] ==0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i=1; i< rows; i++) {
            for (int j=1; j<cols; j++) {
                if (matrix[i][0]== 0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
