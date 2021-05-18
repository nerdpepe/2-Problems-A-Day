import java.util.*;

public class DecompressEncodedList {

    static int[] decompressRLElist(int[] nums) {

        List<Integer> l = new ArrayList<>();
        for(int i = 0; i<nums.length; i += 2) {
            for(int j = 1; j <= nums[i]; j++) {
                l.add(nums[i+1]);
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i<l.size(); i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }

    public static void main(String ... arg) {
        int[] nums = new int[]{2,5};
        int[] ans = decompressRLElist(nums);
        for(int i : ans)
            System.out.println(i);
    }
}