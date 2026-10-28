/*
"Suika, look what's in front of you..."
"Isn't it sunflower?"
- Suika to Senku, Dr. Stone
*/

class Solution {
    List<List<String>> answer;

    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private void recursion(String input, List<String> output, int pos){
        if(pos == input.length())
            answer.add(new ArrayList<String>(output));
        
        for(int i=pos; i<input.length(); ++i){
            String substring = input.substring(pos, i+1);
            if(!isPalindrome(substring))
                continue;

            output.add(substring);
            recursion(input, output, i+1);
            output.remove(output.size()-1);
        }
    }

    public List<List<String>> partition(String s) {
        answer = new ArrayList<List<String>>();
        recursion(s, new ArrayList<String>(), 0);
        return answer;
    }
}