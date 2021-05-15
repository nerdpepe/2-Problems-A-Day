import java.util.ArrayList;

public class AllBallsToEachBox {
    static int[] minOperations(String boxes) {
        int boxesLen = boxes.length();
        int[] ansArr = new int[boxesLen];
        ArrayList<Integer> ones = new ArrayList<>();
        int moves;

        //store the positions where '1' i.e a ball is present
        // O(n)
        for(int i = 0; i<boxesLen; i++) {
            if(boxes.charAt(i) == '1')
                ones.add(i);
        }

        for(int j = 0; j<boxesLen; j++) {
            moves = 0;
            for(int k = 0; k<ones.size(); k++) {
                moves += Math.abs(j-ones.get(k));
            }
            ansArr[j] = moves;
        }

        return ansArr;
    }

    public static void main(String ...arStrings) {
        String boxes = "001011";
        int[] ans = minOperations(boxes);
        for(int n : ans)
         System.out.print(n);
    }
}