import java.util.Arrays;

public class BiggerIsGreater {
    static String biggerIsGreater(String w) {
        boolean found = false;
        String ans = "";
        int len = w.length();
        char arr[] = w.toCharArray();
        int i;
        for (i = len - 1; i >= 1; i--) {
            if (arr[i] > arr[i - 1]) {
                found = true;
                break;
            }
        }

        // i-1 points to the number
        int pos = i - 1;
        int loc = i;

        if (!found)
            return "no answer";

        
        for (int j = pos + 1; j <= len - 1; j++) {
            if (arr[pos] < arr[j]) {
                loc = j;
            }
        }

        char ch = arr[pos];
        arr[pos] = arr[loc];
        arr[loc] = ch;

        // sort from i to len (exclusive)
        Arrays.sort(arr, i, len);
        ans = new String(arr);
        return ans;
    }

    public static void main(String... arg) {
        System.out.println(biggerIsGreater("bb"));
        System.out.println(biggerIsGreater("hefg"));
        System.out.println(biggerIsGreater("dhck"));
        System.out.println(biggerIsGreater("dkhc"));
        System.out.println(biggerIsGreater("lmno"));
    }
}