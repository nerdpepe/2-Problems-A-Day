import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class RansomNote {
    
    static void checkMagazine(List<String> magazine, List<String> note) {
        HashMap<String, Integer> mag = new HashMap<>();
        for(int i = 0; i<magazine.size(); i++) {
            String word = magazine.get(i);
            if(mag.containsKey(word)) {
                Integer count = mag.get(word);
                count++;
                mag.put(word,count);
            } else {
                mag.put(word,1);
            }
        }
        boolean possible = true;
        for(int i = 0; i<note.size(); i++) {
            String word = note.get(i);
            
            if(mag.containsKey(word) && mag.get(word)>0) {
                    Integer count = mag.get(word);
                    --count;
                    mag.put(word,count);
                } else {
                    possible = false;
                    break;
                }
        }

        if(possible)
            System.out.println("Yes");
        else
            System.out.println("No");
        
    }
    
    public static void main(String ...arg) {
        ArrayList<String> magazine = new ArrayList<>();
        magazine.add("give");
        magazine.add("me");
        magazine.add("one");
        magazine.add("grand");
        magazine.add("today");

        ArrayList<String> note = new ArrayList<>();
        note.add("give");
        note.add("me");
        note.add("grand");
        note.add("please"); 
        note.add("grand"); //-> should print "No" as 'grand' has already been used once
        
        checkMagazine(magazine,note);
    }
}