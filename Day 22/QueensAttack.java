import java.util.List;
import java.util.ArrayList;

public class QueensAttack {

    static int rightToLeftDiagonalMoves(int n, int r_q, int c_q, int[][] mat) {
        int moves = 0;
        // to upper right
        int row = r_q - 1;
        int col = c_q + 1;
        while( (row >= 0 && col<n) && mat[row][col]!=-1) {
            moves++;
            row--;
            col++;
        }

        //to lower left
        row = r_q + 1;
        col = c_q - 1;
        while((row < n && col >= 0) && mat[row][col]!=-1) {
            moves++;
            row++;
            col--;
        }

        return moves;
    }

    static int leftToRightDiagonalMoves(int n, int r_q, int c_q, int[][] mat) {
        int moves = 0;
        // to upper left
        int row = r_q - 1;
        int col = c_q - 1;
        while( (row >= 0 && col>=0) && mat[row][col]!=-1) {
            moves++;
            row--;
            col--;
        }

        //to lower right
        row = r_q + 1;
        col = c_q + 1;
        while((row < n && col < n) && mat[row][col]!=-1) {
            moves++;
            row++;
            col++;
        }

        return moves;
    }

    static int colMoves(int n, int r_q, int c_q, int[][] mat) {
        int moves = 0;
        // from queen to up
        for (int i = c_q - 1; i >= 0; i--) {
            if (mat[r_q][i] != -1)
                moves++;
            else
                break;
        }
        // from queen to down
        for (int i = c_q + 1; i < n; i++) {
            if (mat[r_q][i] != -1)
                moves++;
            else
                break;
        }
        return moves;
    }

    static int rowMoves(int n, int r_q, int c_q, int[][] mat) {
        int moves = 0;
        // from queen to up
        for (int i = r_q - 1; i >= 0; i--) {
            if (mat[i][c_q] != -1)
                moves++;
            else
                break;
        }
        // from queen to down
        for (int i = r_q + 1; i < n; i++) {
            if (mat[i][c_q] != -1)
                moves++;
            else
                break;
        }
        return moves;
    }

    static int[][] transformToFriendly(List<List<Integer>> obs, int size) {
        int[][] mat = new int[size][size];
        for (int i = 0; i < obs.size(); i++) {
            int row = size - obs.get(i).get(0);
            int col = obs.get(i).get(1) - 1;
            mat[row][col] = -1;
        }

        /*
         * System.out.println(size);
         * 
         * for(int i = 0; i < size; i++){ for(int j = 0; j < size; j++) {
         * System.out.print(mat[i][j] + " "); } System.out.print("\n"); }
         */
        return mat;
    }

    static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int moves = 0;
        int[][] matrix = transformToFriendly(obstacles, n);
        r_q = n - r_q;
        c_q--;

        // (i-1,j) , (i+1,j)
        int rowCount = rowMoves(n, r_q, c_q, matrix);
        //System.out.println(rowCount);
        // (i,j-1) , (i,j+1)
        int colCount = colMoves(n, r_q, c_q, matrix);
       // System.out.println(colCount);
        // (i-1,j-1) , (i+1,j+1)
        int leftToRightCount = leftToRightDiagonalMoves(n, r_q, c_q, matrix);
       // System.out.println(leftToRightCount);
        // (i-1,j+1) , (i+1,j-1)
        int rightToLeftCount = rightToLeftDiagonalMoves(n, r_q, c_q, matrix);
        moves = rowCount + colCount + leftToRightCount + rightToLeftCount;
        return moves;
    }

    public static void main(String... args) {
        int n = 5, k = 3;
        int r_q = 4, c_q = 3;
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(5);
        l1.add(5);
        List<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(3);
        obstacles.add(l1);
        obstacles.add(l2);
        obstacles.add(l3);
        int ans = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(ans);
    }
}