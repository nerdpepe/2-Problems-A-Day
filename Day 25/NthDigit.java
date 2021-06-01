public class NthDigit {
    static int findNthDigit(int n) {
        int numberOfDigits = 1;
        long multiplier = 9; //long -> important
        int base = 1;
        while (n - (numberOfDigits * multiplier) > 0) {
            n -= numberOfDigits * multiplier;
            numberOfDigits++;
            multiplier *= 10;
            base *= 10;
        }

        int numberContainingOurDigit = base + (n - 1) / numberOfDigits;
        char c = String.valueOf(numberContainingOurDigit).charAt((n - 1) % numberOfDigits);
        return c - '0';
    }

    public static void main(String... arg) {
        System.out.print(findNthDigit(2147483647));
    }
}