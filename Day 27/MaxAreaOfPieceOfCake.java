import java.util.Arrays;

public class MaxAreaOfPieceOfCake {
    static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        int h_n = horizontalCuts.length;
        int h_max = Math.max(horizontalCuts[0], h - horizontalCuts[h_n - 1]);

        Arrays.sort(verticalCuts);
        int v_n = verticalCuts.length;
        int v_max = Math.max(verticalCuts[0], w - verticalCuts[v_n - 1]);

        for (int i = 1; i < h_n; i++)
            h_max = Math.max(h_max, horizontalCuts[i] - horizontalCuts[i - 1]);

        for (int i = 1; i < v_n; i++)
            v_max = Math.max(v_max, verticalCuts[i] - verticalCuts[i - 1]);

        return (int) ((long) h_max * v_max % 1000000007);
    }

    public static void main(String... arg) {
        int h = 5;
        int w = 4;
        int[] hor = new int[] { 3 };
        int[] ver = new int[] { 3 };
        System.out.println(maxArea(h, w, hor, ver));
    }
}