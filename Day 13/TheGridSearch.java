import java.util.List;
import java.util.ArrayList;

public class TheGridSearch {

    static boolean checkPlease(List<String> gridToFind, List<String> biggerGrid, int indexWhereFound, int lineInBigGridWhereFound) {
        boolean checked = true;
        int rowsInSmallGrid = gridToFind.size();

        for(int i = 0 ; i<rowsInSmallGrid; i++) {
            String whereToFind = biggerGrid.get(lineInBigGridWhereFound++);
            int index = whereToFind.indexOf(gridToFind.get(i));
            if(index!=indexWhereFound) {
                checked = false;
                break;
            }
        }
        return checked;
    }
    static String gridSearch(List<String> G, List<String> P) {
        boolean isSatisfied = false;

        for(int i = 0; i <P.size() && !isSatisfied; i++) {
            String toFind = P.get(i);
            for(int j = 0; j<G.size(); j++) {
                String line = G.get(j);
                int indexOfFoundString = line.indexOf(toFind);
               // System.out.println(line + " > " + indexOfFoundString);
                if(indexOfFoundString >= 0) {
                    isSatisfied = checkPlease(P, G, indexOfFoundString, j);
                 //   System.out.println(isSatisfied);
                }
                if(isSatisfied) {
                   // System.out.println("BREAK");
                    break;
                }
            }
        }

        if(!isSatisfied)
            return "NO";
        else
            return "YES";
    }
    
    public static void main(String ...arg) {
        //Bigger Grid
        List<String> G = new ArrayList<>();
        G.add("8988242643");
        G.add("3830589324");
        G.add("2229505813");
        G.add("5633845374");
        G.add("6473530293");
        G.add("7053106601");
        //Smaller Grid - to find in Bigger Grid G
        List<String> P = new ArrayList<>();
        P.add("9505");
        P.add("3845");
        P.add("3530");

        String ans = gridSearch(G,P);
        System.out.println(ans);

    }
}