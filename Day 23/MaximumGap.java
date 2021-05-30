public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int maxDifference = 0;
        for(int i = 1; i <nums.length; i++) {
            if(nums[i] - nums[i-1] > maxDifference)
                maxDifference = nums[i] - nums[i-1];
        }
        return maxDifference;
    }
}