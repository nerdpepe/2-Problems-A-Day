import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {

    static List<Integer> process(String word){
        int num = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> pattern = new ArrayList<>();

        for(int i = 0; i<word.length(); i++) {
            char key = word.charAt(i);
            if(map.containsKey(key)) {
                int val = map.get(key);
                pattern.add(val);
            } else {
                map.put(key,num);
                pattern.add(num);
                num++;
            }
        }

        return pattern;
    }

    static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        List<Integer> patternProcessed = process(pattern);
        for(String word : words) {
            List<Integer> wordProcessed = process(word);
            if(patternProcessed.equals(wordProcessed))
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