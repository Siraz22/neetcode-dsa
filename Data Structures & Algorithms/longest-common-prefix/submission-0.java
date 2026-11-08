/*
"I have this thing where I get older but just never wiser
Midnights become my afternoons"
- Taylor Swift, Anti-Hero
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        
        for(int i=0;i<strs.length;++i){
            minLen = Math.min(strs[i].length(), minLen);    
        }
        
        for(int charIter = 0; charIter < minLen; ++charIter){
            char toCheck = strs[0].charAt(charIter);
            for(int i=1; i< strs.length; ++i){
                if(strs[i].charAt(charIter) != toCheck){
                    return sb.toString();
                }
            }
            //gone through all without triggering break
            sb.append(toCheck);
        }
        
        return sb.toString();
    }
}