/*
"Uncertain of his sister's fate, a boy enters Limbo."
- Limbo
*/

class Solution {

    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public void recursion(int[][] heights, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length)
            return;
        if (visited[row][col])
            return;

        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < heights.length && 
                    newCol >= 0 && newCol < heights[0].length &&
                    heights[newRow][newCol] >= heights[row][col]) {
                recursion(heights, visited, newRow, newCol);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited_a = new boolean[n][m];
        boolean[][] visited_p = new boolean[n][m];

        for (int i = 0; i < m; i++)
            recursion(heights, visited_p, 0, i);

        for (int i = 1; i < n; i++)
            recursion(heights, visited_p, i, 0);

        for (int i = 0; i < m; i++)
            recursion(heights, visited_a, n - 1, i);

        for (int i = 0; i < n - 1; i++)
            recursion(heights, visited_a, i, m - 1);

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited_a[i][j] && visited_p[i][j])
                    answer.add(Arrays.asList(i, j));
            }
        }

        return answer;
    }
}