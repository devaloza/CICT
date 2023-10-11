package chapter_1;
import java.util.Arrays;

public class URLify_two {
    static void removeSpace(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i=0; i< trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
    int index = trueLength + spaceCount*2;
    System.out.println(index);
    if (trueLength < str.length) str[trueLength] = '\0';
        for (int i=trueLength - 1; i>=0; i--) {
            if (str[i] == ' ') {
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index-3;
            } else {
                str[index-1] = str[i];
                index--;
            }
        }
    }
    public static int getTrueStringLength(char[] chr) {
        for (int i = chr.length -1; i>=0; i--) {
            if (chr[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "Mr John Smith   ";
        char[] ch = str.toCharArray();
        int trueStrLen = getTrueStringLength(ch);
        System.out.println(trueStrLen);
        System.out.println(ch.length);
        removeSpace(ch, trueStrLen);
        System.out.println(Arrays.toString(ch));
    }
}