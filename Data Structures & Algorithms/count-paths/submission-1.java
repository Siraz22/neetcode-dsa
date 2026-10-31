/*
"तेरे बिना सोना पीतल
तेरे संग कीकर पीपल
आजा कटेना रतिया"
- Bin Tere, A.R. Rahman
*/

class Solution {
    int[][] memo;

    private int recursion(int row, int col, int m, int n){
        if(row < 0 || col < 0 || row >= m || col >= n)
            return 0;
        if(row == m-1 && col == n-1)
            return 1;
        if(memo[row][col]!=-1) return memo[row][col];
        
        int right = recursion(row, col+1, m, n);
        int down = recursion(row+1, col, m , n);
        memo[row][col] = right + down;
        return memo[row][col];
    }

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                memo[i][j] = -1;
            }
        }
        return recursion(0, 0, m, n);
    }
}