/*
"What does that make me? God of fools."
- Kratos, God of War Ragnarök
*/

class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] connectedToEdge = new boolean [n][m];
        
        //top
        for(int i=0;i<m;++i)
            if(board[0][i]=='O')
                dfs(board,connectedToEdge,0,i);

        //left
        for(int i=0;i<n;++i)
            if(board[i][0]=='O')
                dfs(board,connectedToEdge,i,0);

        //right
        for(int i=0;i<n;++i)
            if(board[i][m-1]=='O')
                dfs(board,connectedToEdge,i,m-1);
            
        //bottom
        for(int i=0;i<m;++i)
            if(board[n-1][i]=='O')
                dfs(board,connectedToEdge,n-1,i);

        for(int i=1;i<n-1;++i){
            for(int j=1;j<m-1;++j){
                if(connectedToEdge[i][j] && board[i][j]=='O') continue;
                else board[i][j]='X';
            }
        }
    }

    public void dfs(char[][] board, boolean[][] connectedToEdge, int i, int j){
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
        if(connectedToEdge[i][j]) return;
        if(board[i][j]=='X') return;

        connectedToEdge[i][j]=true;

        dfs(board, connectedToEdge, i+1,j);
        dfs(board, connectedToEdge, i-1,j);
        dfs(board, connectedToEdge, i,j+1);
        dfs(board, connectedToEdge, i,j-1);
    }
}