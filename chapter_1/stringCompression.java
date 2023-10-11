package chapter_1;

public class stringCompression {
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (int i=0; i<str.length();i++) {
            if (i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
                counter++;
                continue;
            }
            sb.append(str.charAt(i));
            sb.append(counter);
            counter = 1;
        }
        return sb.length() < str.length() ? sb.toString() : str;
    }
    public static void main(String[] args) {
        String s1 = "aabcccccaaa";
        String s2 = "abcdefghi";
        System.out.println(compress(s1));
        System.out.println(compress(s2));
    }
}
