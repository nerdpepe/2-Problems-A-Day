import java.util.Scanner;

public class StringIntroduction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length() + B.length());
        String ans = ( A.compareTo(B) > 0 )?"Yes":"No";
        System.out.println(ans);
        char[] ch1 = A.toCharArray();
        char[] ch2 = B.toCharArray();
        ch1[0] = Character.toUpperCase(ch1[0]);
        ch2[0] = Character.toUpperCase(ch2[0]);
        System.out.print(new String(ch1) + " " + new String(ch2));
        sc.close();
    }
}