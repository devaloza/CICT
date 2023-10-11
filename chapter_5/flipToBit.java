package chapter_5;

public class flipToBit {
    public static int flipBitToWin(int num) {
        
        String binaryStr = Integer.toBinaryString(num);
        int maxLength = 0;
        int currentLength = 0;
        int prevLength = 0;
        int flipLength = 0;

        for (char bit : binaryStr.toCharArray()) {
            if (bit == '1') {
                currentLength++;
                flipLength++;
            } else {
                prevLength = currentLength;
                currentLength = 0;
                flipLength++;
                if (flipLength > 1) {
                    flipLength = prevLength + 1;
                }
            }
            maxLength = Math.max(maxLength, flipLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int num = 1775;  // Binary: 11011101111
        int result = flipBitToWin(num);
        System.out.println(result);  // Output: 8 (Flipping the 0 at position 5 to 1 results in the longest sequence of 1s)
    }
}
