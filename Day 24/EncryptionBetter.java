public class EncryptionBetter {
    static String encryption(String s) {
        String formatted = s.replace(" ", "");
        int len = formatted.length();
        
        double root = Math.sqrt(len);
        int row  = (int)Math.floor(root);
        int column = (int)Math.ceil(root);
        row = (row*column >= len)?row:column;
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i<column; i++) {
            for(int j = 0; j<row; j++) {
                int index = i + j*column;
                if(index < len) {
                    ans.append(formatted.charAt(index));
                }
            }
            if(i<column-1)
                ans.append(' ');
        }
        return ans.toString();
    }

    public static void main(String... arg) {
        String str = "feed the dog";
        System.out.print(encryption(str));
    }
}