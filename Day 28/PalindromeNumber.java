public class PalindromeNumber {
    static boolean isPalindrome(int n) {
        if(n < 0)
            return false;
        if(n>=0 &&n<=9)
            return true;
        
        String num = Integer.toString(n);
        int len = num.length();
        for(int i = 0; i < len/2; i++) {
            if(num.charAt(i)!= num.charAt(len-i-1))
                return false;
        }

        return true;
    }

    public static void main(String... arg) {
        System.out.println(isPalindrome(78587));
        System.out.println(isPalindrome(78597));
        System.out.println(isPalindrome(7887));
    }
}