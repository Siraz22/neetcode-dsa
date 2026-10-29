/*
"Science compels us to explode the sun"
- Pye, Outer Wilds
*/

class Solution
{
    public int numIslands(char[][] grid) 
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[0].length;++j)
            {
                if(visited[i][j]==true)
                {
                    continue;
                }
                else if(grid[i][j]=='1')
                {
                    ++islands;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j)
    {
        if(i >= grid.length || i==-1 || j>= grid[0].length || j==-1) return;
        if(visited[i][j] == true) return;
        if(grid[i][j] == '0') return;
        
        visited[i][j] = true;

        dfs(grid, visited, i,j+1);
        dfs(grid, visited, i,j-1);
        dfs(grid, visited, i+1,j);
        dfs(grid, visited, i-1,j);
    }
}