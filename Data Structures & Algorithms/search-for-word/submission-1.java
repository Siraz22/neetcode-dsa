/*
"उनकी तारीफ में कहें क्या, अल्फाज़ ही नहीं हैं
जो कुछ मेरा है सब कुछ, उनका"
- Hamza Malik, Alfaaz
*/

class Solution {
    boolean[][] seen;
    boolean found = false;

    public void recursion(char[][] board, String word, int row, int col, int pos){
        if(found) 
            return;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;
        else if(seen[row][col] == true)
            return;
        else if(word.charAt(pos) != board[row][col])
            return;
        else if(word.charAt(pos) == board[row][col] && pos == word.length()-1){
            found = true;
            return;
        }

        //else it's a match
        seen[row][col] = true;
        recursion(board, word, row+1, col, pos+1);
        recursion(board, word, row-1, col, pos+1);
        recursion(board, word, row, col+1, pos+1);
        recursion(board, word, row, col-1, pos+1);

        //backtrack and reset for other paths
        seen[row][col] = false;
    }

    public boolean exist(char[][] board, String word) {
        seen = new boolean[board.length][board[0].length];
                
        for(int i = 0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(!seen [i][j] && board[i][j] == word.charAt(0)){
                    recursion(board, word, i ,j, 0);
                    if(found)
                        return true;
                }
            }
        }
        return false;
    }
}