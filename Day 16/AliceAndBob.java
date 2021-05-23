public class AliceAndBob {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<a.size(); i++) {
            if(a.get(i)>b.get(i))
                alice++;
            else if(a.get(i)<b.get(i))
                bob++;
        }
        ans.add(alice);
        ans.add(bob);
        return ans;
    }

}