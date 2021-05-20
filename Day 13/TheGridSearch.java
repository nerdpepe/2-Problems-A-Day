import java.util.List;
import java.util.ArrayList;

// https://www.hackerrank.com/challenges/the-grid-search/problem
public class TheGridSearch {

    static boolean checkPlease(List<String> gridToFind, List<String> biggerGrid, int reqIndex,
            int lineInBigGrid) {
        boolean checked = true;
        for(int i=0,j=lineInBigGrid; i<gridToFind.size();i++,j++) {
            String line = biggerGrid.get(j);
            String toFind = gridToFind.get(i);
            int index = line.indexOf(toFind,reqIndex);
            if(index != reqIndex) {
                checked = false;
                break;
            }
        }
        return checked;
    }

    static String gridSearch(List<String> G, List<String> P) {
        int index = 0;
        String smallGridFirstLine = P.get(0);

        List<String> ListOfIndex = new ArrayList<>();

        for (int i = 0; i <= G.size() - P.size(); i++) {
            while (index != -1) {
                index = G.get(i).indexOf(smallGridFirstLine, index);
                if (index != -1) {
                    ListOfIndex.add(i + "," + index);
                    index++;
                }
            }
            index = 0;
        }
        for (String item : ListOfIndex) {
            String[] nums = item.split(",");
            int lineNumber = Integer.valueOf(nums[0]);
            int indexInLine = Integer.valueOf(nums[1]);
            boolean found = checkPlease(P, G, indexInLine, lineNumber);
            if(found)
                return "YES";
        }
        return "NO";
    }

    public static void main(String... arg) {
        // Bigger Grid
        List<String> G = new ArrayList<>();
        G.add("999999");
        G.add("121211");
       // G.add("123634");
       // G.add("781288");
        // Smaller Grid - to find in Bigger Grid G
        List<String> P = new ArrayList<>();
        P.add("99");
        P.add("11");

        String ans = gridSearch(G, P);
        System.out.println(ans);

    }
}