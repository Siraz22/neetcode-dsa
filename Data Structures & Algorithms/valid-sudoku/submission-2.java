/*
"Did I ever tell you the definition of insanity?" 
– Vaas, Far Cry 3
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //check each row
        for(int i=0;i<board.length;++i){
            Set<Character> set = new HashSet<>();
            for(int j=0;j<board[0].length;++j){
                if(set.contains(board[i][j]) && board[i][j]!='.') {
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        //check for each col
        for(int j=0;j<board[0].length;++j){
            Set<Character> set = new HashSet<>();
            for(int i=0;i<board.length;++i){
                if(set.contains(board[i][j]) && board[i][j]!='.') {
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        //checking squares
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                Set<Character> set = new HashSet<>();
                for(int row=i;row<i+3;row++){
                    for(int col=j;col<j+3;col++){
                        if(set.contains(board[row][col]) && board[row][col]!='.') {
                            return false;
                        }
                        set.add(board[row][col]);
                    }
                }
            }
        }

        return true;
    }
}
