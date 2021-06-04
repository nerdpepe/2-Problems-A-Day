import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaximumPerformanceOfTeam {
    static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int modulo = 1000000007;
        int maxP = 0;

        // answer
        return maxP;
    }

    public static void main(String... arg) {
        int n = 6;
        int[] speed = new int[] { 2, 10, 3, 1, 5, 8 };
        int[] efficiency = new int[] { 5, 4, 3, 9, 7, 2 };
        int k = 2;
        int ans = maxPerformance(n, speed, efficiency, k);
        System.out.print(ans);
    }
}