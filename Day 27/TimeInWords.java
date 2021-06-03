public class TimeInWords {
    public static String timeInWords(int h, int m) {
        String[] words = new String[] { " o' clock", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half" };
                
        String min = "";
        if (m == 1)
            min = " minute";
        else if (m != 15 && m != 30)
            min = " minutes";

        if (m <= 30) {
            if (m == 0) {
                return words[h] + words[m];
            } else {
                return words[m] + min + " past " + words[h];
            }

        } else {
            m = 60 - m;
            h = h + 1;
            if (m != 15)
                return words[m] + min + " to " + words[h];
            else
                return words[m] + " to " + words[h];
        }
    }

    public static void main(String... args) {
        int h = 5;
        int m = 45;
        System.out.println(timeInWords(h, m));
    }
}