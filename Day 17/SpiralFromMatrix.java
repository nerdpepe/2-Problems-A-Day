public class SpiralFromMatrix {
    //TODO implement UP, DOWN , LEFT, RIGHT checks
    static boolean checkNextInRow(int i , int j, int[][] arr) {
        if(i<arr.length && j+1 <arr.length) {
            if(arr[i][j+1] != -1) {
                return true;
            } else
                return false;
        }
        else
            return false;
    }
    static void spiral(int[][] arr) {
        int n = arr.length*arr.length;
        int i = 0; //row
        int j = -1; //column
        
        while( n-- > 0) {
            if(checkNextInRow(i,j, arr)) {
                j++;
                System.out.println("(" + i + "," + j + ")"+ arr[i][j]);
                arr[i][j] = -1;
            } else {
                i++;
                System.out.println("(" + i + "," + j + ")"+ arr[i][j]);
            }
            
        }
    }
    public static void main(String ... arg) {
        int [][] arr = new int[][]{{1,2,3},{8,9,4}, {7,6,5}};
        spiral(arr);
        /* 
        for(int i = 0; i < 3; i++)
            for(int j = 0; j<3; j++)
                System.out.println(arr[i][j]);
        */
    }
}