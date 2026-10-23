/*
"Mistakes? I've made them. But I keep moving forward."
- Geralt of Rivia, The Witcher 3: Wild Hunt
*/

class Solution {

    int boardSize;
    List<List<String>> answer;

    private class Pair {
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString(){
            return row+","+col;
        }

        @Override
        public boolean equals(Object o){
            if(o == this) return true;
            if(o == null || o.getClass()!= this.getClass()) return false;
            Pair pair = (Pair) o;
            return pair.row == this.row && pair.col == this.col;
        }

        @Override
        public int hashCode(){
            return Objects.hash(row, col);
        }
    }

    private void removeDiagonals(Set<Pair> tileLeft, int dcol, int drow, int row, int col){
        while(true){
            row += drow;
            col += dcol;

            if(row < 0 || col < 0 || row >= boardSize || col >= boardSize)
                break;

            Pair toRemove = new Pair(row, col);
            tileLeft.remove(toRemove);
        }
    }

    private List<String> buildValidPosition(Set<Pair> tilePlaced){
        List<String> list = new ArrayList<String>(Collections.nCopies(boardSize, ""));
        for(Pair pair : tilePlaced){

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<boardSize;++i){
                if(i == pair.col)
                    sb.append("Q");
                else
                    sb.append(".");
            }

            list.set(pair.row, sb.toString());
        }
        return list;
    }

    private void recursion(Set<Pair> tileLeft, Set<Pair> tilePlaced, int row, int col){
        tilePlaced.add(new Pair(row, col));

        //base conditions
        if(tilePlaced.size() == boardSize){
            List<String> validPos = buildValidPosition(tilePlaced);
            if(!answer.contains(validPos))
                answer.add(validPos);
            return;
        }
        if(tileLeft.size() == 0){
            //all positions exhausted, queens still remain to be placed
            return;
        }

        //remove the positions no longer valid

        //remove all vertical
        for(int i=0;i<boardSize;++i){
            Pair toRemove = new Pair(i,col);
            tileLeft.remove(toRemove);
        }

        //remove all horizontal
        for(int i=0;i<boardSize;++i){
            Pair toRemove = new Pair(row, i);
            tileLeft.remove(toRemove);
        }
        //remove all diagonals
        int r = row;
        int c = col;
        removeDiagonals(tileLeft, +1, +1, row, col);
        removeDiagonals(tileLeft, -1, +1, row, col);
        removeDiagonals(tileLeft, +1, -1, row, col);
        removeDiagonals(tileLeft, -1, -1, row, col);

        for(Pair pairCandidate : tileLeft){

            if(pairCandidate.row != row+1){
                continue;
            }

            Set<Pair> tileLeftCopy = new HashSet<>(tileLeft);
            Set<Pair> tilePlacedCopy = new HashSet<>(tilePlaced);

            recursion(tileLeftCopy, tilePlacedCopy, pairCandidate.row, pairCandidate.col);
        }

        return;
    }

    public void printBoard(Set<Pair> left, Set<Pair> placed, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the current coordinate exists in the set
                if (left.contains(new Pair(i, j))) {
                    System.out.print("[.] "); // Marker if the pair exists
                }
                else if(placed.contains(new Pair(i, j))){
                    System.out.print("[Q] ");
                }
                else {
                    System.out.print("[x] "); // Marker if the pair doesn't exist
                }
            }
            System.out.println(); // Newline at the end of each row
        }
    }

    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<List<String>>();
        boardSize = n;
        Set<Pair> initialTileLeft = new HashSet<>();

        for (int k = 0; k < n; ++k) {
            for (int l = 0; l < n; ++l) {
                initialTileLeft.add(new Pair(k, l));
            }
        }

        for(int col=0;col<n;++col){
            Set<Pair> tileLeft = new HashSet<>(initialTileLeft);
            recursion(tileLeft, new HashSet<Pair>(), 0, col);
        }

        return answer;
    }
}
