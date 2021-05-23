public class DiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int leftDiag = 0;
        int rightDiag = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i == j)
                    leftDiag += arr.get(i).get(j);
                
                if((i + j) == n-1)
                    rightDiag += arr.get(i).get(j);
            }
        }
        return Math.abs(leftDiag - rightDiag);
    }

}