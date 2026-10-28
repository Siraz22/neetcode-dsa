/*
"Who Dares Wins"
- Special Air Service
*/

class Solution {

    List<String> answer;
    char[][] numToDigit;

    public void recursion(String digits, int pos, StringBuilder output){
        if(pos == digits.length()){
            answer.add(new String(output.toString()));
            return;
        }
        
        int indexPressed = Character.getNumericValue(digits.charAt(pos))-2;

        //explore all chars of pressed index
        for(int i=0;i<numToDigit[indexPressed].length;++i){
            output.append(numToDigit[indexPressed][i]);
            recursion(digits, pos+1, output);
            //backtrack prev entry
            output.setLength(output.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<String>();
        numToDigit = new char[][]{
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
        };

        if(digits.length() > 0)
            recursion(digits, 0, new StringBuilder());
            
        return answer;
    }
}