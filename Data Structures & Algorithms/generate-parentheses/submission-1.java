/*
"And I don't want the world to see me"
- Iris, The Goo Goo Dolls
*/

class Solution {

    private void recursion(List<String> answer, int openCount, int closeCount, int limit, StringBuilder curr){
        //System.out.println(curr.toString() +"->"+openCount+","+closeCount);
        
        if(closeCount > openCount){
            return;
        }
        if(openCount == limit && closeCount == limit){
            answer.add(curr.toString());
            return;
        }

        //choice 1 - put '('
        if(openCount < limit){
            recursion(answer, openCount+1, closeCount, limit, curr.append('('));
            curr.setLength(curr.length() - 1);
        }
        //choice 2 - put ')'
        if(closeCount < limit){
            recursion(answer, openCount, closeCount+1, limit, curr.append(')'));
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        recursion(answer, 0, 0, n, new StringBuilder());
        return answer;
    }
}