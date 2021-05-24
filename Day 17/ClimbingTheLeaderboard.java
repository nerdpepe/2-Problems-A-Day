import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ClimbingTheLeaderboard {
    static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        int rank = 0; // to be inserted to the answer list
        List<Integer> rankList = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        int prev = -1;
        for (int i = 0; i < ranked.size(); i++) {
            int curr = ranked.get(i);
            if (curr != prev)
                numbers.add(curr);

            prev = curr;
        }

        // numbers -> final ranked
        int top = 0;
        int last = numbers.size() - 1;

        for (int i = 0; i < player.size(); i++) {
            int playerScore = player.get(i);
            boolean inserted = false;
            System.out.println("currentPlayer Score : " + playerScore);

            if (playerScore > numbers.get(top)) {
                rankList.add(1);
                numbers.set(0, playerScore);
                top = 0;
                last = 0;
            
            } else if(playerScore < numbers.get(last)) {
                numbers.add(playerScore);
                rankList.add(numbers.size());
                last = numbers.size()-1;
            } else {

                for(int j = last; j>top && !inserted; j--) {

                    System.out.println("currentPlayer Score : " + playerScore + " and Current number : " + numbers.get(j));

                    if(playerScore == numbers.get(j)) {
                        rank = j+1;
                        rankList.add(rank);
                        last = j;
                        inserted = true;
                    }

                    if(numbers.get(j) < playerScore && playerScore < numbers.get(j-1)) {
                        rank = j+1;
                        rankList.add(rank);
                        last = j;
                        numbers.set(j,playerScore);
                        inserted = true;
                    }

                }    

            }
        }

        return rankList;
    }

    public static void main(String... arg) {
        List<Integer> l = new ArrayList<>();
        l.add(100);
        l.add(90);
        l.add(90);
        l.add(80);
        l.add(75);
        l.add(60);
        //l.add(10);
        List<Integer> p = new ArrayList<>();
        p.add(50);
        p.add(65);
        p.add(77);
        p.add(90);
        p.add(102);
        // System.out.println(l);
        // System.out.println(p);
        System.out.println(climbingLeaderboard(l, p));
    }
}
/*
 * 6
100 90 90 80 75 60
5
50 65 77 90 102
 * 
 */
