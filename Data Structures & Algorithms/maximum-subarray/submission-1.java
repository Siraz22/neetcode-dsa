/*
"You can't be everything you wanna be before your time
Although it's so romantic on the borderline tonight, tonight"
- Billy Joel, Vienna
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;++i){
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);

            if(currSum < 0){
                currSum = 0;
            }
        }

        return maxSum;
    }
}