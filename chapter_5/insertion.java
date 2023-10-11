package chapter_5;

public class insertion {
    public static void main(String[] args) {
        int n = ~23423;
        int m = 5;
        int i= 2;
        int j = 6;
        System.out.println(getModifiedString(n,m,i,j));
    }
    private static int getModifiedString(int n, int m ,int i, int j) {
    int all1 = ~0;
    int clearmask = all1 << (j+1);
    clearmask = clearmask >> i;
    n = n & clearmask;
    m = m << i;
    return n | m;
    }
}
