import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumPerformanceOfTeam {
    static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int modulo = 1000000007;
        long maxP = 0;
        long totalSpeed = 0;
        long res = 0;

        int[][] player = new int[n][2];
        for (int i = 0; i < n; i++) {
            player[i][0] = speed[i];
            player[i][1] = efficiency[i];
        }
        // efficiency and speed in decreasing order of efficiency
        Arrays.sort(player, (a, b) -> (b[1] - a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            // if true, that means we have to remove the element to add another
            if (pq.size() >= k)
                totalSpeed -= pq.poll();

            totalSpeed += player[i][0];
            pq.add(player[i][0]);
            res = totalSpeed * player[i][1];
            maxP = Math.max(maxP, res);
        }
        return (int)(maxP % modulo);
    }

    public static void main(String... arg) {
        int n = 6;
        int[] speed = new int[] { 2, 10, 3, 1, 5, 8 };
        int[] efficiency = new int[] { 5, 4, 3, 9, 7, 2 };
        int k = 1;
        int ans = maxPerformance(n, speed, efficiency, k);
        System.out.print(ans);
    }
}