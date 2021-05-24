import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class ClimbingTheLeaderboard {
    static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> rankList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<ranked.size(); i++) {
            if(stack.empty() || !(stack.peek().equals(ranked.get(i)))) {
                stack.push(ranked.get(i));
            }
        }

        for(int j = 0; j<player.size(); j++) {
            while(!stack.empty() && (player.get(j) >= stack.peek())) {
                stack.pop();
            }
            rankList.add(stack.size() + 1);
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
        List<Integer> p = new ArrayList<>();
        p.add(50);
        p.add(65);
        p.add(77);
        p.add(90);
        p.add(102);

        System.out.println(climbingLeaderboard(l, p));
    }
}