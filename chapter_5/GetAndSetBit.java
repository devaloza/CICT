package chapter_5;

public class GetAndSetBit {
    public static boolean getBits(int num, int i) {
        return ((num & (1 << i)) !=0);
    }

    public static void main(String[] args) {
        System.out.println(getBits(10, 5));
        System.out.println(setBits(10, 5));
    }
    public static int setBits(int num, int i) {
        return ((num | (1<<i)));
    }
}
