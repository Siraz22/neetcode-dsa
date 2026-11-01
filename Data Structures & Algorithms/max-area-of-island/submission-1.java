/*
"Carpe diem. Seize the day, boys. Make your lives extraordinary."
- John Keating, Dead Poets Society
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        int maxArea = 0;
        for(int i = 0;i<grid.length;++i){
            for(int j = 0;j<grid[0].length;++j){
                if(visited[i][j] == 1) continue;
                else if(grid[i][j] == 1){
                    int currArea = traverseBFS(grid, visited, i, j);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }

    public int traverseBFS(int[][] grid, int[][] visited, int i, int j){
        if(i == -1 || j == -1 || i >= grid.length || j>= grid[0].length) return 0;
        else if(visited[i][j] == 1) return 0;
        else if(grid[i][j] == 0) return 0;

        visited[i][j] = 1;
        
        return 1+traverseBFS(grid, visited, i, j+1) 
        + traverseBFS(grid, visited, i, j-1) 
        + traverseBFS(grid, visited, i+1, j) 
        + traverseBFS(grid, visited, i-1, j); 
    }
}