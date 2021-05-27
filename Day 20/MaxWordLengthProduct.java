import java.util.ArrayList;
import java.util.List;

public class MaxWordLengthProduct {

    static void createBitReps(String word, List<String> list) {
        String initial = "00000000000000000000000000";
        char[] arr = initial.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            arr[ch - 'a'] = '1';
        }
        list.add(String.valueOf(arr));
    }

    static int maxProduct(String[] words) {
        int max = 0;
        List<String> bitRepList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            createBitReps(words[i], bitRepList);
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean isCommon = false;
                for (int k = 0; k < 26; k++) {
                    if (bitRepList.get(i).charAt(k) == '1' && bitRepList.get(j).charAt(k) == '1') {
                        isCommon = true;
                        break;
                    }
                }

                if (!isCommon)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }

    public static void main(String... arg) {
        int ans;
        String[] words = new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        ans = maxProduct(words);
        System.out.print("Output: -" + ans);
    }
}