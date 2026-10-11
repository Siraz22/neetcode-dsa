/*
"Searching for someone to blame is such a pain."
—Satoru Gojo, Jujutsu Kaisen
*/

class Solution {
    int[] dp;

    public int recursion(int[] nums, int pos, int endPos) {
        if (pos >= endPos)
            return 0; //not valid position

        if(dp[pos] != -1) return dp[pos];

        //choice 1 : rob current, skips next 
        int rob1 = nums[pos] + recursion(nums, pos + 2, endPos);

        //choice 2 : don't rob, go to next 
        int rob2 = 0 + recursion(nums, pos + 1, endPos);

        dp[pos] = Math.max(rob1, rob2);
        return dp[pos];
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0]; //IMP

        dp = new int[nums.length];
        
        Arrays.fill(dp, -1);
        int firstRobbed = recursion(nums, 0, nums.length-1);
        
        Arrays.fill(dp, -1);
        int firstLeft = recursion(nums, 1, nums.length);

        return Math.max(firstRobbed, firstLeft);
    }
}