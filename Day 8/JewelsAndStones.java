//https://leetcode.com/problems/jewels-and-stones/

public class JewelsAndStones {

    static int numJewelsInStones(String jewels, String stones) {
        int numJewels = 0;
        for(int i = 0; i<stones.length(); i++) {
            for(int j = 0; j<jewels.length(); j++)
                if(jewels.charAt(j) == stones.charAt(i))
                    numJewels++;
        }
        return numJewels;
    }

    public static void main(String ...arStrings) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int ans = numJewelsInStones(jewels, stones);
        System.out.print(ans);
    }
}