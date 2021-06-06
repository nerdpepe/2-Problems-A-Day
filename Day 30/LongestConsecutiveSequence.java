import java.util.Arrays;

public class LongestConsecutiveSequence {
    static int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;

        int consec = 1;
        int max_c = 1;
        Arrays.sort(nums);

        for(int i = 1; i<nums.length; i++) {
            if(nums[i] == nums[i-1] + 1) {
                consec++;
                max_c = Math.max(consec, max_c);
            } else if(nums[i] == nums[i-1]) {
                continue;
            } else 
                consec = 1;
        }
        
        return max_c;
    }

    public static void main(String ...args) {
        int[] nums = new int[]{1,2,0,1};
        System.out.print(longestConsecutive(nums));
    }
}