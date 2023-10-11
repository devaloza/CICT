package chapter_5;

public class conversion {
    public static int getNumber(int A, int B) {
        int result = A^B;
        int count = 0;
        while (result > 0) {
            count +=result & 1;
            result = result >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int A = 5; // Binary: 101
        int B = 3; // Binary: 011

        int bitsToFlip = getNumber(A, B);
        System.out.println(bitsToFlip); // Output: 2
    }
}
