/*
"It's funny,
because I usually don't get shy that easily"
- Raya P
*/

class Solution {
    int[] memo;

    private int recursion(String s, int pos){
        //we decoded the whole string
        if(pos >= s.length()) return 1;
        if(s.charAt(pos) == '0') return 0;
        if(memo[pos]!=-1) return memo[pos];

        //choose only first num
        int choice1 = 0, choice2 = 0;
        if(pos < s.length()){
            choice1 = recursion(s, pos+1);
        }
        if(pos+1 < s.length() 
        && Integer.parseInt(s.substring(pos, pos+2)) <= 26){
            choice2 = recursion(s, pos+2);
        }

        return memo[pos] = choice1 + choice2;
    }

    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return recursion(s, 0);
    }
}