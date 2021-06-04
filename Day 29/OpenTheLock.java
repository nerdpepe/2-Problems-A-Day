import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// we start from 0000 and we know the deadends as well as the target
// we use BFS
// we generate allowed-possible combination of lock. Which is +1 or -1 on ANY ONE WHEEL
// for example : for our root - 0000 (backward,forward)
// 9000,1000
// 0900,0100
// 0090,0010
// 0009,0001
// the above form a SINGLE Level in BFS
// Maintain [seen] so that you know you already saw the combination before

// if it reaches target -> good
// if the levels get exhausted -> RIP

public class OpenTheLock {
    static String moveWheel(String s, int pos, boolean direc) {
        char[] ch = s.toCharArray();
        int n = ch[pos] - '0';
        if(direc)
            n = (n+1)%10;
        else
            n = (n-1+10)%10;
        ch[pos] = String.valueOf(n).charAt(0);
        return new String(ch);
    }

    static int openLock(String[] deadends, String target) {
        HashSet<String> seen = new HashSet<>();
        for (String s : deadends)
            seen.add(s);
        if (seen.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        int size, turns = 0;
        String str;

        while (!queue.isEmpty()) {
            turns++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                str = queue.poll();
                for (int j = 0; j < 4; j++) {
                    String up = moveWheel(str, j, true);
                    String dw = moveWheel(str, j, false);
                    if (up.equals(target) || dw.equals(target))
                        return turns;
                    if (seen.add(up))
                        queue.add(up);
                    if (seen.add(dw))
                        queue.add(dw);
                }
            }
        }
        return -1;
    }

    public static void main(String... arg) {
        String[] deadends = new String[] { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        int turns = openLock(deadends, target);
        System.out.print(turns);
    }
}