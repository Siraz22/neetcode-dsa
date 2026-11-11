/*
"I am sworn to carry your burdens." 
— Lydia, Elder Scrolls V : Skyrim
*/

class Solution {

    int[] memo;
    private int recursion(int[] coins, int amount){
        //base condition
        if(amount == 0){
            return 0;
        }
        
        if (memo[amount] != -1)
            return memo[amount];

        int minVal = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin > amount)
                continue;
            else{
                int result = recursion(coins, amount - coin);

                if (result != Integer.MAX_VALUE) {
                    int count = 1 + result;
                    minVal = Math.min(minVal, count);
                }
            }
        }
        return memo[amount] = minVal;
    }

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        
        int answer = recursion(coins, amount);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}