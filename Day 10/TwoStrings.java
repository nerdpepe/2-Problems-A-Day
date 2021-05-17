import java.util.HashMap;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        String res = "NO";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<s1.length(); i++) {
            map.put(String.valueOf(s1.charAt(i)), 1);
        }

        for(int i =0; i<s2.length(); i++) {
            String key = String.valueOf(s2.charAt(i));
            if(map.containsKey(key)) {
                System.out.println(key);
                res = "YES"; break;
            }
        }
        return res;
    }

    public static void main(String ...arg) {
        String s1 = "art";
        String s2 = "end";
        System.out.println(twoStrings(s1, s2));
    }
}