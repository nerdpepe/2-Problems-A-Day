import java.util.List;
import java.util.ArrayList;

public class QueensAttackBetter {
    static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        if(n == 1)
            return 0;
        
        int movesInColumnRight = n-c_q;
        int movesInColumnLeft = c_q -1;

        int movesInRowUp = n-r_q;
        int movesInRowDown = r_q-1;

        int upLeftDiag = Math.min(Math.abs(n - r_q), Math.abs(1 - c_q));
        int upRightDiag = Math.min(Math.abs(n - r_q), Math.abs(n - c_q));
        int downLeftDiag = Math.min(Math.abs(1 - r_q), Math.abs(1 - c_q));
        int downRightDiag = Math.min(Math.abs(1 - r_q), Math.abs(n - c_q));

        int totalMoves = movesInColumnRight+ movesInColumnLeft + movesInRowUp + movesInRowDown + upLeftDiag + upRightDiag+ downLeftDiag + downRightDiag;

        if(obstacles.size() == 0)
            return totalMoves;
        
        for(List<Integer> l : obstacles) {
            int row = l.get(0);
            int col = l.get(1);

            //check if it present in column
            if(col == c_q) {
                if(row > r_q) {
                    int dist = row - r_q - 1;
                    movesInRowUp = Math.min(movesInRowUp, dist);
                } else {
                    int dist = r_q - row - 1;
                    movesInRowDown = Math.min(movesInRowDown, dist);
                }
            }

            // if in the same row
            if(row == r_q) {
                if(col > c_q) {
                    int dist = col - c_q - 1;
                    movesInColumnRight = Math.min(movesInColumnRight, dist);
                } else {
                    int dist = c_q - col - 1;
                    movesInColumnLeft = Math.min(movesInColumnLeft, dist);
                }
            }

            //left to right diag
            if( (row + col) == (r_q + c_q)) {
                if(row > r_q) {
                    int dist = row - r_q - 1;
                    upLeftDiag = Math.min(upLeftDiag, dist);
                } else {
                    int dist = r_q - row - 1;
                    downRightDiag = Math.min(downRightDiag, dist);
                }
            }
            //right to left diag
            if((row - r_q) == (col - c_q)) {
                if(row > r_q) {
                    int dist = row - r_q - 1;
                    upRightDiag = Math.min(upRightDiag, dist);
                } else {
                    int dist = r_q - row - 1;
                    downLeftDiag = Math.min(downLeftDiag, dist);
                }
            }
        }

        totalMoves = movesInColumnRight+ movesInColumnLeft + movesInRowUp + movesInRowDown + upLeftDiag + upRightDiag+ downLeftDiag + downRightDiag;
        return totalMoves;

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
        //int ans = queensAttack(100000, 0, 4187 , 5068, obstacles);
        System.out.println(ans);
    }
}