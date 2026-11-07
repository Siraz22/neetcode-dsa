/*
"Ve sone diya kangana
Ve sauda ekko dheya
Dil dena te dil mangana
Ve sauda ekko dheya"
- Niraj Chag, Bangles
*/

class Solution {    
    boolean[][] visited;

    public int dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return 1;
        if(grid[row][col] == 0)
            return 1;
        if(visited[row][col])
            return 0;
        
        visited[row][col] = true;
        int left = dfs(grid, row, col-1);
        int right = dfs(grid, row, col+1);
        int down = dfs(grid, row+1, col);
        int up = dfs(grid, row-1, col);

        return left + right + down + up;
    }

    public int islandPerimeter(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
}