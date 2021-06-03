import java.util.Arrays;

public class MaxAreaOfPieceOfCake {
    static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int ans = 0;

        Arrays.sort(horizontalCuts);
        int h_n = horizontalCuts.length;
        int h_max = 0;

        if(horizontalCuts[0] - h_max > h - horizontalCuts[h_n-1])
            h_max = horizontalCuts[0] - h_max;
        else
            h_max = h - horizontalCuts[h_n-1];
        
        Arrays.sort(verticalCuts);
        int v_n = verticalCuts.length;
        int v_max = 0;

        if(verticalCuts[0] - v_max > w - verticalCuts[v_n-1])
            v_max = verticalCuts[0] - v_max;
        else
            v_max = w - verticalCuts[v_n-1];

        if(h_n > 1) {
            for(int i = 1; i<h_n; i++) {
                if(horizontalCuts[i] - horizontalCuts[i-1] > h_max)
                    h_max = horizontalCuts[i] - horizontalCuts[i-1];
            }
        }

        if(v_n > 1) {
            for(int i = 1; i < v_n; i++) {
                if(verticalCuts[i] - verticalCuts[i-1] > v_max)
                    v_max = verticalCuts[i] - verticalCuts[i-1];
            }

        }
        ans = (int)((long)h_max * v_max % 1000000007);
        return ans;
    }

    public static void main(String... arg) {
        int h = 5;
        int w = 4;
        int[] hor = new int[] { 3 };
        int[] ver = new int[] { 3 };
        System.out.println(maxArea(h, w, hor, ver));
    }
}