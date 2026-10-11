/*
"Carpe diem. Seize the day, boys. Make your lives extraordinary."
- John Keating, Dead Poets Society
*/

class Solution {
    int[] memo;

    public int recursion(int[] cost, int pos){
        if(pos == 0) return cost[0]; //we can pay this and reach top
        if(pos == 1) return cost[1]; //we can pay this and reach top

        if(memo[pos] != -1) return memo[pos];

        int step1 = cost[pos] + recursion(cost, pos-1);
        int step2 = cost[pos] + recursion(cost, pos-2);

        memo[pos] = Math.min(step1, step2);
        return memo[pos];
    }

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        for(int i=0;i<memo.length;++i)
            memo[i] = -1;

        int startFrom0 = recursion(cost, cost.length-1);
        int startFrom1 = recursion(cost, cost.length-2);
        return Math.min(startFrom0, startFrom1);
    }
}