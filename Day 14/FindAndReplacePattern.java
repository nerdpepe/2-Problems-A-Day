import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FindAndReplacePattern {
    
    static boolean wordAndpattern(String word, String pattern) {
        boolean result = true;
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        for(int i = 0; i<word.length() && result == true ; i++) {
            String k = String.valueOf(word.charAt(i));
            String v = String.valueOf(pattern.charAt(i));
            if(map.containsKey(k)) {
                if(!map.get(k).equals(v)) {
                    result = false;
                }
            } else {
                map.put(k, v);
                if(map2.containsKey(v))
                    result = false;
                else
                    map2.put(v, k);
            }
        }
        return result;
    }
    
    static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<String>();
        for(String word : words) {
            if(wordAndpattern(word,pattern))
                ans.add(word);
        }
        return ans;
    }

    public static void main(String ...arg) {
        String[] words = new String[]{"abc","deq","mee","aqq"};
        String pattern = "abb";
        List<String> ans = findAndReplacePattern(words, pattern);
        System.out.println(ans);
    }
}