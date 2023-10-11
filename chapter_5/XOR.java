package chapter_5;

public class XOR {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,2,1,5};
        System.out.println(unique(arr));
    }
    private static int unique(int[] arr) {
        int unique = 0;
        for (int num: arr) {
            unique ^=num;
        }
        return unique;
    }
}
