import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _3DSurfaceArea {
    static int surfaceArea(List<List<Integer>> A) {
        int area = A.size() * A.get(0).size() * 2;
        int row = A.size() + 2;
        int column = A.get(0).size() + 2;

        // padding the surroundings by 0
        int[][] mat = new int[row][column];
        for (int i = 1, k = 0; k < row - 2; i++, k++) {
            for (int j = 1, l = 0; l < column - 2; j++, l++) {
                mat[i][j] = A.get(k).get(l);
            }
        }
        // Suppose if a guy goes on top of a cell and sees around in E-W-N-S direction
        // to check if
        // he can measure the height by langing a measuringTape (he can't if he is lower
        // than the surroundings )
        for (int i = 1; i <= row - 2; i++) {
            for (int j = 1; j <= column - 2; j++) {
                area += Math.max(0, mat[i][j] - mat[i + 1][j]);
                area += Math.max(0, mat[i][j] - mat[i - 1][j]);
                area += Math.max(0, mat[i][j] - mat[i][j + 1]);
                area += Math.max(0, mat[i][j] - mat[i][j - 1]);
            }
        }

        return area;
    }

    public static void main(String... arg) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(4);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(2);
        b.add(3);
        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(4);

        List<List<Integer>> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        System.out.print(surfaceArea(l));
    }
}