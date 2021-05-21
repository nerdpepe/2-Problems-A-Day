import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MarkAndToys {

    public static int maximumToys(List<Integer> prices, int k) {
        int count = 0;
        int[] pricesArr = new int[prices.size()];
        pricesArr = prices.stream().mapToInt(i -> i).toArray();
        Arrays.sort(pricesArr);
        int i = 0;
        while(k>0) {
            if(k >= pricesArr[i]) {
                //System.out.println(k + " ->" + pricesArr[i]);
                k -= pricesArr[i];
                count++;
                i++;
            } else
                break;
        }
        return count;
    }

    public static void main(String... arg) {
        List<Integer> prices = new ArrayList<>();
        prices.add(10);
      /*  prices.add(12);
        prices.add(5);
        prices.add(111);
        prices.add(200);
        prices.add(1000);
        prices.add(10); */
        int ans = maximumToys(prices, 1);
        System.out.println(ans);
    }
}