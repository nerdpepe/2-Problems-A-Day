public class MaxConsecutiveOnes {
    static int findMaxConsecutiveOnes(int[] nums) {
        int maxC = 0, consec = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                consec++;
            } else {
                maxC = Math.max(maxC, consec);
                consec = 0;
            }
        }
        maxC = Math.max(maxC, consec);
        return maxC;
    }

    public static void main(String... arg) {
        int arr[] = new int[] { 0, 1 };
        int ans = findMaxConsecutiveOnes(arr);
        System.out.print(ans);
    }
}