package chapter_1;

import CtCILibrary.AssortedMethods;

public class rotateImageAnticlockWise {
    public static void retateMatrixTwo(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        while (left < right) {
            for (int i = 0; i < (right - left); i++) {
                int top = left;
                int bottom = right;
                int temp = matrix[top][left+i];
                matrix[top][left+i] = matrix[top+i][right];
                matrix[top+i][right] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = temp;
            }
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[][] matrix1 = AssortedMethods.randomMatrix(4, 4, 1, 99);
        AssortedMethods.printMatrix(matrix1);
        System.out.println("------------------------");
        System.out.println();
        retateMatrixTwo(matrix1);
        System.out.println();
        AssortedMethods.printMatrix(matrix1);
    }
}
