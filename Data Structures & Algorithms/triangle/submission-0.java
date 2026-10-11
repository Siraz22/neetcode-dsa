/*
"Thanks for the adventure. Now go have a new one." 
– Ellie, Up (Pixar)
*/

class Solution {
    int[][] dp;
    boolean[][] visited;

    public int recursion(List<List<Integer>> triangle, int x, int y){
        if(y == triangle.size()-1) return triangle.get(y).get(x);

        if (visited[y][x])
            return dp[y][x];
        
        int below = triangle.get(y).get(x) + recursion(triangle, x, y+1);
        int belowAd = triangle.get(y).get(x) + recursion(triangle, x+1, y+1);

        dp[y][x] = Math.min(below, belowAd);
        visited[y][x] = true;
        return dp[y][x];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        dp = new int[n][n];
        visited = new boolean[n][n];

        int answer = recursion(triangle, 0, 0);
        return answer;
    }
}