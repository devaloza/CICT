package chapter_1;
import java.util.Arrays;

public class permutation {
    public static String stringSort(String inputs) {
        char stringToArray[] = inputs.toCharArray();
        Arrays.sort(stringToArray);
        return new String(stringToArray);
    }
    public static boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
		return stringSort(s).equals(stringSort(t));
	}	
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = anagram(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}   
    }
}
