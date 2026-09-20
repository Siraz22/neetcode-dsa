/*
"And may it never change us"
- Federico Auditore, Assassins's Creed II
*/

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        
        List<String> answer = new ArrayList<>();
        int i=0;

        while(i < str.length()){
            int delimiter = str.indexOf("#",i);
            int length = Integer.parseInt(str.substring(i,delimiter));
            int wordStartIndex = delimiter+1;
            String word = str.substring(wordStartIndex, wordStartIndex +length);
            answer.add(word);
            i = wordStartIndex + length;
        }
        
        return answer;
    }

}
