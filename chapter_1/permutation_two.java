package chapter_1;

public class permutation_two {
    static boolean is_permutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int letters[] = new int[128];
        for (int i=0; i<s1.length(); i++){
            letters[s1.charAt(i)]++;
        }
        for (int j=0; j<s2.length(); j++){
            letters[s2.charAt(j)]--;
            if (letters[s2.charAt(j)] < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = is_permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
    }
}
