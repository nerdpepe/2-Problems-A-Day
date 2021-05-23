import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class TargetArrayGivenOrder {
    
    static int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
        List<Integer> l = new ArrayList<>(Collections.nCopies(nums.length, 0));
        for(int i = 0; i<nums.length; i++) {
            l.set(index[i], nums[i]);
        }
        ans = l.stream().mapToInt(i -> i).toArray();
        return ans;
    }
    
    public static void main(String... arg) {
        int[] nums = new int[]{0,1,2,3,4};
        int[] index = new int[]{1,0,2,2,1};
        int[] ans = createTargetArray(nums, index);
        for(int i : ans)
            System.out.println(i);
    }
}