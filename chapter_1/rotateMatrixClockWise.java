package chapter_1;
import CtCILibrary.AssortedMethods;

public class rotateMatrixClockWise {
    public static boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length !=matrix[0].length) return false;
        int n = matrix.length;
        int layers = n/2;
        for (int layer=0; layer < layers; layer++) {
            int start = layer;
            int end = n - layer - 1;
            for (int i = start; i < end; i++) {
                int temp = matrix[start][i]; //save first element (top) in temp var
                matrix[start][i] = matrix[n-1-i][start]; // move left element into top
                matrix[n-1-i][start] = matrix[end][n-1-i]; // move bottom element into left
                matrix[end][n-1-i] = matrix[i][end]; // move right element into bottom
                matrix[i][end] = temp; // save temp element into right
            }
        }
        return true;
    }
    public static void retateMatrixTwo(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        while (left < right) {
            for (int i = 0; i < (right - left); i++) {
                int top = left;
                int bottom = right;
                int temp = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = temp;
            }
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[][] matrix1 = AssortedMethods.randomMatrix(3, 3, 0, 9);
        int[][] matrix2 = matrix1;
        AssortedMethods.printMatrix(matrix1);
        System.out.println("------------------------");
        rotateMatrix(matrix1);
        System.out.println();
        AssortedMethods.printMatrix(matrix1);
        retateMatrixTwo(matrix2);
        System.out.println();
        AssortedMethods.printMatrix(matrix2);
    }
}
