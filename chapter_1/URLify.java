package chapter_1;

public class URLify {
    public static void main(String[] args) {
        String str = "Mr John Smith   ";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str.strip().length(); i++) {
            if (str.charAt(i) !=' ') {
               sb.append(str.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        System.out.println(sb.toString());
    }
}