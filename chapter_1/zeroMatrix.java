package chapter_1;
import CtCILibrary.AssortedMethods;

public class zeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
        AssortedMethods.printMatrix(matrix);
        createZeroMatrix(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
    public static void createZeroMatrix(int[][] matrix) {
        int[] rowArray = new int[matrix.length];
        int[] colArray = new int[matrix[0].length];
        for (int i=0; i< matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowArray[i] = 1;
                    colArray[j] = 1;
                }
            }
        }
        for (int i=0; i< rowArray.length; i++) {
            if (rowArray[i] == 1){
                nullifyRowMatrix(matrix, i);
            }
        }
        for (int j=0; j< colArray.length; j++) {
            if (colArray[j] == 1){
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
