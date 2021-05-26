import java.util.HashMap;

public class NRepeatedElements {
    static int repeatedNTimes(int[] nums) {
        int ans = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            } else {
                    // means the elements is present there more than once 
                    // return that value
                    ans = nums[i];
                    break;
                }
            }
        return ans;
    }

    public static void main(String ...arg) {
        int[] nums = new int[]{5,1,5,2,5,3,5,4};
        int ans = repeatedNTimes(nums);
        System.out.println(ans);
    }
}