/*
"Oh, sometimes I get a good feeling"
- Levels, Avicii
*/

class Solution {
    int[] dp;

    public int recursion(int[] nums, int pos){
        if(pos >= nums.length) return 0; //no house to rob from
        if(dp[pos]!=-1) return dp[pos];

        //choice 1 : rob current, skip next
        int rob1 = nums[pos] + recursion(nums, pos+2);

        //choice 2 : don't rob, go to next
        int rob2 = 0 + recursion(nums, pos+1);

        dp[pos] = Math.max(rob1, rob2);
        return dp[pos];
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        for(int i=0;i<nums.length;++i)
            dp[i] = -1;

        return recursion(nums, 0);
    }
}