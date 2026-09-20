/*
"Big brother's coming in for overwatch"
- Lion, Rainbow 6 Siege
*/

class Solution {
    public int[] createKey(String s){
        int[] key = new int[26];
        for(char ch : s.toCharArray()){
            key[ch-'a']++;
        }
        return key;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String word : strs){
            int[] temp = createKey(word);
            String key = Arrays.toString(temp);
            if(map.containsKey(key)){
                map.get(key).add(word);
            }
            else{
                List<String> temp2 = new ArrayList<String>();
                temp2.add(word);
                map.put(key,temp2);
            }
        }

        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            answer.add(entry.getValue());
        }
        return answer;
    }
}
