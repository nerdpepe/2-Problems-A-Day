import java.util.Arrays;
import java.util.HashMap;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {
        int count = 0;
        int len = s.length();
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            int j = 0;
            int c = len-i;
            while(c-- >0) {
                String subStr = s.substring(j++, s.length()-c);
                char[] arr = subStr.toCharArray();
                Arrays.sort(arr);
                subStr = String.valueOf(arr);
                if(map.containsKey(subStr)) {
                    int val = map.get(subStr);
                    count += val;
                    ++val;
                    map.put(subStr, val);
                }
                else
                    map.put(subStr, 1);
            }
        }
        return count;
    }
    public static void main(String ...arg) {
        String s = "cdcd";
        int ans = sherlockAndAnagrams(s);
        System.out.println(ans);
    }
}