public class Encryption {
    static String encryption(String s) {
        String formatted = s.replace(" ", "");
        int len = formatted.length();
        
        double root = Math.sqrt(len);
        int row  = (int)Math.floor(root);
        int column = (int)Math.ceil(root);
        row = (row*column >= len)?row:column;
        char[][] arr = new char[row][column];
        StringBuilder ans = new StringBuilder();
        int k = 0;
        for(int i = 0; i <row; i++) {
            for(int j = 0; j < column; j++) {
                if(k<formatted.length())
                    arr[i][j] = formatted.charAt(k++);
                else
                    arr[i][j] = ' ';
            }
        }
        for(int i = 0; i<column; i++) {
            for(int j = 0; j<row; j++) {
             if(arr[j][i]- ' ' != 0)
                ans.append(arr[j][i]);   
            }
            if(i<column-1)
              ans.append(" ");
        }

        return ans.toString();
    }

    public static void main(String... arg) {
        String str = "feed the dog";
        System.out.print(encryption(str));
    }
}