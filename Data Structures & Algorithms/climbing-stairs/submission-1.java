/*
“Just keep swimming.”
- Dory, Finding Nemo
*/

class Solution {
    int[] map;

    public int recursion(int n){
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(map[n] != -1) return map[n];
        
        map[n] = recursion(n-1) + recursion(n-2);
        return map[n];
    }

    public int climbStairs(int n) {
        map = new int[n+1];
        for(int i=0;i<n+1;++i)
            map[i] = -1;
        
        return recursion(n);
    }
}